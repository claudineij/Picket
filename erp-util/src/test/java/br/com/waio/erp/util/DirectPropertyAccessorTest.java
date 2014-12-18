package br.com.waio.erp.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.waio.erp.util.bean.TestClass;
import br.com.waio.erp.util.exception.PropertyException;
import br.com.waio.erp.util.provider.DirectPropertyAccessorProvider;

/**
 * Teste referente ao {@link DirectPropertyAccessor}.
 *
 * @since 3.1.1
 *
 * @author <a href="mail:fabio.zanardi@w2z.com.br">Fábio Zanardi</a>
 */
@Test(dataProviderClass = DirectPropertyAccessorProvider.class, groups = { "util", "directPropertyAcessor" },
		dependsOnGroups = { "validator", "exception" })
public class DirectPropertyAccessorTest {

	/**
	 * Teste para o método {@link DirectPropertyAccessor#get(String)} com sucesso.
	 *
	 * @param field Propriedade a ser testada
	 * @param expected Valor esperado da propriedade
	 *
	 * @throws PropertyException Propriedade não pode ser recuperada
	 */
	@Test(dataProvider = "get")
	public void shouldGet(final String field, final Object expected) throws PropertyException {
		final TestClass testClass = new TestClass().data(-1);
		final DirectPropertyAccessor<TestClass> propertyAccessor = new DirectPropertyAccessor<>(testClass);
		Assert.assertEquals(propertyAccessor.get(field), expected);
	}

	/**
	 * Teste para o método {@link DirectPropertyAccessor#set(String, Object)} com sucesso.
	 *
	 * @param field Propriedade a ser setada
	 * @param value Valor a ser setado na propriedade
	 *
	 * @throws PropertyException Propriedade não pode ser setada
	 */
	@Test(dataProvider = "set")
	public void shouldSet(final String field, final Object value) throws PropertyException {
		final TestClass testClass = new TestClass().data(-1);
		final DirectPropertyAccessor<TestClass> propertyAccessor = new DirectPropertyAccessor<>(testClass);
		propertyAccessor.set(field, value);
		Assert.assertEquals(propertyAccessor.get(field), value);
	}

	/**
	 * Teste para o método {@link DirectPropertyAccessor#get(String)} com propriedade inexistente.
	 *
	 * @param field Propriedade a ser testada
	 *
	 * @throws PropertyException Propriedade não pode ser recuperada
	 */
	@Test(dataProvider = "getInexistentProperty", expectedExceptions = { PropertyException.class },
			expectedExceptionsMessageRegExp = "Não foi possível acessar a propriedade .* na classe .*")
	public void shouldNotGetInexistentProperty(final String field) throws PropertyException {
		final TestClass testClass = new TestClass().data(-1);
		final DirectPropertyAccessor<TestClass> propertyAccessor = new DirectPropertyAccessor<>(testClass);
		propertyAccessor.get(field);
	}

	/**
	 * Teste para o método {@link DirectPropertyAccessor#set(String, Object)} com propriedade inexistente.
	 *
	 * @param field Propriedade a ser testada
	 *
	 * @throws PropertyException Propriedade não pode ser setada
	 */
	@Test(dataProvider = "setInexistentProperty", expectedExceptions = { PropertyException.class },
			expectedExceptionsMessageRegExp = "Não foi possível acessar a propriedade .* na classe .*")
	public void shouldNotSetInexistentProperty(final String field) throws PropertyException {
		final TestClass testClass = new TestClass().data(-1);
		final DirectPropertyAccessor<TestClass> propertyAccessor = new DirectPropertyAccessor<>(testClass);
		propertyAccessor.set(field, null);
	}

	/**
	 * Teste para o construtor com objeto nulo.
	 */
	@Test(expectedExceptions = { IllegalArgumentException.class },
			expectedExceptionsMessageRegExp = "Classe a ser utilizada não pode ser nula")
	public void shouldNotObjectNull() {
		new DirectPropertyAccessor<>(null);
	}

}
