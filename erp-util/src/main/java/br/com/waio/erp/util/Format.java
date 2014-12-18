package br.com.waio.erp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utilitário para aplicação de formatos.
 *
 * @since 3.4.0
 *
 * @author <a href="mail:fabio.zanardi@w2z.com.br">Fábio Zanardi</a>
 */
public final class Format {

	/**
	 * Formato data.
	 */
	public static final String DATE = "yyyy-MM-dd";

	/**
	 * Formato hora e minuto.
	 */
	public static final String HOUR_MINUTE = "HH:mm";

	/**
	 * Construtor privado.
	 */
	private Format() {

	}

	/**
	 * Efetua formatação da data.<br /><br />
	 *
	 * Exemplo de como utilizar:
	 * <pre>
	 * Date value = Mask.date(new Date(), "yyyy-MM-dd");
	 * </pre>
	 *
	 * @param date Valor a ser formatado
	 * @param format Formato da data
	 *
	 * @return Data formatada conforme formato do tipo {@link Date}
	 */
	public static Date date(final Date date, final String format) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return date(dateFormat.format(date), format);
	}

	/**
	 * Efetua formatação da data.<br /><br />
	 *
	 * Exemplo de como utilizar:
	 * <pre>
	 * Date value = Mask.date("12-12-2012", "yyyy-MM-dd");
	 * </pre>
	 *
	 * @param date Valor a ser formatado
	 * @param format Formato da data
	 *
	 * @return Data formatada conforme formato do tipo {@link Date}
	 */
	public static Date date(final String date, final String format) {
		try {
			final SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			return dateFormat.parse(date);
		} catch (final ParseException e) {
			throw new IllegalArgumentException("cannotConvertDate", e);
		}
	}

}
