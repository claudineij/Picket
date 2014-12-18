package br.com.waio.erp.util.exception;

import javax.ejb.ApplicationException;

import br.com.waio.erp.util.Messages;

/**
 * A <tt>UserInvalidException</tt> transporta informações do erro de usuário inválido.
 *
 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
 * @since 2.0.0
 */
@ApplicationException(rollback = true)
public class UserInvalidException extends Exception {

	/**
	 * Serial version da classe.
	 */
	private static final long serialVersionUID = -6023318071822597353L;

	/**
	 * Construtor.
	 *
	 * @param user toString() da entidade usuário
	 */
	public UserInvalidException(final String user) {
		super(Messages.getMessage(UserInvalidException.class, user));
	}

}
