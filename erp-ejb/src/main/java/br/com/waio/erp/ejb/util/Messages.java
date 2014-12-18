package br.com.waio.erp.ejb.util;

import java.util.ResourceBundle;

/**
 * Constante de mensagens da camada EJB.
 *
 * @since 3.3.0
 *
 * @author <a href="mail:fabio.zanardi@w2z.com.br">Fábio Zanardi</a>
 */
public final class Messages {

	/**
	 * Bundle de mensagem.
	 */
	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("Messages");

	/**
	 * Mensagem de registro que não pode ser em branco.
	 */
	public static final String NOT_EMPTY = BUNDLE.getString("notEmpty");

	/**
	 * Mensagem de registro que deve ser em branco.
	 */
	public static final String EMPTY = BUNDLE.getString("empty");

	/**
	 * Mensagem de data que deve ser anterior a outra.
	 */
	public static final String DATE_MUST_BE_BEFORE = BUNDLE.getString("dateMustBeBefore");

	/**
	 * Construtor privado.
	 */
	private Messages() {

	}

	/**
	 * Recupera uma mensagem do bundle conforme a sua chave.
	 *
	 * @param key Chave da mensagem
	 *
	 * @return Mensagem da chave
	 */
	public static String getMessage(final String key) {
		return BUNDLE.getString(key);
	}

}
