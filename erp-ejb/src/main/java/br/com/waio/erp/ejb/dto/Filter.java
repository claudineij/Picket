package br.com.waio.erp.ejb.dto;

import br.com.waio.erp.ejb.enums.Restriction;
import br.com.waio.erp.util.Validator;

/**
 * Objeto para gerar o filtro da paginação.
 *
 * @author Vitor de Moraes | vitor.moraes@waio.com.br
 * @since 2.0.3
 */
public class Filter {

	/**
	 * Campo do filtro.
	 */
	private final String field;

	/**
	 * Valor do filtro.
	 */
	private Object value;

	/**
	 * Segundo valor do filtro.
	 */
	private Object secondValue;

	/**
	 * Tipo de restrição.
	 */
	private final Restriction restriction;

	/**
	 * Construtor.
	 *
	 * @param field Nome do campo
	 * @param restriction Tipo de restrição
	 */
	public Filter(final String field, final Restriction restriction) {
		this.field = field;
		this.restriction = restriction;
	}

	/**
	 * Construtor.
	 *
	 * @param field Nome do campo
	 * @param value Valor do campo
	 */
	public Filter(final String field, final Object value) {
		this.field = field;
		this.value = value;
		this.restriction = Restriction.ILIKE;
	}

	/**
	 * Construtor.
	 *
	 * @param field Nome do campo
	 * @param value Valor do campo
	 * @param secondValue Segundo valor do filtro
	 */
	public Filter(final String field, final Object value, final Object secondValue) {
		this.field = field;
		this.value = value;
		this.secondValue = secondValue;
		this.restriction = Restriction.ILIKE;
	}

	/**
	 * Construtor.
	 *
	 * @param field Nome do campo
	 * @param value Valor do campo
	 * @param restriction Tipo de restrição
	 */
	public Filter(final String field, final Object value, final Restriction restriction) {
		this.field = field;
		this.value = value;
		this.restriction = restriction;
	}

	/**
	 * Construtor.
	 *
	 * @param field Nome do campo
	 * @param value Valor do campo
	 * @param secondValue Segundo valor do filtro
	 * @param restriction Tipo de restrição
	 */
	public Filter(final String field, final Object value, final Object secondValue, final Restriction restriction) {
		this.field = field;
		this.value = value;
		this.secondValue = secondValue;
		this.restriction = restriction;
	}

	/**
	 * @return valor do field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @return valor do value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @return valor do secondValue
	 */
	public Object getSecondValue() {
		return secondValue;
	}

	/**
	 * @return valor do restriction
	 */
	public Restriction getRestriction() {
		return restriction;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder(this.getClass().getSimpleName());

		if (!Validator.isEmpty(field)) {
			builder.append("Campo: ");
			builder.append(field);
			builder.append("; ");
		}

		if (!Validator.isEmpty(value)) {
			builder.append("Valor: ");
			builder.append(value);
			builder.append("; ");
		}

		if (!Validator.isEmpty(secondValue)) {
			builder.append("Segundo valor: ");
			builder.append(secondValue);
			builder.append("; ");
		}

		if (!Validator.isEmpty(restriction)) {
			builder.append("Restrição: ");
			builder.append(restriction);
		}

		return builder.toString();
	}

}
