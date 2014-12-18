package br.com.waio.erp.ejb.enums;

/**
 * Enum de ordenação.
 * 
 * @author Fabio Zanardi | fabio.zanardi@waio.com.br
 * @author Vitor de Moraes | vitor.moraes@waio.com.br
 * @since 2.0.3
 */
public enum SortOrder {

	/**
	 * Ordenação crescente.
	 */
	ASCENDING,

	/**
	 * Ordenação decrescente.
	 */
	DESCENDING;

	/**
	 * Construtor.
	 */
	private SortOrder() {
	}

	/**
	 * Verifica se existe valor no enum.
	 * 
	 * @param value do {@link Enum}
	 * @return um {@link Boolean}
	 */
	public static boolean contains(final String value) {
		try {
			SortOrder.valueOf(value);
			return true;
		} catch (final Exception e) {
			return false;
		}
	}

}
