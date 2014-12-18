package br.com.waio.erp.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.waio.erp.util.provider.MaskProvider;

/**
 * Teste referente as {@link Mask}.
 *
 * @since 2.0.2
 *
 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
 */
@Test(dataProviderClass = MaskProvider.class, groups = { "util", "mask" })
public class MaskTest {

	/**
	 * Teste para o construtor privado.
	 *
	 * @throws Throwable Possíveis erros
	 */
	@Test
	public void shouldConstructorPrivate() throws Throwable {
		final Constructor<?> constructor = Mask.class.getDeclaredConstructor((Class<?>[]) null);
		final int constructorModifiers = constructor.getModifiers();

		Assert.assertTrue(Modifier.isPrivate(constructorModifiers));

		constructor.setAccessible(true);
		constructor.newInstance((Object[]) null);
	}

	/**
	 * Teste para o método {@link Mask#clear(String)} com sucesso.
	 *
	 * @param actual Valor para máscara
	 * @param expected Valor de retorno da máscara
	 */
	@Test(dataProvider = "clean")
	public void shouldClean(final String actual, final String expected) {
		Assert.assertEquals(Mask.clear(actual), expected);
	}

	/**
	 * Teste para o método {@link Mask#clear(String)} sem sucesso.
	 */
	@Test(expectedExceptions = { NullPointerException.class })
	public void shouldNotClean() {
		Mask.clear(null);
	}

	/**
	 * Teste para o método {@link Mask#clearNoDigit(String)} com sucesso.
	 *
	 * @param actual Valor para máscara
	 * @param expected Valor de retorno da máscara
	 */
	@Test(dataProvider = "clearNoDigit")
	public void shouldClearNoDigit(final String actual, final String expected) {
		Assert.assertEquals(Mask.clearNoDigit(actual), expected);
	}

	/**
	 * Teste para o método {@link Mask#clearNoDigit(String)} com valor nulo.
	 */
	@Test(expectedExceptions = { NullPointerException.class })
	public void shouldNotClearNoDigit() {
		Mask.clearNoDigit(null);
	}

	/**
	 * Teste para o método {@link Mask#zipCode(String)} com formato válido.
	 *
	 * @param actual Valor para máscara
	 * @param expected Valor de retorno da máscara
	 */
	@Test(dataProvider = "zipCode")
	public void shouldZipCode(final String actual, final String expected) {
		Assert.assertEquals(Mask.zipCode(actual), expected);
	}

	/**
	 * Teste para o método {@link Mask#zipCode(String)} com formato inválido.
	 *
	 * @param actual Valor para máscara
	 * @param expected Valor de retorno da máscara
	 */
	@Test(dataProvider = "notZipCode")
	public void shouldNotZipCode(final String actual, final String expected) {
		Assert.assertEquals(Mask.zipCode(actual), expected);
	}

	/**
	 * Teste para o método {@link Mask#zipCode(String)} com valor nulo.
	 */
	@Test(expectedExceptions = { NullPointerException.class })
	public void shouldZipCodeException() {
		Mask.zipCode(null);
	}

	/**
	 * Teste para o método {@link Mask#phone(String)} com formato válido.
	 *
	 * @param actual Valor para máscara
	 * @param expected Valor de retorno da máscara
	 */
	@Test(dataProvider = "phone")
	public void shouldPhone(final String actual, final String expected) {
		Assert.assertEquals(Mask.phone(actual), expected);
	}

	/**
	 * Teste para o método {@link Mask#phone(String)} com formato inválido.
	 *
	 * @param actual Valor para máscara
	 * @param expected Valor de retorno da máscara
	 */
	@Test(dataProvider = "notPhone")
	public void shouldNotPhone(final String actual, final String expected) {
		Assert.assertEquals(Mask.phone(actual), expected);
	}

	/**
	 * Teste para o método {@link Mask#phone(String)} com valor nulo.
	 */
	@Test(expectedExceptions = { NullPointerException.class })
	public void shouldPhoneException() {
		Mask.phone(null);
	}

	/**
	 * Teste para o método {@link Mask#cpf(String)} com formato válido.
	 *
	 * @param actual Valor para máscara
	 * @param expected Valor de retorno da máscara
	 */
	@Test(dataProvider = "cpf")
	public void shouldCpf(final String actual, final String expected) {
		Assert.assertEquals(Mask.cpf(actual), expected);
	}

	/**
	 * Teste para o método {@link Mask#cpf(String)} com formato inválido.
	 *
	 * @param actual Valor para máscara
	 * @param expected Valor de retorno da máscara
	 */
	@Test(dataProvider = "notCpf")
	public void shouldNotCpf(final String actual, final String expected) {
		Assert.assertEquals(Mask.cpf(actual), expected);
	}

	/**
	 * Teste para o método {@link Mask#cpf(String)} com valor nulo.
	 */
	@Test(expectedExceptions = { NullPointerException.class })
	public void shouldCpfException() {
		Mask.cpf(null);
	}

	/**
	 * Teste para o método {@link Mask#cnpj(String)} com formato válido.
	 *
	 * @param actual Valor para máscara
	 * @param expected Valor de retorno da máscara
	 */
	@Test(dataProvider = "cnpj")
	public void shouldCnpj(final String actual, final String expected) {
		Assert.assertEquals(Mask.cnpj(actual), expected);
	}

	/**
	 * Teste para o método {@link Mask#cnpj(String)} com formato inválido.
	 *
	 * @param actual Valor para máscara
	 * @param expected Valor de retorno da máscara
	 */
	@Test(dataProvider = "notCnpj")
	public void shouldNotCnpj(final String actual, final String expected) {
		Assert.assertEquals(Mask.cnpj(actual), expected);
	}

	/**
	 * Teste para o método {@link Mask#cnpj(String)} com valor nulo.
	 */
	@Test(expectedExceptions = { NullPointerException.class })
	public void shouldCnpjException() {
		Mask.cnpj(null);
	}

}
