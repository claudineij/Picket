package br.com.waio.erp.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Calendar;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.waio.erp.util.provider.FormatProvider;

/**
 * Teste referente as {@link Format}.
 *
 * @since 3.4.0
 *
 * @author <a href="mail:fabio.zanardi@w2z.com.br">Fábio Zanardi</a>
 */
@Test(dataProviderClass = FormatProvider.class, groups = { "util", "format" })
public class FormatTest {

	/**
	 * Teste para o construtor privado.
	 *
	 * @throws Throwable Possíveis erros
	 */
	@Test
	public void shouldConstructorPrivate() throws Throwable {
		final Constructor<?> constructor = Format.class.getDeclaredConstructor((Class<?>[]) null);
		final int constructorModifiers = constructor.getModifiers();

		Assert.assertTrue(Modifier.isPrivate(constructorModifiers));

		constructor.setAccessible(true);
		constructor.newInstance((Object[]) null);
	}

	/**
	 * Teste para o método {@link Format#date(String, String)} com sucesso.
	 *
	 * @param actual Valor para data
	 * @param format Formato de retorno da data
	 * @param expected Valor de retorno da data
	 */
	@Test(dataProvider = "formatDate")
	public void shouldFormatDate(final String actual, final String format, final Date expected) {
		Assert.assertEquals(Format.date(actual, format).getTime(), expected.getTime());
	}

	/**
	 * Teste para o método {@link Format#date(Date, String)} com sucesso.
	 *
	 * @param actual Valor para data
	 * @param expected Valor de retorno da data
	 */
	@Test(dependsOnMethods = "shouldFormatDate", dataProvider = "formatDateWithoutTime")
	public void shouldFormatDateWithoutTime(final Long actual, final Calendar expected) {
		Assert.assertEquals(Format.date(new Date(actual), Format.DATE).getTime(), expected.getTimeInMillis());
	}

	/**
	 * Teste para o método {@link Format#date(String, String)} sem sucesso.
	 *
	 * @param actual Valor para data
	 * @param format Formato de retorno da data
	 */
	@Test(dependsOnMethods = "shouldFormatDate", dataProvider = "notFormatDateWithInvalidFormat",
			expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "cannotConvertDate")
	public void shouldNotFormatDateWithInvalidFormat(final String actual, final String format) {
		Format.date(actual, format);
	}

	/**
	 * Teste para o método {@link Format#date(Date, String)} sem sucesso.
	 *
	 * @param actual Valor para formato
	 */
	@Test(dependsOnMethods = "shouldFormatDate", dataProvider = "formatDateWithInvalidFormat",
			expectedExceptions = IllegalArgumentException.class,
			expectedExceptionsMessageRegExp = "Illegal pattern character.*")
	public void shouldNotFormatDateWithInvalidFormat(final String actual) {
		Format.date(new Date(), actual);
	}

	/**
	 * Teste para o método {@link Format#time(Date, String) com sucesso.
	 *
	 * @param actual Valor para data
	 * @param expected Valor de retorno da hora e minuto
	 */
	@Test(dependsOnMethods = "shouldFormatDate", dataProvider = "formatTime")
	public void shouldFormatDateWithHourAndMinute(final Long actual, final Calendar expected) {
		Assert.assertEquals(Format.date(new Date(actual), Format.HOUR_MINUTE).getTime(), expected.getTimeInMillis());
	}

}
