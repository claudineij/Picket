package br.com.waio.erp.ejb.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.apache.log4j.Logger;

import br.com.waio.erp.util.Validator;

/**
 * Entidade genérica.
 *
 * @since 2.0.0
 *
 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable, Cloneable {

	/**
	 * Serial version da classe.
	 */
	private static final long serialVersionUID = 5831961275592962437L;

	/**
	 * Chave primária.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Versionador do registro.
	 */
	@Version
	private long version;

	/**
	 * @return valor do id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id o valor a ser setado no id
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * @return valor do version
	 */
	public long getVersion() {
		return version;
	}

	/**
	 * @param version o valor a ser setado no version
	 */
	public void setVersion(final long version) {
		this.version = version;
	}

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (final CloneNotSupportedException e) {
			Logger.getLogger(AbstractEntity.class).error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder(this.getClass().getSimpleName());
		if (!Validator.isEmpty(id)) {
			builder.append(" [id=");
			builder.append(id);
			builder.append("]");
		}

		return builder.toString();
	}

}
