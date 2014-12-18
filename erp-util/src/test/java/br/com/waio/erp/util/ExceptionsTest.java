package br.com.waio.erp.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.waio.erp.util.exception.ChangeCollisionException;
import br.com.waio.erp.util.exception.ERPConstraintViolationException;
import br.com.waio.erp.util.exception.FieldDuplicatedException;
import br.com.waio.erp.util.exception.FieldInvalidException;
import br.com.waio.erp.util.exception.HeadOfficeNotFoundException;
import br.com.waio.erp.util.exception.IllegalHandlingException;
import br.com.waio.erp.util.exception.ObjectEmptyException;
import br.com.waio.erp.util.exception.ObjectExistsException;
import br.com.waio.erp.util.exception.ObjectNotFoundException;
import br.com.waio.erp.util.exception.PasswordIncorrectException;
import br.com.waio.erp.util.exception.PropertyException;
import br.com.waio.erp.util.exception.UserHasGroupEmptyException;
import br.com.waio.erp.util.exception.UserInvalidException;

/**
 * Teste referente as exceptions.
 *
 * @since 3.4.0
 *
 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
 */
@Test(groups = { "util", "exception" }, dependsOnGroups = "message")
public class ExceptionsTest {

	/**
	 * Teste para {@link ChangeCollisionException}.
	 *
	 * @throws ChangeCollisionException {@link ChangeCollisionException}
	 */
	@Test(expectedExceptions = ChangeCollisionException.class,
			expectedExceptionsMessageRegExp = "Test está sendo alterado por outro usuário")
	public void shouldChangeCollision() throws ChangeCollisionException {
		try {
			throw new ChangeCollisionException("Test", new IllegalArgumentException());
		} catch (final ChangeCollisionException e) {
			Assert.assertTrue(e.getCause() instanceof IllegalArgumentException);
			throw e;
		}
	}

	/**
	 * Teste para {@link ERPConstraintViolationException}.
	 *
	 * @throws ERPConstraintViolationException {@link ERPConstraintViolationException}
	 */
	@Test(expectedExceptions = ERPConstraintViolationException.class,
			expectedExceptionsMessageRegExp = "Erro de violação")
	public void shouldERPConstraintViolationException() throws ERPConstraintViolationException {
		try {
			throw new ERPConstraintViolationException("Erro de violação", new IllegalArgumentException());
		} catch (final ERPConstraintViolationException e) {
			Assert.assertTrue(e.getCause() instanceof IllegalArgumentException);
			throw e;
		}
	}

	/**
	 * Teste para {@link FieldDuplicatedException}.
	 *
	 * @throws FieldDuplicatedException {@link FieldDuplicatedException}
	 */
	@Test(expectedExceptions = FieldDuplicatedException.class,
			expectedExceptionsMessageRegExp = "Campo test está duplicado")
	public void shouldFieldDuplicatedException() throws FieldDuplicatedException {
		try {
			throw new FieldDuplicatedException("test");
		} catch (final FieldDuplicatedException e) {
			Assert.assertEquals(e.getField(), "test");
			throw e;
		}
	}

	/**
	 * Teste para {@link FieldInvalidException}.
	 *
	 * @throws FieldInvalidException {@link FieldInvalidException}
	 */
	@Test(expectedExceptions = FieldInvalidException.class, expectedExceptionsMessageRegExp = "O campo test é inválido")
	public void shouldFieldInvalidException() throws FieldInvalidException {
		throw new FieldInvalidException("test");
	}

	/**
	 * Teste para {@link FieldInvalidException} com mensagem.
	 *
	 * @throws FieldInvalidException {@link FieldInvalidException}
	 */
	@Test(dependsOnMethods = "shouldFieldInvalidException", expectedExceptions = FieldInvalidException.class,
			expectedExceptionsMessageRegExp = "O campo test está errado")
	public void shouldFieldInvalidExceptionWithMessage() throws FieldInvalidException {
		throw new FieldInvalidException("está errado", "test");
	}

	/**
	 * Teste para {@link FieldInvalidException} com mensagem e causa.
	 *
	 * @throws FieldInvalidException {@link FieldInvalidException}
	 */
	@Test(dependsOnMethods = "shouldFieldInvalidExceptionWithMessage",
			expectedExceptions = FieldInvalidException.class,
			expectedExceptionsMessageRegExp = "O campo test está errado")
	public void shouldFieldInvalidExceptionWithMessageAndCause() throws FieldInvalidException {
		try {
			throw new FieldInvalidException("está errado", "test", new IllegalArgumentException());
		} catch (final FieldInvalidException e) {
			Assert.assertTrue(e.getCause() instanceof IllegalArgumentException);
			Assert.assertEquals(e.getField(), "test");
			throw e;
		}
	}

	/**
	 * Teste para {@link HeadOfficeNotFoundException}.
	 *
	 * @throws HeadOfficeNotFoundException {@link HeadOfficeNotFoundException}
	 */
	@Test(expectedExceptions = HeadOfficeNotFoundException.class,
			expectedExceptionsMessageRegExp = "Não existe matriz para o CNPJ 92.611.469/0001-85")
	public void shouldHeadOfficeNotFoundException() throws HeadOfficeNotFoundException {
		throw new HeadOfficeNotFoundException("92.611.469/0001-85");
	}

