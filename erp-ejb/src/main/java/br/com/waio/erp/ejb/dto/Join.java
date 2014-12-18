package br.com.waio.erp.ejb.dto;

import javax.persistence.criteria.JoinType;

/**
 * Objeto responsável por gerar os join.
 *
 * @author Vitor de Moraes | vitor.moraes@waio.com.br
 * @since 3.1.1
 */
public class Join {

	/**
	 * Nome do campo.
	 */
	private final String association;

	/**
	 * Tipo de join.
	 */
	private final JoinType type;

	/**
	 * Construtor.
	 *
	 * @param association Nome do campo.
	 */
	public Join(final String association) {
		this.association = association;
		this.type = JoinType.LEFT;
	}

	/**
	 * Construtor.
	 *
	 * @param association Nome do campo.
	 * @param type Tipo de join.
	 */
	public Join(final String association, final JoinType type) {
		this.association = association;
		this.type = type;
	}

	/**
	 * @return valor do association
	 */
	public String getAssociation() {
		return association;
	}

	/**
	 * @return valor do joinType
	 */
	public JoinType getType() {
		return type;
	}

}
