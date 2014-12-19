package br.com.waio.erp.ejb.dao;

import br.com.waio.erp.ejb.dto.Filter;
import br.com.waio.erp.ejb.dto.Join;
import br.com.waio.erp.ejb.dto.Pagination;
import br.com.waio.erp.ejb.dto.Sort;
import br.com.waio.erp.ejb.enums.Restriction;
import br.com.waio.erp.ejb.enums.SortOrder;
import br.com.waio.erp.ejb.util.Messages;
import br.com.waio.erp.util.DirectPropertyAccessor;
import br.com.waio.erp.util.Validator;
import br.com.waio.erp.util.exception.ChangeCollisionException;
import br.com.waio.erp.util.exception.ERPConstraintViolationException;
import br.com.waio.erp.util.exception.FieldInvalidException;
import br.com.waio.erp.util.exception.ObjectEmptyException;
import br.com.waio.erp.util.exception.ObjectExistsException;
import br.com.waio.erp.util.exception.ObjectNotFoundException;
import br.com.waio.erp.util.exception.PropertyException;
import org.apache.log4j.Logger;
import org.hibernate.StaleObjectStateException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import br.com.waio.erp.ejb.validator.ValidatorConstraint;

/**
 * Implementação genérica do DAO.
 *
 * @param <T> Entidade referente ao DAO.
 * @param <I> O tipo da chave primária.
 *
 * @author Fábio Zanardi | fabio.zanardi@waio.com.br
 * @author Vitor de Moraes | vitor.moraes@waio.com.br
 * @since 2.0.0
 */
public abstract class AbstractDAOImpl<T extends Serializable, I> implements AbstractDAO<T, I> {

	/**
	 * Obtendo o {@link EntityManager} injetado pelo {@link PersistenceContext} EntityManager
	 */
	@Inject
	private transient EntityManager em;

	/**
	 * Instância para o log4j.
	 */
	private static final Logger LOGGER = Logger.getLogger(AbstractDAOImpl.class);

	/**
	 * Entidade referente ao DAO.
	 */
	private final Class<T> type;

	/**
	 * Lista de joins para o {@link #list(Pagination)}.
	 */
	private final List<Join> joins;

	/**
	 * Lista de joins criados.
	 */
	private final Map<String, javax.persistence.criteria.Join<?, ?>> mapJoins;

	/**
	 * Campos que serão usado para verificação do {@link #is(T)}.
	 */
	private String[] fieldsIs;

	/**
	 * Criteria builder.
	 */
	private CriteriaBuilder criteriaBuilder;

	/**
	 * Mensagem para formato inválido {@link CriteriaBuilder}.
	 */
	private static final String TYPE_INVALID = "Tipo do valor deve ser %s para restrição %s";

	/**
	 * Construtor.
	 */
	@SuppressWarnings("unchecked")
	public AbstractDAOImpl() {
		type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		joins = new ArrayList<>();
		mapJoins = new HashMap<>();
	}

	/**
	 * Inicializador após a construtor.
	 */
	@PostConstruct
	public void init() {
		criteriaBuilder = em.getCriteriaBuilder();
	}

	@Override
	public void save(final T entity) throws ObjectEmptyException, FieldInvalidException, ObjectExistsException {
		try {
			checkRequired(entity, false);

			is(entity);
			em.persist(entity);
		} catch (final EntityExistsException e) {
			throw new ObjectExistsException(entity.toString(), e);
		}
	}

	@Override
	public T getById(final I pk) throws FieldInvalidException, ObjectNotFoundException {
		try {
			final T entity = em.find(type, pk);

			if (Validator.isEmpty(entity)) {
				throw new ObjectNotFoundException(type.getSimpleName() + " [" + pk.toString() + "]");
			}

			return entity;
		} catch (final IllegalArgumentException e) {
			throw new FieldInvalidException(Messages.NOT_EMPTY, Messages.getMessage("primaryKey"), e);
		}
	}

