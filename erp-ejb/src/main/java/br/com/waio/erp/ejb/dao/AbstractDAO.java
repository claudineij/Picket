package br.com.waio.erp.ejb.dao;

import java.io.Serializable;
import java.util.List;

import br.com.waio.erp.ejb.dto.Filter;
import br.com.waio.erp.ejb.dto.Pagination;
import br.com.waio.erp.util.exception.ChangeCollisionException;
import br.com.waio.erp.util.exception.ERPConstraintViolationException;
import br.com.waio.erp.util.exception.FieldInvalidException;
import br.com.waio.erp.util.exception.ObjectEmptyException;
import br.com.waio.erp.util.exception.ObjectExistsException;
import br.com.waio.erp.util.exception.ObjectNotFoundException;

/**
 * Interface genérica do DAO.
 *
 * @param <T> Entidade referente ao DAO.
 * @param <I> O tipo da chave primária.
 *
 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
 *
 */
public interface AbstractDAO<T extends Serializable, I> {

	/**
	 * Criar entidade.
	 *
	 * @param entity Entidade do tipo {@link T}
	 *
	 * @throws ObjectEmptyException Objeto em branco
	 * @throws FieldInvalidException Campo inválido
	 * @throws ObjectExistsException Objeto já existe
	 */
	void save(T entity) throws ObjectEmptyException, FieldInvalidException, ObjectExistsException;

	/**
	 * Recupera um registro da entidade por código.
	 *
	 * @param pk Código do registro
	 * @return Entidade do tipo {@link T}
	 *
	 * @throws FieldInvalidException Campo inválido
	 * @throws ObjectNotFoundException Objeto não encontrado
	 */
	T getById(I pk) throws FieldInvalidException, ObjectNotFoundException;

	/**
	 * Atualiza entidade.
	 *
	 * @param entity Entidade do tipo {@link T}
	 *
	 * @throws ObjectEmptyException Objeto em branco
	 * @throws FieldInvalidException Campo inválido
	 * @throws ObjectExistsException Objeto já existe
	 * @throws ChangeCollisionException Objeto já está sendo editado
	 */
	void update(T entity) throws ObjectEmptyException, FieldInvalidException, ObjectExistsException,
			ChangeCollisionException;

	/**
	 * Remove entidade por código.
	 *
	 * @param pk Código da entidade a ser removido.
	 *
	 * @throws FieldInvalidException Campo inválido
	 * @throws ObjectNotFoundException Objeto não encontrado
	 * @throws ERPConstraintViolationException Violação de chave
	 */
	void remove(I pk) throws FieldInvalidException, ObjectNotFoundException, ERPConstraintViolationException;

	/**
	 * Listagem de registro conforme o filtro.
	 *
	 * @param pagination Parâmetros de paginação
	 * @return {@link List} do tipo {@link T}
	 */
	List<T> list(Pagination pagination);

	/**
	 * Conta o total de registros conforme o filtro.
	 *
	 * @param filters {@link List} de parâmetros do tipo {@link Filter}
	 * @return Total registro da entidade
	 */
	int countTotal(List<Filter> filters);

}
