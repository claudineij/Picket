package br.com.waio.erp.util.exception;

import javax.ejb.ApplicationException;

import br.com.waio.erp.util.Messages;

/**
 * A <tt>FieldDuplicatedException</tt> transporta informações do erro de campo duplicado.
 *
 * @author <a href="mail:fabio.zanardi@w2z.com.br">Fábio Zanardi</a>
 * @since 2.0.5
 */
@ApplicationException(rollback = true)
public class FieldDuplicatedException extends Exception {

	/**
	 * Serial version da classe.
	 */
	private static final long serialVersionUID = -89793247664763647L;

	/**
	 * Nome do campo.
	 */
	private final String field;

	/**
	 * Construtor.
	 *
	 * @param field Nome do campo
	 */
	public FieldDuplicatedException(final String field) {
		super(Messages.getMessage(FieldDuplicatedException.class, field));
		this.field = field;
	}

	/**
	 * @return valor do field
	 */
	public String getField() {
		return field;
	}

}
