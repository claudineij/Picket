package br.com.waio.erp.util.exception;

import javax.ejb.ApplicationException;

import br.com.waio.erp.util.Messages;

/**
 * A <tt>ChangeCollisionException</tt> transporta informações do erro de objeto que já está sendo editado.
 *
 * @author Waio Solucoes em TI
 * @since 2.0.0
 */
@ApplicationException(rollback = true)
public class ChangeCollisionException extends Exception {

	/**
	 * Serial version da classe.
	 */
	private static final long serialVersionUID = -3777243018577104465L;

	/**
	 * Construtor.
	 *
	 * @param entity toString() da entidade
	 * @param cause Causa da exceção
	 */
	public ChangeCollisionException(final String entity, final Throwable cause) {
		super(Messages.getMessage(ChangeCollisionException.class, entity), cause);
	}

}
