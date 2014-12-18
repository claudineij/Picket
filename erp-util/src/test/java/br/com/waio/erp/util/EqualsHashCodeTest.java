package br.com.waio.erp.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.waio.erp.util.provider.EqualsHashCodeProvider;

/**
 * Teste referente ao {@link EqualsHashCode}.
 *
 * @since 3.1.1
 *
 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
 */
@Test(dataProviderClass = EqualsHashCodeProvider.class, groups = { "util" }, dependsOnGroups = { "validator" })
public class EqualsHashCodeTest {

	/**
	 * Teste para o construtor privado.
	 *
	 * @throws Throwable Possíveis erros
	 */
	@Test
	public void shouldConstructorPrivate() throws Throwable {
		final Constructor<?> constructor = EqualsHashCode.class.getDeclaredConstructor((Class<?>[]) null);
		final int constructorModifiers = constructor.getModifiers();

		Assert.assertTrue(Modifier.isPrivate(constructorModifiers));

		constructor.setAccessible(true);
		constructor.newInstance((Object[]) null);
	}

	/**
	 * Teste para o método {@link EqualsHashCode#hashCode(Object...)} com sucesso.
	 *
	 * @param actual Número do hashCode atual
	 * @param expected Número do hashCode esperado
	 */
	@Test(dataProvider = "shouldHashCode")
	public void shouldHashCode(final int actual, final int expected) {
		Assert.assertEquals(actual, expected);
	}

	/**
	 * Teste para o método {@link EqualsHashCode#hashCode(Object...)} sem sucesso.
	 *
	 * @param actual Número do hashCode atual
	 * @param expected Número do hashCode esperado
	 */
	@Test(dataProvider = "shouldNotHashCode")
	public void shouldNotHashCode(final int actual, final int expected) {
		Assert.assertNotEquals(actual, expected);
	}

	/**
	 * Teste para o método {@link EqualsHashCode#equalsHelper()} com sucesso.
	 *
	 * @param condition Valor de retorno do equals
	 */
	@Test(dataProvider = "shouldEquals")
	public void shouldEquals(final boolean condition) {
		Assert.assertTrue(condition);
	}

	/**
	 * Teste para o método {@link EqualsHashCode#equalsHelper()} sem sucesso.
	 *
	 * @param condition Valor de retorno do equals
	 */
	@Test(dataProvider = "shouldNotEquals")
	public void shouldNotEquals(final boolean condition) {
		Assert.assertFalse(condition);
	}

	/**
	 * Teste para o método {@link EqualsHashCode#equalsHelper()} com valores nulo.
	 */
	@Test
	public void shouldNotEqualsWithValuesNull() {
		Assert.assertFalse(EqualsHashCode.equalsHelper().append(null, "").append("", null).isEquals());
	}

	/**
	 * Teste para o método {@link EqualsHashCode#equalsHelper()} com tipo diferente.
	 */
	@Test
	public void shouldNotEqualsWithTypeDifferent() {
		Assert.assertFalse(EqualsHashCode.equalsHelper().append(1L, "").append("", 1L).isEquals());
	}

}