	/**
	 * Teste para {@link IllegalHandlingException}.
	 *
	 * @throws IllegalHandlingException {@link IllegalHandlingException}
	 */
	@Test(expectedExceptions = IllegalHandlingException.class,
			expectedExceptionsMessageRegExp = "Mensagem para teste shouldIllegalHandlingException")
	public void shouldIllegalHandlingException() throws IllegalHandlingException {
		try {
			throw new IllegalHandlingException("test", "Mensagem para teste shouldIllegalHandlingException");
		} catch (final IllegalHandlingException e) {
			Assert.assertEquals(e.getBundle(), "test");
			throw e;
		}
	}

	/**
	 * Teste para {@link ObjectEmptyException}.
	 *
	 * @throws ObjectEmptyException {@link ObjectEmptyException}
	 */
	@Test(expectedExceptions = ObjectEmptyException.class, expectedExceptionsMessageRegExp = "Objeto test está nulo")
	public void shouldObjectEmptyException() throws ObjectEmptyException {
		try {
			throw new ObjectEmptyException("test");
		} catch (final ObjectEmptyException e) {
			Assert.assertEquals(e.getObject(), "test");
			throw e;
		}
	}

	/**
	 * Teste para {@link ObjectExistsException}.
	 *
	 * @throws ObjectExistsException {@link ObjectExistsException}
	 */
	@Test(expectedExceptions = ObjectExistsException.class, expectedExceptionsMessageRegExp = "test já existe")
	public void shouldObjectExistsException() throws ObjectExistsException {
		throw new ObjectExistsException("test");
	}

	/**
	 * Teste para {@link ObjectExistsException} com causa.
	 *
	 * @throws ObjectExistsException {@link ObjectExistsException} 
	 */
	@Test(dependsOnMethods = "shouldObjectExistsException", expectedExceptions = ObjectExistsException.class,
			expectedExceptionsMessageRegExp = "test já existe")
	public void shouldObjectExistsExceptionWithCause() throws ObjectExistsException {
		try {
			throw new ObjectExistsException("test", new IllegalArgumentException());
		} catch (final ObjectExistsException e) {
			Assert.assertTrue(e.getCause() instanceof IllegalArgumentException);
			throw e;
		}
	}

	/**
	 * Teste para {@link ObjectNotFoundException}.
	 *
	 * @throws ObjectNotFoundException {@link ObjectNotFoundException}
	 */
	@Test(expectedExceptions = ObjectNotFoundException.class, expectedExceptionsMessageRegExp = "test não existe")
	public void shouldObjectNotFoundException() throws ObjectNotFoundException {
		throw new ObjectNotFoundException("test");
	}

	/**
	 * Teste para {@link ObjectNotFoundException} com causa.
	 *
	 * @throws ObjectNotFoundException {@link ObjectNotFoundException}
	 */
	@Test(dependsOnMethods = "shouldObjectNotFoundException", expectedExceptions = ObjectNotFoundException.class,
			expectedExceptionsMessageRegExp = "test não existe")
	public void shouldObjectNotFoundExceptionWithCause() throws ObjectNotFoundException {
		try {
			throw new ObjectNotFoundException("test", new IllegalArgumentException());
		} catch (final ObjectNotFoundException e) {
			Assert.assertTrue(e.getCause() instanceof IllegalArgumentException);
			throw e;
		}
	}

	/**
	 * Teste para {@link PasswordIncorrectException}.
	 *
	 * @throws PasswordIncorrectException {@link PasswordIncorrectException}
	 */
	@Test(expectedExceptions = PasswordIncorrectException.class, expectedExceptionsMessageRegExp = "Senha incorreta")
	public void shouldPasswordIncorrectException() throws PasswordIncorrectException {
		throw new PasswordIncorrectException();
	}

	/**
	 * Teste para {@link PropertyException}.
	 *
	 * @throws PropertyException {@link PropertyException}
	 */
	@Test(expectedExceptions = PropertyException.class,
			expectedExceptionsMessageRegExp = "Não foi possível acessar a propriedade test na classe testClass")
	public void shouldPropertyException() throws PropertyException {
		try {
			throw new PropertyException("test", "testClass", new IllegalArgumentException());
		} catch (final PropertyException e) {
			Assert.assertTrue(e.getCause() instanceof IllegalArgumentException);
			throw e;
		}
	}

	/**
	 * Teste para {@link UserHasGroupEmptyException}.
	 *
	 * @throws UserHasGroupEmptyException {@link UserHasGroupEmptyException}
	 */
	@Test(expectedExceptions = UserHasGroupEmptyException.class,
			expectedExceptionsMessageRegExp = "Usuário test sem grupo definido")
	public void shouldUserHasGroupEmptyException() throws UserHasGroupEmptyException {
		throw new UserHasGroupEmptyException("test");
	}

	/**
	 * Teste para {@link UserInvalidException}.
	 *
	 * @throws UserInvalidException {@link UserInvalidException}
	 */
	@Test(expectedExceptions = UserInvalidException.class, expectedExceptionsMessageRegExp = "Usuário test inválido")
	public void shouldUserInvalidException() throws UserInvalidException {
		throw new UserInvalidException("test");
	}

}
