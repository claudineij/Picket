package br.com.waio.erp.util.exception;

import javax.ejb.ApplicationException;

import br.com.waio.erp.util.Messages;

/**
 * A <tt>UserHasGroupEmptyException</tt> transporta informações do erro de usuário não pertence ao grupo.
 *
 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
 * @since 2.0.0
 */
@ApplicationException(rollback = true)
public class UserHasGroupEmptyException extends Exception {

	/**
	 * Serial version da classe.
	 */
	private static final long serialVersionUID = 8004920555499297321L;

	/**
	 * Construtor.
	 *
	 * @param user Nome do usuário
	 */
	public UserHasGroupEmptyException(final String user) {
		super(Messages.getMessage(UserHasGroupEmptyException.class, user));
	}

}
