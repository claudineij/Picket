package br.com.waio.erp.util.exception;

import javax.ejb.ApplicationException;

/**
 * A <tt>UserInvalidException</tt> transporta informações do erro de associoação inválida.
 *
 * @author <a href="mail:filipi.nicolau@w2z.com.br">Filipi Nicolau</a>
 * @since 4.2.0
 */
@ApplicationException(rollback = true)
public class InvalidAssociationException extends Exception {

	/**
	 * Serial version da classe.
	 */
	private static final long serialVersionUID = 4573001728052773209L;

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
	public InvalidAssociationException(final String keyBundle, final String message) {
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
