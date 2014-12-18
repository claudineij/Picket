package br.com.waio.erp.util.exception;

import javax.ejb.ApplicationException;

/**
 * A <tt>ERPConstraintViolationException</tt> transporta informações do erro de violação de chave.
 *
 * @since 2.0.0
 *
 * @author <a href="mail:fabio.zanardi@w2z.com.br">Fábio Zanardi</a>
 */
@ApplicationException(rollback = true)
public class ERPConstraintViolationException extends Exception {

	/**
	 * Serial version da classe.
	 */
	private static final long serialVersionUID = -3660062768390934846L;

	/**
	 * Construtor.
	 *
	 * @param message Descrição da exceção
	 * @param cause Causa da exceção
	 */
	public ERPConstraintViolationException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
