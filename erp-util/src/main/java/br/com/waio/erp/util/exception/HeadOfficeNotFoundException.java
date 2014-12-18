package br.com.waio.erp.util.exception;

import javax.ejb.ApplicationException;

import br.com.waio.erp.util.Messages;

/**
 * A <tt>HeadOfficeNotFoundException</tt> transporta informações do erro de filial sem matriz.
 *
 * @author <a href="mail:claudinei.sartori@w2z.com.br">Claudinei Sartori</a>
 * @since 3.1.0
 */
@ApplicationException(rollback = true)
public class HeadOfficeNotFoundException extends Exception {

	/**
	 * Serial version da classe.
	 */
	private static final long serialVersionUID = 6188302079681332036L;

	/**
	 * Construtor.
	 *
	 * @param cnpj Número do CNPJ
	 */
	public HeadOfficeNotFoundException(final String cnpj) {
		super(Messages.getMessage(HeadOfficeNotFoundException.class, cnpj));
	}

}
