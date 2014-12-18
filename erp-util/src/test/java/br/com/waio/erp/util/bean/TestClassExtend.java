package br.com.waio.erp.util.bean;

import java.io.Serializable;

import br.com.waio.erp.util.EqualsHashCode;

/**
 * Classe para test de equals e hashCode.
 *
 * @since 3.4.0
 *
 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
 */
public class TestClassExtend implements Serializable {

	/**
	 * Serial version da classe.
	 */
	private static final long serialVersionUID = 5991485790916700982L;

	/**
	 * String.
	 */
	private String fExtend;

	/**
	 * @return valor do fExtend
	 */
	public String getfExtend() {
		return fExtend;
	}

	/**
	 * @param fExtend o valor a ser setado no fExtend
	 */
	public void setfExtend(final String fExtend) {
		this.fExtend = fExtend;
	}

	@Override
	public int hashCode() {
		return EqualsHashCode.hashCode(this.fExtend);
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof TestClassExtend) {
			return EqualsHashCode.equalsHelper().append(this.fExtend, ((TestClassExtend) obj).fExtend).isEquals();
		}

		return false;
	}

}
