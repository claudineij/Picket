package br.com.waio.erp.util.exception;

import javax.ejb.ApplicationException;

/**
 * A <tt>IllegalHandlingException</tt> transporta informações do erro de objeto que não pode ser alterado.
 *
 * @since 2.0.2
 *
 * @author <a href="mail:claudinei.sartori@w2z.com.br">Claudinei Sartori</a>
 */
@ApplicationException(rollback = true)
public class IllegalHandlingException extends Exception {

	/**
	 * Serial version da classe.
	 */
	private static final long serialVersionUID = -6217867539659479033L;

	/**
	 * Chave da mensagem a ser recuperada do bundle.
	 */
	private final String keyBundle;

	/**
	 * Construtor.
	 *
	 * @param keyBundle Chave da mensagem a ser recuperada do bundle
	 * @param message Descrição da exceção
	 */
	public IllegalHandlingException(final String keyBundle, final String message) {
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
