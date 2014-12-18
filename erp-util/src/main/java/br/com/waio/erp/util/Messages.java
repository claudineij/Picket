package br.com.waio.erp.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * Constante de mensagens da camada Util.
 *
 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
 * @since 4.0.0
 */
public final class Messages {

	/**
	 * Bundle de mensagem.
	 */
	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("messages");

	/**
	 * Construtor privado.
	 */
	private Messages() {

	}

	/**
	 * Recupera uma mensagem do bundle conforme a classe.
	 *
	 * @param clazz Classe referente a chave
	 *
	 * @return Mensagem da chave
	 */
	public static String getMessage(final Class<? extends Exception> clazz) {
		return getMessage(clazz, null);
	}

	/**
	 * Recupera uma mensagem do bundle conforme a classe e repassa os valores pelo parâmetros.
	 *
	 * @param clazz Classe referente a chave
	 * @param parameters Parâmetros a serem repassado
	 *
	 * @return Mensagem da chave
	 */
	public static String getMessage(final Class<? extends Exception> clazz, final Object... parameters) {
		final String key = clazz.getSimpleName();
		return getMessage(key, parameters);
	}

	/**
	 * Recupera uma mensagem do bundle conforme a chave.
	 *
	 * @param key Chave referente a chave
	 *
	 * @return Mensagem da chave
	 */
	public static String getMessage(final String key) {
		return getMessage(key, null);
	}

	/**
	 * Recupera uma mensagem do bundle conforme a chave e repassa os valores pelo parâmetros.
	 *
	 * @param key Chave referente a chave
	 * @param parameters Parâmetros a serem repassado
	 *
	 * @return Mensagem da chave
	 */
	public static String getMessage(final String key, final Object... parameters) {
		final Object[] params = parameters != null ? parameters : new Object[0];
		return MessageFormat.format(BUNDLE.getString(key), params);
	}

}
