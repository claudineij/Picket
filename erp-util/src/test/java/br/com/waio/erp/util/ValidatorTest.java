package br.com.waio.erp.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.waio.erp.util.provider.ValidatorProvider;

/**
 * Teste referente as {@link Validator}.
 *
 * @since 2.0.2
 *
 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
 */
@Test(dataProviderClass = ValidatorProvider.class, groups = { "util", "validator" }, dependsOnGroups = { "mask" })
public class ValidatorTest {

	/**
	 * Teste para o construtor privado.
	 *
	 * @throws Throwable Possíveis erros
	 */
	@Test
	public void shouldConstructorPrivate() throws Throwable {
		final Constructor<?> constructor = Validator.class.getDeclaredConstructor((Class<?>[]) null);
		final int constructorModifiers = constructor.getModifiers();

		Assert.assertTrue(Modifier.isPrivate(constructorModifiers));

		constructor.setAccessible(true);
		constructor.newInstance((Object[]) null);
	}

	/**
	 * Teste para o método {@link Validator#isEmpty(String)} com formato válido.
	 *
	 * @param actual Valor para validação
	 */
	@Test(dataProvider = "isEmptyString")
	public void shouldIsEmptyString(final String actual) {
		Assert.assertTrue(Validator.isEmpty(actual));
	}

	/**
	 * Teste para o método {@link Validator#isEmpty(String)} com formato inválido.
	 *
	 * @param actual Valor para validação
	 */
	@Test(dependsOnMethods = { "shouldIsEmptyString" }, dataProvider = "isNotEmptyString")
	public void shouldIsNotEmptyString(final String actual) {
		Assert.assertFalse(Validator.isEmpty(actual));
	}

	/**
	 * Teste para o método {@link Validator#isEmpty(String[])} com formato válido.
	 *
	 * @param actual Valor para validação
	 */
	@Test(dataProvider = "isEmptyStringArray")
	public void shouldIsEmptyStringArray(final String[] actual) {
		Assert.assertTrue(Validator.isEmpty(actual));
	}

	/**
	 * Teste para o método {@link Validator#isEmpty(String[])} com formato inválido.
	 *
	 * @param actual Valor para validação
	 */
	@Test(dependsOnMethods = { "shouldIsEmptyStringArray" }, dataProvider = "isNotEmptyStringArray")
	public void shouldIsNotEmptyStringArray(final String[] actual) {
		Assert.assertFalse(Validator.isEmpty(actual));
	}

	/**
	 * Teste para o método {@link Validator#isEmpty(List)} com formato válido.
	 *
	 * @param actual Valor para validação
	 */
	@Test(dataProvider = "isEmptyList")
	public void shouldIsEmptyList(final List<?> actual) {
		Assert.assertTrue(Validator.isEmpty(actual));
	}

	/**
	 * Teste para o método {@link Validator#isEmpty(List)} com formato inválido.
	 *
	 * @param actual Valor para validação
	 */
	@Test(dependsOnMethods = { "shouldIsEmptyList" }, dataProvider = "isNotEmptyList")
	public void shouldIsNotEmptyList(final List<?> actual) {
		Assert.assertFalse(Validator.isEmpty(actual));
	}

	/**
	 * Teste para o método {@link Validator#isEmpty(Map)} com formato válido.
	 *
	 * @param actual Valor para validação
	 */
	@Test(dataProvider = "isEmptyMap")
	public void shouldIsEmptyMap(final Map<?, ?> actual) {
		Assert.assertTrue(Validator.isEmpty(actual));
	}

	/**
	 * Teste para o método {@link Validator#isEmpty(Map)} com formato inválido.
	 *
	 * @param actual Valor para validação
	 */
	@Test(dependsOnMethods = { "shouldIsEmptyMap" }, dataProvider = "isNotEmptyMap")
	public void shouldIsNotEmptyMap(final Map<?, ?> actual) {
		Assert.assertFalse(Validator.isEmpty(actual));
	}

	/**
	 * Teste para o método {@link Validator#isEmpty(Object)} com formato válido.
	 *
	 * @param actual Valor para validação
	 */
	@Test(dependsOnMethods = { "shouldIsEmptyString", "shouldIsEmptyStringArray", "shouldIsEmptyList",
			"shouldIsEmptyMap" }, dataProvider = "isEmptyObject")
	public void shouldIsEmptyObject(final Object actual) {
		Assert.assertTrue(Validator.isEmpty(actual));
	}

	/**
	 * Teste para o método {@link Validator#isEmpty(Object)} com formato inválido.
	 *
	 * @param actual Valor para validação
	 */
	@Test(dependsOnMethods = { "shouldIsEmptyObject" }, dataProvider = "isNotEmptyObject")
	public void shouldIsNotEmptyObject(final Object actual) {
		Assert.assertFalse(Validator.isEmpty(actual));
	}

	/**
	 * Teste para o método {@link Validator#isNumberWithoutDecimal(String)} com formato válido.
	 *
	 * @param actual Valor para validação
	 */
	@Test(dependsOnMethods = { "shouldIsEmptyString" }, dataProvider = "isNumberWithoutDecimal")
	public void shouldIsNumberWithoutDecimal(final Object actual) {
		Assert.assertTrue(Validator.isNumberWithoutDecimal(actual.toString()));
	}

	/**
	 * Teste para o método {@link Validator#isNumberWithoutDecimal(String)} com formato inválido.
	 *
	 * @param actual Valor para validação
	 */
	@Test(dependsOnMethods = { "shouldIsNumberWithoutDecimal" }, dataProvider = "isNotNumberWithoutDecimal")
	public void shouldIsNotNumberWithoutDecimal(final Object actual) {
		Assert.assertFalse(Validator.isNumberWithoutDecimal(actual == null ? null : actual.toString()));
	}

