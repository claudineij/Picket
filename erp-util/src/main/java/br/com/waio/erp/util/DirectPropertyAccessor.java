package br.com.waio.erp.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import br.com.waio.erp.util.exception.PropertyException;

/**
 * Utilitário para acessar propriedade de objeto diretamente.
 *
 * @since 2.0.7
 *
 * @param <T> Objeto a ser utilizado
 *
 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
 */
public final class DirectPropertyAccessor<T> {

	/**
	 * Classe do objeto a ser utilizado.
	 */
	private final Class<?> clazz;

	/**
	 * Objeto a ser utilizado.
	 */
	private final T object;

	/**
	 * Construtor.
	 *
	 * @param object Objeto a ser utilizado
	 */
	public DirectPropertyAccessor(final T object) {
		if (Validator.isEmpty(object)) {
			throw new IllegalArgumentException("Classe a ser utilizada não pode ser nula");
		}

		this.object = object;
		this.clazz = object.getClass();
	}

	/**
	 * Retorna o valor da propriedade.<br /><br />
	 *
	 * Exemplo de como utilizar:
	 * <pre>
	 * final DirectPropertyAccessor<T> propertyAccessor = new DirectPropertyAccessor<T>(objeto);
	 * if (Validator.isEmpty(propertyAccessor.get("nomeDoAtributo"))) {
	 *
	 * }
	 * </pre>
	 *
	 * @param name Nome da propriedade
	 *
	 * @return Valor da propriedade
	 *
	 * @throws PropertyException Não foi possível acessar o valor
	 */
	public Object get(final String name) throws PropertyException {
		try {
			final Field field = getField(clazz, name);
			return field.get(object);
		} catch (final Exception e) {
			throw new PropertyException(name, clazz.getSimpleName(), e);
		}
	}

	/**
	 * Seta valor na propriedade.<br /><br />
	 *
	 * Exemplo de como utilizar:
	 * <pre>
	 * final DirectPropertyAccessor<T> propertyAccessor = new DirectPropertyAccessor<T>(objeto);
	 * propertyAccessor.set("nomeDoAtributo", "valorDoAtributo");
	 * </pre>
	 *
	 * @param name Nome da propriedade
	 * @param value Valor a ser setado propriedade
	 *
	 * @throws PropertyException Não foi possível acessar o valor
	 */
	public void set(final String name, final Object value) throws PropertyException {
		try {
			final Field field = getField(clazz, name);
			field.set(object, value);
		} catch (final Exception e) {
			throw new PropertyException(name, clazz.getSimpleName(), e);
		}
	}

	/**
	 * Recupera o propriedade da classe.
	 *
	 * @param root Classe da propriedade
	 * @param name Nome da propriedade
	 *
	 * @return Propriedade do tipo {@link Field}
	 */
	private Field getField(final Class<?> root, final String name) {
		Field field;
		try {
			field = root.getDeclaredField(name);
		} catch (final NoSuchFieldException nsfe) {
			field = getField(root.getSuperclass(), name);
		}

		if (!isPublic(field)) {
			field.setAccessible(true);
		}

		return field;
	}

	/**
	 * Verifica se o método e classe são publicos.
	 *
	 * @param field Propriedade do tipo {@link Field}
	 *
	 * @return Se for público retorna true, senão false
	 */
	private boolean isPublic(final Field field) {
		return Modifier.isPublic(field.getModifiers());
	}

}