	@Override
	public void update(final T entity) throws ObjectEmptyException, FieldInvalidException, ObjectExistsException,
			ChangeCollisionException {
		try {
			checkRequired(entity, true);

			is(entity);
			em.merge(entity);
		} catch (StaleObjectStateException | OptimisticLockException e) {
			LOGGER.warn(Messages.getMessage("changeColision") + entity, e);
			throw new ChangeCollisionException(entity.toString(), e);
		}
	}

	@Override
	public void remove(final I pk) throws FieldInvalidException, ObjectNotFoundException,
			ERPConstraintViolationException {
		try {
			em.remove(getById(pk));
			em.flush();
		} catch (final PersistenceException e) {
			LOGGER.warn(e.getMessage(), e);
			throw new ERPConstraintViolationException(e.getMessage(), e);
		}
	}

	@Override
	public List<T> list(final Pagination pagination) {
		final CriteriaQuery<T> query = criteriaBuilder.createQuery(type);
		final Root<T> root = query.from(type);
		query.select(root);

		final TypedQuery<T> typedQuery = buildPagination(query, root, pagination);

		return typedQuery.getResultList();
	}

	@Override
	public int countTotal(final List<Filter> filters) {
		final CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
		final Root<T> root = query.from(type);

		buildFilters(filters, root, query);

		query.select(criteriaBuilder.countDistinct(root));

		return em.createQuery(query).getSingleResult().intValue();
	}