	/**
	 * Teste para o método {@link Validator#isNumberWithDecimal(String)} com formato válido.
	 *
	 * @param actual Valor para validação
	 */
	@Test(dependsOnMethods = { "shouldIsEmptyString" }, dataProvider = "isNumberWithDecimal")
	public void shouldIsNumberWithDecimal(final Object actual) {
		Assert.assertTrue(Validator.isNumberWithDecimal(actual.toString()));
	}

	/**
	 * Teste para o método {@link Validator#isNumberWithDecimal(String)} com formato inválido.
	 *
	 * @param actual Valor para validação
	 */
	@Test(dependsOnMethods = { "shouldIsNumberWithDecimal" }, dataProvider = "isNotNumberWithDecimal")
	public void shouldIsNotNumberWithDecimal(final Object actual) {
		Assert.assertFalse(Validator.isNumberWithDecimal(actual == null ? null : actual.toString()));
	}

	/**
	 * Teste para o método {@link Validator#isEmail(String)} com formato válido.
	 *
	 * @param actual Valor para validação
	 */
	@Test(dependsOnMethods = { "shouldIsEmptyString" }, dataProvider = "isEmail")
	public void shouldIsEmail(final String actual) {
		Assert.assertTrue(Validator.isEmail(actual));
	}

	/**
	 * Teste para o método {@link Validator#isEmail(String)} com formato inválido.
	 *
	 * @param actual Valor para validação
	 */
	@Test(dependsOnMethods = { "shouldIsEmail" }, dataProvider = "isNotEmail")
	public void shouldIsNotEmail(final String actual) {
		Assert.assertFalse(Validator.isEmail(actual));
	}

	/**
	 * Teste para o método {@link Validator#isCpf(String)} com formato válido.
	 *
	 * @param actual Valor para validação
	 */
	@Test(dependsOnMethods = { "shouldIsEmptyString", "shouldIsNumberWithoutDecimal" }, dataProvider = "isCpf")
	public void shouldIsCpf(final String actual) {
		Assert.assertTrue(Validator.isCpf(actual));
	}

	/**
	 * Teste para o método {@link Validator#isCpf(String)} com formato inválido.
	 *
	 * @param actual Valor para validação
	 */
	@Test(dependsOnMethods = { "shouldIsCpf" }, dataProvider = "isNotCpf")
	public void shouldIsNotCpf(final String actual) {
		Assert.assertFalse(Validator.isCpf(actual));
	}

	/**
	 * Teste para o método {@link Validator#isCnpj(String)} com formato válido.
	 *
	 * @param actual Valor para validação
	 */
	@Test(dependsOnMethods = { "shouldIsEmptyString", "shouldIsNumberWithoutDecimal" }, dataProvider = "isCnpj")
	public void shouldIsCnpj(final String actual) {
		Assert.assertTrue(Validator.isCnpj(actual));
	}

	/**
	 * Teste para o método {@link Validator#isCnpj(String)} com formato inválido.
	 *
	 * @param actual Valor para validação
	 */
	@Test(dependsOnMethods = { "shouldIsCnpj" }, dataProvider = "isNotCnpj")
	public void shouldIsNotCnpj(final String actual) {
		Assert.assertFalse(Validator.isCnpj(actual));
	}

	/**
	 * Teste para o método {@link Validator#isZipCode(String)} com formato válido.
	 *
	 * @param actual Valor para validação
	 */
	@Test(dependsOnMethods = { "shouldIsEmptyString", "shouldIsNumberWithoutDecimal" }, dataProvider = "isZipCode")
	public void shouldIsZipCode(final String actual) {
		Assert.assertTrue(Validator.isZipCode(actual));
	}

	/**
	 * Teste para o método {@link Validator#isZipCode(String)} com formato inválido.
	 *
	 * @param actual Valor para validação
	 */
	@Test(dependsOnMethods = { "shouldIsZipCode" }, dataProvider = "isNotZipCode")
	public void shouldIsNotZipCode(final String actual) {
		Assert.assertFalse(Validator.isZipCode(actual));
	}

	/**
	 * Teste para o método {@link Validator#isStateScription(String, String)} com formato válido.
	 *
	 * @param stateInscription Inscrição estadual válida
	 * @param sigla Sigla do estado
	 */
	@Test(dataProvider = "isStateInscription")
	public void shouldIsStateInscription(final String stateInscription, final String sigla) {
		Assert.assertTrue(Validator.isStateInscription(stateInscription, sigla));
	}

	/**
	 * Teste para o método {@link Validator#isStateScription(String, String)} com formato inválido.
	 *
	 * @param stateInscription Inscrição estadual inválida
	 * @param sigla Sigla do estado
	 */
	@Test(dataProvider = "isNotStateInscription")
	public void shouldNotIsStateInscription(final String stateInscription, final String sigla) {
		Assert.assertFalse(Validator.isStateInscription(stateInscription, sigla));
	}

	/**
	 * Teste para o método {@link Validator#isStateScription(String, String)} com formato válido e sigla trocada.
	 *
	 * @param stateInscription Inscrição estadual válida
	 * @param sigla Sigla do estado trocada
	 */
	@Test(dataProvider = "isNotStateInscriptionOtherState")
	public void shouldNotIsStateInscriptionOtherState(final String stateInscription, final String sigla) {
		Assert.assertFalse(Validator.isStateInscription(stateInscription, sigla));
	}

}
