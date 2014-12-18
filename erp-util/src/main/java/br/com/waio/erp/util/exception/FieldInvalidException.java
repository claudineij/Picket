package br.com.waio.erp.util.exception;

import javax.ejb.ApplicationException;

import br.com.waio.erp.util.Messages;

/**
 * A <tt>FieldInvalidException</tt> transporta informações do erro de Nome do campo.
 *
 * @author <a href="mail:claudinei.sartori@w2z.com.br">Claudinei Sartori</a>
 * @since 3.2.0
 */
@ApplicationException(rollback = true)
public class FieldInvalidException extends Exception {

	/**
	 * Serial version da classe.
	 */
	private static final long serialVersionUID = 8103871928863637444L;

	/**
	 * Nome do campo.
	 */
	private final String field;

	/**
	 * Construtor.
	 *
	 * @param field Nome do campo
	 */
	public FieldInvalidException(final String field) {
		super(Messages.getMessage(FieldInvalidException.class, field, Messages.getMessage("invalid")));
		this.field = field;
	}

	/**
	 * Construtor.
	 *
	 * @param message Mensagem do erro
	 * @param field Nome do campo
	 */
	public FieldInvalidException(final String message, final String field) {
		super(Messages.getMessage(FieldInvalidException.class, field, message));
		this.field = field;
	}

	/**
	 * Construtor.
	 *
	 * @param message Mensagem do erro
	 * @param field Nome do campo
	 * @param cause Causa da exceção
	 */
	public FieldInvalidException(final String message, final String field, final Throwable cause) {
		super(Messages.getMessage(FieldInvalidException.class, field, message), cause);
		this.field = field;
	}

	/**
	 * @return valor do field
	 */
	public String getField() {
		return field;
	}

}
