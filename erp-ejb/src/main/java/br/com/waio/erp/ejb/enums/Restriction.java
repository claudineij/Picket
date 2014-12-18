package br.com.waio.erp.ejb.enums;

import br.com.waio.erp.ejb.Constant;

/**
 * Enum para restrição da criteria.
 *
 * @author Vitor de Moraes | vitor.moraes@waio.com.br
 * @since 2.0.3
 */
public enum Restriction {

	// Restrição de Boolean.

	/**
	 * Valor for true.
	 */
	IS_TRUE("isTrue", false),

	/**
	 * Valor for false.
	 */
	IS_FALSE("isFalse", false),

	// Restrição de null.

	/**
	 * Valor for nulo.
	 */
	IS_NULL("isNull", false),

	/**
	 * Valor não for nulo.
	 */
	IS_NOT_NULL("isNotNull", false),

	// Restrição de equivalência

	/**
	 * Valor for igual.
	 */
	EQUAL("equal"),

	/**
	 * Valor for diferente.
	 */
	NOT_EQUAL("notEqual"),

	/**
	 * Valor da propriedade for maior ao valor da outra propriedade.
	 */
	GREATER_THAN("greaterThan"),

	/**
	 * Valor da propriedade for maior ou igual ao valor da outra propriedade.
	 */
	GREATER_THAN_OR_EQUAL_TO("greaterThanOrEqualTo"),

	/**
	 * Valor da propriedade for menor ao valor da outra propriedade.
	 */
	LESS_THAN("lessThan"),

	/**
	 * Valor da propriedade for menor ou igual ao valor da outra propriedade.
	 */
	LESS_THAN_OR_EQUAL_TO("lessThanOrEqualTo"),

	/**
	 * Valor for da propriedade for entre.
	 */
	BETWEEN("between"),

	// Restrição de numérica

	/**
	 * Valor for maior.
	 */
	GT("gt"),

	/**
	 * Valor for maior ou igual.
	 */
	GE("ge"),

	/**
	 * Valor for menor.
	 */
	LT("lt"),

	/**
	 * Valor for menor ou igual.
	 */
	LE("le"),

	// Restrição de string

	/**
	 * Valor for semelhante diferenciando maiúsculas e minúsculas.
	 */
	LIKE(Constant.LIKE),

	/**
	 * Valor for semelhante no início diferenciando maiúsculas e minúsculas.
	 */
	LIKE_START(Constant.LIKE),

	/**
	 * Valor for semelhante no final diferenciando maiúsculas e minúsculas.
	 */
	LIKE_END(Constant.LIKE),

	/**
	 * Valor for semelhante sem diferenciar maiúsculas e minúsculas.
	 */
	ILIKE(Constant.LIKE),

	/**
	 * Valor for semelhante no início sem diferenciar maiúsculas e minúsculas.
	 */
	ILIKE_START(Constant.LIKE),

	/**
	 * Valor for semelhante ao final sem diferenciar maiúsculas e minúsculas.
	 */
	ILIKE_END(Constant.LIKE),

	/**
	 * Valor for não semelhante diferenciando maiúsculas e minúsculas.
	 */
	NOT_LIKE(Constant.NOT_LIKE),

	/**
	 * Valor for não semelhante em qualquer parte diferenciando maiúsculas e minúsculas.
	 */
	NOT_LIKE_MATCH(Constant.NOT_LIKE),

	/**
	 * Valor for não semelhante no início diferenciando maiúsculas e minúsculas.
	 */
	NOT_LIKE_MATCH_START(Constant.NOT_LIKE),

	/**
	 * Valor for não semelhante no final diferenciando maiúsculas e minúsculas.
	 */
	NOT_LIKE_MATCH_END(Constant.NOT_LIKE),

	/**
	 * Valor for não semelhante sem diferenciar maiúsculas e minúsculas.
	 */
	NOT_ILIKE(Constant.NOT_LIKE),

	/**
	 * Valor for não semelhante em qualquer parte sem diferenciar maiúsculas e minúsculas.
	 */
	NOT_ILIKE_MATCH(Constant.NOT_LIKE),

	/**
	 * Valor for não semelhante no início sem diferenciar maiúsculas e minúsculas.
	 */
	NOT_ILIKE_MATCH_START(Constant.NOT_LIKE),

	/**
	 * Valor for não semelhante ao final sem diferenciar maiúsculas e minúsculas.
	 */
	NOT_ILIKE_MATCH_END(Constant.NOT_LIKE),

	/**
	 * Contém os valores.
	 */
	IN(Constant.IN),

	/**
	 * Contém os valores em relacionamento.
	 */
	IN_JOIN(Constant.IN),

	/**
	 * Não contém os valores.
	 */
	NOT_IN(Constant.NOT_IN),

	/**
	 * Não contém os valores em relacionamento.
	 */
	NOT_IN_JOIN(Constant.NOT_IN),

	// Restrição de collection

	/**
	 * Collection está vazia.
	 */
	IS_EMPTY("isEmpty", false),

	/**
	 * Collection não está vazia.
	 */
	IS_NOT_EMPTY("isNotEmpty", false),

	/**
	 * Se valor existe dentro da Collection.
	 */
	IS_MEMBER("isMember"),

	/**
	 * Se valor não existe dentro da Collection.
	 */
	IS_NOT_MEMBER("isNotMember");

	/**
	 * Restrição.
	 */
	private String restriction;

	/**
	 * Se é necessário ter um valor.
	 */
	private boolean requiredValue = true;

	/**
	 * Construtor.
	 */
	private Restriction() {
	}

	/**
	 * Construtor com parâmetro.
	 *
	 * @param restriction Tipo de restrição
	 */
	private Restriction(final String restriction) {
		this.restriction = restriction;
	}

	/**
	 * Construtor com parâmetro.
	 *
	 * @param restriction Tipo de restrição
	 * @param requiredValue Se é necessário ter um valor.
	 */
	private Restriction(final String restriction, final boolean requiredValue) {
		this.restriction = restriction;
		this.requiredValue = requiredValue;
	}

	/**
	 * @return valor do restriction
	 */
	public String getRestriction() {
		return restriction;
	}

	/**
	 * @return valor do requiredValue
	 */
	public boolean isRequiredValue() {
		return requiredValue;
	}
}
