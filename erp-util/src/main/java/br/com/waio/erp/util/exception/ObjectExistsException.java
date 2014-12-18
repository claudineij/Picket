package br.com.waio.erp.util.exception;

import javax.ejb.ApplicationException;

import br.com.waio.erp.util.Messages;

/**
 * A <tt>ObjectExistsException</tt> transporta informações do erro de objeto já existente.
 *
 * @author Waio Solucoes em TI
 * @since 2.0.0
 */
@ApplicationException(rollback = true)
public class ObjectExistsException extends Exception {

	/**
	 * Serial version da classe.
	 */
	private static final long serialVersionUID = -3660062768390934846L;

	/**
	 * Construtor.
	 *
	 * @param entity toString() da entidade
	 */
	public ObjectExistsException(final String entity) {
		super(Messages.getMessage(ObjectExistsException.class, entity));
	}

	/**
	 * Construtor.
	 *
	 * @param entity toString() da entidade
	 * @param cause Causa da exceção
	 */
	public ObjectExistsException(final String entity, final Throwable cause) {
		super(Messages.getMessage(ObjectExistsException.class, entity), cause);
	}

}
