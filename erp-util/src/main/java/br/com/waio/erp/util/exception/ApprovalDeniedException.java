package br.com.waio.erp.util.exception;

import javax.ejb.ApplicationException;

import br.com.waio.erp.util.Messages;

/**
 * A <tt>ApprovalDeniedException</tt> transporta informações do erro de aprovação inválida.
 *
 * @author <a href="mail:fabio.zanardi@w2z.com.br">Fábio Zanardi</a>
 * @since 4.2.0
 */
@ApplicationException(rollback = true)
public class ApprovalDeniedException extends Exception {

	/**
	 * Serial version da classe.
	 */
	private static final long serialVersionUID = -292882469979051668L;

	/**
	 * Construtor.
	 */
	public ApprovalDeniedException() {
		super(Messages.getMessage(ApprovalDeniedException.class));
	}

}
