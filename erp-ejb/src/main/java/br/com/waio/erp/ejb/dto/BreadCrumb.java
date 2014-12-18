package br.com.waio.erp.ejb.dto;

import java.io.Serializable;

import br.com.waio.erp.util.EqualsHashCode;

/**
 * Caminho de pão.
 *
 * @since 2.0.0
 *
 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
 */
public class BreadCrumb implements Serializable {

	/**
	 * Serial version da classe.
	 */
	private static final long serialVersionUID = 5169119209834383221L;

	/**
	 * Nome do caminho.
	 */
	private String name;

	/**
	 * Título do caminho.
	 */
	private String title;

	/**
	 * Url do caminho.
	 */
	private String url;

	/**
	 * Último passo.
	 */
	private Boolean last;

	/**
	 * @return valor do name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name o valor a ser setado no name
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return valor do title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title o valor a ser setado no title
	 */
	public void setTitle(final String title) {
		this.title = title;
	}

	/**
	 * @return valor do url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url o valor a ser setado no url
	 */
	public void setUrl(final String url) {
		this.url = url;
	}

	/**
	 * @return valor do last
	 */
	public Boolean getLast() {
		return last;
	}

	/**
	 * @param last o valor a ser setado no last
	 */
	public void setLast(final Boolean last) {
		this.last = last;
	}

	@Override
	public int hashCode() {
		return EqualsHashCode.hashCode(this.name, this.title, this.url, this.last);
	}

	@Override
	public boolean equals(final Object other) {
		if (other instanceof BreadCrumb) {
			final BreadCrumb otherBreadCrumb = (BreadCrumb) other;

			return EqualsHashCode.equalsHelper()
					.append(this.name, otherBreadCrumb.name)
					.append(this.title, otherBreadCrumb.title)
					.append(this.url, otherBreadCrumb.url)
					.append(this.last, otherBreadCrumb.last)
					.isEquals();
		}

		return false;
	}
	
}
