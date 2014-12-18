package br.com.waio.erp.ejb.dto;

import br.com.waio.erp.ejb.enums.SortOrder;

/**
 * Objeto para gerar o ordenação da paginação.
 *
 * @author Vitor de Moraes | vitor.moraes@waio.com.br
 * @since 2.0.3
 */
public class Sort {

	/**
	 * Campo para ordenação.
	 */
	private final String field;

	/**
	 * Tipo de ordenação.
	 */
	private final SortOrder order;

	/**
	 * Construtor.
	 * 
	 * @param field Campo para ordenação.
	 */
	public Sort(final String field) {
		this.field = field;
		this.order = SortOrder.ASCENDING;
	}

	/**
	 * Construtor.
	 * 
	 * @param field Campo para ordenação.
	 * @param order Tipo de ordenação
	 */
	public Sort(final String field, final SortOrder order) {
		this.field = field;
		this.order = order;
	}

	/**
	 * @return valor do field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @return valor do order
	 */
	public SortOrder getOrder() {
		return order;
	}

}
