package br.com.waio.erp.util.exception;

import javax.ejb.ApplicationException;

/**
 * A <tt>NotAvailableException</tt> transporta informações do erro de disponibilidade inválida.
 *
 * @author <a href="mail:filipi.nicolau@w2z.com.br">Filipi Nicolau</a>
 * @since 4.2.0
 */
@ApplicationException(rollback = true)
public class NotAvailableException extends Exception {

	/**
	 * Serial version da classe.
	 */
	private static final long serialVersionUID = -3628106570650058454L;

	/**
	 * Chave da mensagem a ser recuperada do bundle.
	 */
	private final String keyBundle;

	public NotAvailableException(final String keyBundle, final String message) {
		super(message);
		this.keyBundle = keyBundle;
	}

	/**
	 * @return valor do bundle
	 */
	public String getBundle() {
		return keyBundle;
	}
}
