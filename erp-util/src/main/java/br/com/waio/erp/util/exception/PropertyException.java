package br.com.waio.erp.util.exception;

import javax.ejb.ApplicationException;

import br.com.waio.erp.util.Messages;

/**
 * A <tt>PropertyException</tt> transporta informações do erro de não é possível acessar a propriedade de um objeto.
 *
 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
 * @since 2.0.7
 */
@ApplicationException(rollback = true)
public class PropertyException extends Exception {

	/**
	 * Serial version da classe.
	 */
	private static final long serialVersionUID = -1376814758815108103L;

	/**
	 * Construtor.
	 *
	 * @param property Propriedade inválida
	 * @param className Nome da classe
	 * @param cause Causa da exceção
	 */
	public PropertyException(final String property, final String className, final Throwable cause) {
		super(Messages.getMessage(PropertyException.class, property, className), cause);
	}

}
