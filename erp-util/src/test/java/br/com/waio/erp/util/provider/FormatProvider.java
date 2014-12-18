package br.com.waio.erp.util.provider;

import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.DataProvider;

/**
 * Dados para execução dos teste da {@link br.com.waio.erp.util.FormatTest}.
 *
 * @since 3.4.0
 *
 * @author <a href="mail:fabio.zanardi@w2z.com.br">Fábio Zanardi</a>
 */
public final class FormatProvider {

	/**
	 * Construtor privado.
	 */
	private FormatProvider() {

	}

	/**
	 * Dados para o teste do {@link br.com.waio.erp.util.FormatTest#shouldFormatDate(String, String, Calendar)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] formatDate() {
		final String date = "07/06/2013 12:15:10";
		final String time = "12:15:10";
		return new Object[][] {
				{ date, "dd", new Date(529200000L) },
				{ date, "dd/MM", new Date(13575600000L) },
				{ date, "dd/MM/yyyy", new Date(1370574000000L) },
				{ date, "dd/MM/yyyy HH:mm", new Date(1370618100000L) },
				{ date, "HH", new Date(36000000L) },
				{ time, "HH:mm", new Date(54900000L) },
				{ time, "HH:mm:ss", new Date(54910000L) }
		};
	}

	/**
	 * Dados para o teste do {@link br.com.waio.erp.util.FormatTest#shouldFormatDateWithoutTime(java.util.Date, String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] formatDateWithoutTime() {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(1047600000);

		return new Object[][] {
				{ 1121212121L, calendar }
		};
	}

	/**
	 * Dados para o teste do {@link br.com.waio.erp.util.FormatTest#shouldNotFormatDate(String, String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] notFormatDateWithInvalidFormat() {
		return new Object[][] {
				{ "07-10-2013", "dd/yyyy" },
				{ "07/06/2013 12:15", "yyyy HH" }
		};
	}
	
	/**
	 * Dados para o teste do 
	 * {@link br.com.waio.erp.util.FormatTest#shouldNotFormatDateWithInvalidFormat(java.util.Date, String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] formatDateWithInvalidFormat() {
		return new Object[][] {
				{ "YYYY-mm-dd aa:bb:cc" },
				{ "xyzh-ij-kl" },
				{ "invalid-format" },
				{ "aaaa-cc-xx" }
		};
	}
	
	/**
	 * Dados para o teste do 
	 * {@link br.com.waio.erp.util.FormatTest#shouldFormatDateWithHourAndMinute(String, String, Calendar)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] formatTime() {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(84360000);

		return new Object[][] {
				{ 1121212121L, calendar }
		};
	}

}
