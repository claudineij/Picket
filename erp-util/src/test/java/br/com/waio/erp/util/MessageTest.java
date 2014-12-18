package br.com.waio.erp.util;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.testng.annotations.Test;

import br.com.waio.erp.util.exception.ChangeCollisionException;
import br.com.waio.erp.util.exception.FieldDuplicatedException;
import br.com.waio.erp.util.exception.FieldInvalidException;
import br.com.waio.erp.util.exception.HeadOfficeNotFoundException;
import br.com.waio.erp.util.exception.ObjectEmptyException;
import br.com.waio.erp.util.exception.ObjectExistsException;
import br.com.waio.erp.util.exception.ObjectNotFoundException;
import br.com.waio.erp.util.exception.PasswordIncorrectException;
import br.com.waio.erp.util.exception.PropertyException;
import br.com.waio.erp.util.exception.UserHasGroupEmptyException;
import br.com.waio.erp.util.exception.UserInvalidException;

/**
 * Teste referente as {@link Messages}.
 *
 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
 * @since 4.0.0
 */
@Test(groups = { "util", "message" })
public class MessageTest {

	/**
	 * Teste para o construtor privado.
	 *
	 * @throws Throwable Possíveis erros
	 */
	public void shouldConstructorPrivate() throws Throwable {
		final Constructor<?> constructor = Messages.class.getDeclaredConstructor((Class<?>[]) null);
		final int constructorModifiers = constructor.getModifiers();

		assertTrue(Modifier.isPrivate(constructorModifiers));

		constructor.setAccessible(true);
		constructor.newInstance((Object[]) null);
	}

	/**
	 * Teste para recuperar mensagem via string;
	 */
	public void shouldGetMessage() {
		assertEquals(Messages.getMessage("PasswordIncorrectException"), "Senha incorreta");
		assertEquals(Messages.getMessage("ChangeCollisionException", "XXXX"),
					 "XXXX está sendo alterado por outro usuário");
		assertEquals(Messages.getMessage("ChangeCollisionException", null), "{0} está sendo alterado por outro usuário");
	}

	/**
	 * Teste para recuperar mensagem via class.
	 */
	public void shouldGetMessageWithClass() {
		assertEquals(Messages.getMessage(ChangeCollisionException.class, "XXXX"),
					 "XXXX está sendo alterado por outro usuário");
		assertEquals(Messages.getMessage(FieldDuplicatedException.class, "XXXX"), "Campo XXXX está duplicado");
		assertEquals(Messages.getMessage(FieldInvalidException.class, "XXXX", "YYYY"), "O campo XXXX YYYY");
		assertEquals(Messages.getMessage(HeadOfficeNotFoundException.class, "XXXX"),
					 "Não existe matriz para o CNPJ XXXX");
		assertEquals(Messages.getMessage(ObjectEmptyException.class, "XXXX"), "Objeto XXXX está nulo");
		assertEquals(Messages.getMessage(ObjectExistsException.class, "XXXX"), "XXXX já existe");
		assertEquals(Messages.getMessage(ObjectNotFoundException.class, "XXXX"), "XXXX não existe");
		assertEquals(Messages.getMessage(PasswordIncorrectException.class), "Senha incorreta");
		assertEquals(Messages.getMessage(PropertyException.class, "XXXX", "YYYY"),
					 "Não foi possível acessar a propriedade XXXX na classe YYYY");
		assertEquals(Messages.getMessage(UserHasGroupEmptyException.class, "XXXX"), "Usuário XXXX sem grupo definido");
		assertEquals(Messages.getMessage(UserInvalidException.class, "XXXX"), "Usuário XXXX inválido");
	}

}
