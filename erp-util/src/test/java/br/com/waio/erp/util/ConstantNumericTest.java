package br.com.waio.erp.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Teste referente as {@link ConstantNumeric}.
 *
 * @since 3.4.0
 *
 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
 */
@Test(groups = { "util" })
public class ConstantNumericTest {

	/**
	 * Teste para o construtor privado.
	 *
	 * @throws Throwable Possíveis erros
	 */
	@Test
	public void shouldConstructorPrivate() throws Throwable {
		final Constructor<?> constructor = ConstantNumeric.class.getDeclaredConstructor((Class<?>[]) null);
		final int constructorModifiers = constructor.getModifiers();

		Assert.assertTrue(Modifier.isPrivate(constructorModifiers));

		constructor.setAccessible(true);
		constructor.newInstance((Object[]) null);
	}

}
