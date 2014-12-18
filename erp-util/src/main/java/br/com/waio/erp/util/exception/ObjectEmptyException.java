package br.com.waio.erp.util.exception;

import br.com.waio.erp.util.Messages;

/**
 * A <tt>ObjectEmptyException</tt> transporta informações do erro de objeto em branco.
 *
 * @author <a href="mail:claudinei.sartori@w2z.com.br">Claudinei Sartori</a>
 * @since 3.2.0
 */
public class ObjectEmptyException extends Exception {

	/**
	 * Serial version da classe.
	 */
	private static final long serialVersionUID = -3777243018577104465L;

	/**
	 * Nome do objeto.
	 */
	private final String object;

	/**
	 * Construtor.
	 *
	 * @param object Nome do objeto
	 */
	public ObjectEmptyException(final String object) {
		super(Messages.getMessage(ObjectEmptyException.class, object));
		this.object = object;
	}

	/**
	 * @return valor do object
	 */
	public String getObject() {
		return object;
	}

}
