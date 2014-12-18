package br.com.waio.erp.util.exception;

import javax.ejb.ApplicationException;

import br.com.waio.erp.util.Messages;

/**
 * A <tt>FileInvalidException</tt> transporta informações do erro de arquivo inválido.
 *
 * @since 4.3.0
 *
 * @author <a href="mail:fabio.zanardi@w2z.com.br">Fábio Zanardi</a>
 */
@ApplicationException(rollback = true)
public class FileInvalidException extends Exception {

	/**
	 * Serial version da classe.
	 */
	private static final long serialVersionUID = 1911682145739603697L;

	/**
	 * Construtor.
	 */
	public FileInvalidException() {
		super(Messages.getMessage(FileInvalidException.class));
	}

}
