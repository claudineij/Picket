package br.com.waio.erp.util.exception;

import javax.ejb.ApplicationException;

import br.com.waio.erp.util.Messages;

/**
 * A <tt>ObjectNotFoundException</tt> transporta informações do erro de objeto inexistente.
 *
 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
 * @since 2.0.0
 */
@ApplicationException(rollback = true)
public class ObjectNotFoundException extends Exception {

	/**
	 * Serial version da classe.
	 */
	private static final long serialVersionUID = -3660062768390934846L;

	/**
	 * Construtor.
	 *
	 * @param entity toString() da entidade
	 */
	public ObjectNotFoundException(final String entity) {
		super(Messages.getMessage(ObjectNotFoundException.class, entity));
	}

	/**
	 * Construtor.
	 *
	 * @param entity toString() da entidade
	 * @param cause Causa da exceção
	 */
	public ObjectNotFoundException(final String entity, final Throwable cause) {
		super(Messages.getMessage(ObjectNotFoundException.class, entity), cause);
	}

}