	/**
	 * Verifica se já existe registro da entidade cadastrado.
	 *
	 * @param entity Entidade a ser verificado
	 * @throws ObjectExistsException Objeto já cadastrado
	 * @throws ObjectEmptyException Objeto nulo
	 */
	protected void is(final T entity) throws ObjectExistsException, ObjectEmptyException {
		if (Validator.isEmpty(fieldsIs)) {
			return;
		}

		try {
			final CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
			final Root<T> root = query.from(type);

			final DirectPropertyAccessor<T> propertyAccessor = new DirectPropertyAccessor<>(entity);
			final List<Predicate> orPredicates = new ArrayList<>();
			for (final String field : fieldsIs) {
				orPredicates.add(criteriaBuilder.equal(root.get(field), propertyAccessor.get(field)));
			}

			query.where(criteriaBuilder.or(orPredicates.toArray(new Predicate[orPredicates.size()])));

			final Long idValue = (Long) propertyAccessor.get("id");
			if (!Validator.isEmpty(idValue)) {
				final Predicate predicate = criteriaBuilder.notEqual(root.get("id"), idValue);
				query.where(criteriaBuilder.and(query.getRestriction(), predicate));
			}

			query.select(criteriaBuilder.count(root));

			if (em.createQuery(query).getSingleResult() > 0) {
				throw new ObjectExistsException(entity.toString());
			}
		} catch (final PropertyException e) {
			LOGGER.warn(e.getMessage(), e);
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * Verificar entidade e campos em branco.
	 *
	 * @param entity Entidade do tipo {@link T}
	 * @param update Se a verificação é update
	 *
	 * @throws ObjectEmptyException Entidade nula
	 * @throws FieldInvalidException Campo inválido
	 */
	protected void checkRequired(final T entity, final boolean update) throws ObjectEmptyException,
			FieldInvalidException {
		if (Validator.isEmpty(entity)) {
			throw new ObjectEmptyException(type.getSimpleName());
		}

		if (update) {
			try {
				final DirectPropertyAccessor<T> propertyAccessor = new DirectPropertyAccessor<>(entity);
				if (Validator.isEmpty(propertyAccessor.get("id"))) {
					throw new FieldInvalidException(Messages.NOT_EMPTY, "id");
				}
			} catch (final PropertyException e) {
				throw new IllegalArgumentException(Messages.getMessage("idNotFound") + " " + entity.toString(), e);
			}
		}

		//ValidatorConstraint.validate(entity); TODO: remover comentario
	}

	/**
	 * Recupera o entity manager.
	 *
	 * @return {@link EntityManager}
	 */
	protected EntityManager getEm() {
		return em;
	}

	/**
	 * @return valor do criteriaBuilder
	 */
	public CriteriaBuilder getCriteriaBuilder() {
		return criteriaBuilder;
	}

	/**
	 * Adiciona uma join para {@link #list(Pagination)}.
	 *
	 * @param join Do tipo {@link Join}
	 */
	protected void addJoin(final Join join) {
		this.joins.add(join);
	}

	/**
	 * Setar a lista de campos para {@link #is(T)}.
	 *
	 * @param fieldsIs {@link List} de campos
	 */
	protected void setFieldsIs(final String[] fieldsIs) {
		this.fieldsIs = Arrays.copyOf(fieldsIs, fieldsIs.length);
	}

	/**
	 * Gerar os parâmetros da paginação.
	 *
	 * @param query {@link CriteriaQuery} a ser manipulada
	 * @param root Entidade da paginação.
	 * @param pagination Parâmetros da paginação
	 * @return do tipo {@link TypedQuery}
	 */
	protected TypedQuery<T> buildPagination(final CriteriaQuery<T> query, final Root<T> root,
			final Pagination pagination) {
		if (!Validator.isEmpty(pagination)) {
			buildFilters(pagination.getFilters(), root, query);
			buildOrders(pagination.getSorts(), root, query);
		}

		query.distinct(true);
		final TypedQuery<T> typedQuery = em.createQuery(query);
		if (!Validator.isEmpty(pagination)) {
			if (!Validator.isEmpty(pagination.getFirst())) {
				typedQuery.setFirstResult(pagination.getFirst());
			}

			if (!Validator.isEmpty(pagination.getPageSize())) {
				typedQuery.setMaxResults(pagination.getPageSize());
			}
		}

		return typedQuery;
	}

	/**
	 * Gerar filtros.
	 *
	 * @param filters {@link List} do tipo {@link Filter}
	 * @param root Entidade do filtro.
	 * @param query {@link CriteriaQuery} a ser manipulada
	 */
	@SuppressWarnings("unchecked")
	protected void buildFilters(final List<Filter> filters, final Root<T> root, final CriteriaQuery<?> query) {
		buildJoins(root);

		if (!Validator.isEmpty(filters)) {
			try {
				final List<Predicate> predicates = new ArrayList<>();
				for (final Filter filter : filters) {
					final String nameField = filter.getField();
					final Restriction restriction = filter.getRestriction();
					if (Validator.isEmpty(nameField) || Validator.isEmpty(restriction)) {
						throw new IllegalArgumentException("O filtro está incorreto: " + filter.toString());
					}

					final Object valueFilter = filter.getValue();
					if (valueFilter == null && restriction.isRequiredValue()) {
						throw new IllegalArgumentException("O valor é obrigatório para restrição " + restriction);
					}
					final List<Class<?>> parameterTypes = new ArrayList<>();
					final List<Object> arguments = new ArrayList<>();

					parameterTypes.add(Expression.class);
					arguments.add(this.getField(root, nameField));

					switch (restriction) {
						case EQUAL:
						case NOT_EQUAL:
							parameterTypes.add(Object.class);
							arguments.add(valueFilter);
							break;

						case GREATER_THAN:
							if (!(valueFilter instanceof Date)) {
								throw new IllegalArgumentException(String.format(TYPE_INVALID, "date", restriction));
							}

							arguments.clear();
							Path<Date> datePath = root.get(nameField);
							predicates.add(getCriteriaBuilder().greaterThan(datePath, (Date) valueFilter));
							parameterTypes.add(Expression.class);
							break;
						case GREATER_THAN_OR_EQUAL_TO:
							if (!(valueFilter instanceof Date)) {
								throw new IllegalArgumentException(String.format(TYPE_INVALID, "date", restriction));
							}

							arguments.clear();
							datePath = root.get(nameField);
							predicates.add(getCriteriaBuilder().greaterThanOrEqualTo(datePath, (Date) valueFilter));
							parameterTypes.add(Expression.class);
							break;
						case LESS_THAN:
							if (!(valueFilter instanceof Date)) {
								throw new IllegalArgumentException(String.format(TYPE_INVALID, "date", restriction));
							}

							arguments.clear();
							datePath = root.get(nameField);
							predicates.add(getCriteriaBuilder().lessThan(datePath, (Date) valueFilter));
							parameterTypes.add(Expression.class);
							break;
						case LESS_THAN_OR_EQUAL_TO:
							if (!(valueFilter instanceof Date)) {
								throw new IllegalArgumentException(String.format(TYPE_INVALID, "date", restriction));
							}

							arguments.clear();
							datePath = root.get(nameField);
							predicates.add(getCriteriaBuilder().lessThanOrEqualTo(datePath, (Date) valueFilter));
							parameterTypes.add(Expression.class);
							break;

						case GT:
						case GE:
						case LT:
						case LE:
							if (!(valueFilter instanceof Number)) {
								throw new IllegalArgumentException(String.format(TYPE_INVALID, "number", restriction));
							}

							parameterTypes.add(Number.class);
							arguments.add(valueFilter);
							break;

						case IS_MEMBER:
						case IS_NOT_MEMBER:
							parameterTypes.clear();
							arguments.clear();

							parameterTypes.add(Object.class);
							parameterTypes.add(Expression.class);
							arguments.add(valueFilter);
							arguments.add(this.<List<?>> getField(root, nameField));
							break;

						case LIKE:
						case LIKE_START:
						case LIKE_END:
						case ILIKE:
						case ILIKE_START:
						case ILIKE_END:
							if (!(valueFilter instanceof String)) {
								throw new IllegalArgumentException(String.format(TYPE_INVALID, "string", restriction));
							}

							String valueFilterLike = valueFilter.toString();
							if (restriction.name().contains("ILIKE")) {
								arguments.set(0, criteriaBuilder.upper((Expression<String>) arguments.get(0)));
								valueFilterLike = valueFilterLike.toUpperCase();
							}

							final StringBuilder builder = new StringBuilder(valueFilterLike);
							if (restriction.name().contains("START")) {
								builder.insert(0, "%");
							} else if (restriction.name().contains("END")) {
								builder.append("%");
							} else {
								builder.insert(0, "%");
								builder.append("%");
							}

							parameterTypes.add(String.class);
							arguments.add(builder.toString());
							break;

						case IN:
						case NOT_IN:
							if (!(valueFilter instanceof Collection<?>)) {
								throw new IllegalArgumentException(String.format(TYPE_INVALID, "collection",
																				 restriction));
							}

							parameterTypes.clear();
							arguments.clear();
							final Predicate in = getField(root, nameField).in(valueFilter);
							if (Restriction.IN.equals(restriction)) {
								predicates.add(in);
							} else {
								predicates.add(criteriaBuilder.not(in));
							}
							break;

						case IN_JOIN:
						case NOT_IN_JOIN:
							parameterTypes.clear();
							arguments.clear();

							final Predicate inJoin = root.join(nameField).in(valueFilter);
							if (Restriction.IN_JOIN.equals(restriction)) {
								predicates.add(inJoin);
							} else {
								predicates.add(criteriaBuilder.not(inJoin));
							}
							break;

						case BETWEEN:
							final Object secondValueFilter = filter.getSecondValue();
							if (Validator.isEmpty(secondValueFilter)) {
								throw new IllegalArgumentException("O segundo valor é obrigatório para restrição "
																   + restriction);
							}

							parameterTypes.add(Object.class);
							parameterTypes.add(Object.class);
							arguments.add(valueFilter);
							arguments.add(secondValueFilter);
							break;

						default:
							break;
					}

					if (!Validator.isEmpty(parameterTypes) && !Validator.isEmpty(arguments)) {
						final Predicate predicate = invoke(restriction.getRestriction(),
														   parameterTypes.toArray(new Class<?>[parameterTypes.size()]), arguments.toArray());
						predicates.add(predicate);
					}
				}

				if (!Validator.isEmpty(predicates)) {
					query.where(predicates.toArray(new Predicate[predicates.size()]));
				}
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				LOGGER.warn(e.getMessage(), e);
				throw new IllegalArgumentException(e);
			}
		}
	}

	/**
	 * Gerar ordenação.
	 *
	 * @param sorts {@link List} do tipo {@link Sort}
	 * @param root Entidade da ordenação.
	 * @param query {@link CriteriaQuery} a ser manipulada
	 */
	protected void buildOrders(final List<Sort> sorts, final Root<T> root, final CriteriaQuery<T> query) {
		if (!Validator.isEmpty(sorts)) {
			final List<Order> orders = new ArrayList<>();
			for (final Sort sort : sorts) {
				if (!Validator.isEmpty(sort.getField())) {
					final Path<Object> field = getField(root, sort.getField());
					if (SortOrder.ASCENDING == sort.getOrder()) {
						orders.add(criteriaBuilder.asc(field));
					} else {
						orders.add(criteriaBuilder.desc(field));
					}
				}
			}

			query.orderBy(orders);
		}
	}

	/**
	 * Gerar os joins para o {@link #list(Pagination)}.
	 *
	 * @param root {@link Root} a ser manipulada
	 */
	private void buildJoins(final Root<?> root) {
		if (!Validator.isEmpty(joins)) {
			for (final Join join : joins) {
				final String[] names = getSubstring(join.getAssociation());
				if (names.length == 2) {
					mapJoins.put(join.getAssociation(), getJoin(names[0]).join(names[1], join.getType()));
				} else {
					mapJoins.put(join.getAssociation(), root.join(names[0], join.getType()));
				}
			}
		}
	}

	/**
	 * Recuperar um join conforme o a key.
	 *
	 * @param key Chave do join
	 * @return Join do tipo {@link Join}
	 */
	private javax.persistence.criteria.Join<?, ?> getJoin(final String key) {
		if (!mapJoins.containsKey(key)) {
			throw new IllegalArgumentException("Não foi possível localizar o join " + key);
		}

		return mapJoins.get(key);
	}

	/**
	 * Retorna campo da entidade.
	 *
	 * @param root {@link Root} a ser manipulada
	 * @param name Nome do campo
	 * @param <Y> Tipo de retorno
	 * @return do tipo {@link Path}
	 */
	private <Y> Path<Y> getField(final Root<T> root, final String name) {
		final String[] names = getSubstring(name);
		return names.length == 2 ? getJoin(names[0]).<Y> get(names[1]) : root.<Y> get(names[0]);
	}

	/**
	 * Quebra o texto em duas partes conforme o último ponto encontrado.
	 *
	 * @param text Texto a ser quebrado
	 * @return Texto antes e após o último ponto encontrado.
	 */
	private String[] getSubstring(final String text) {
		if (!Validator.isEmpty(text)) {
			final int pos = text.lastIndexOf('.');
			if (pos > 0) {
				return new String[] { text.substring(0, pos), text.substring(pos + 1) };
			}
		}

		return new String[] { text };
	}

	/**
	 * Invoca as restrição do filtro.
	 *
	 * @param methodName Nome do método
	 * @param parameterTypes Tipos de parâmetro
	 * @param args Argumentos usado para chamar a função
	 * @return restrição do tipo {@link Predicate}
	 *
	 * @throws IllegalAccessException Não foi possível acessar o método
	 * @throws InvocationTargetException Não foi possível invocar o método
	 * @throws NoSuchMethodException Método não encontrado
	 */
	private Predicate invoke(final String methodName, final Class<?>[] parameterTypes, final Object[] args)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		final Method method = CriteriaBuilder.class.getDeclaredMethod(methodName, parameterTypes);
		return (Predicate) method.invoke(criteriaBuilder, args);
	}

}
