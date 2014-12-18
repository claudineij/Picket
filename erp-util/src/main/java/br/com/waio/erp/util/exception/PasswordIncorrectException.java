package br.com.waio.erp.util.exception;

import javax.ejb.ApplicationException;

import br.com.waio.erp.util.Messages;

/**
 * A <tt>PasswordIncorrectException</tt> transporta informações do erro de senha incorreta.
 *
 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
 * @since 2.0.2
 */
@ApplicationException(rollback = true)
public class PasswordIncorrectException extends Exception {

	/**
	 * Serial version da classe.
	 */
	private static final long serialVersionUID = -3660062768390934846L;

	/**
	 * Construtor.
	 */
	public PasswordIncorrectException() {
		super(Messages.getMessage(PasswordIncorrectException.class));
	}

}
