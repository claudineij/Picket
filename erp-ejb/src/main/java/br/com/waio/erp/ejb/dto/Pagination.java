package br.com.waio.erp.ejb.dto;

import java.util.ArrayList;
import java.util.List;


import br.com.waio.erp.util.EqualsHashCode;

/**
 * Entidade responsavel pela configuração da paginação.
 * 
 * @author Fabio Zanardi | fabio.zanardi@waio.com.br
 * @since 2.0.0
 */
public class Pagination {

	/**
	 * Primeiro registro da paginação.
	 */
	private int first;

	/**
	 * Quantidade de itens por pagina.
	 */
	private int pageSize;

	/**
	 * Ordenação.
	 */
	private List<Sort> sorts = new ArrayList<Sort>();

	/**
	 * Filtros especificos da pesquisa.
	 */
	private List<Filter> filters = new ArrayList<Filter>();

	/**
	 * Construtor privado.
	 */
	@SuppressWarnings("unused")
	private Pagination() {

	}

	/**
	 * Construtor com filtros.
	 *
	 * @param filters {@link List} do tipo {@link Filter}
	 */
	public Pagination(final List<Filter> filters) {
		this.filters = filters;
	}

	/**
	 * Construtor com filtro.
	 *
	 * @param filter do tipo {@link Filter}
	 */
	public Pagination(final Filter filter) {
		this.filters.add(filter);
	}

	/**
	 * Construtor com ordenação e filtro.
	 *
	 * @param sort Ordenação do tipo {@link Sort}
	 * @param filter Filtro para pesquisa do tipo {@link Filter}
	 */
	public Pagination(final Sort sort, final Filter filter) {
		this.sorts.add(sort);
		this.filters.add(filter);
	}

	/**
	 * Construtor com lista de ordenação e um filtro.
	 *
	 * @param sorts {@link List} do tipo {@link Sort}
	 * @param filter Filtro para pesquisa do tipo {@link Filter}
	 */
	public Pagination(final List<Sort> sorts, final Filter filter) {
		this.sorts = sorts;
		this.filters.add(filter);
	}

	/**
	 * Construtor com ordenação e lista de filtro.
	 *
	 * @param sort Ordenação do tipo {@link Sort}
	 * @param filters {@link List} do tipo {@link Filter}
	 */
	public Pagination(final Sort sort, final List<Filter> filters) {
		this.sorts.add(sort);
		this.filters = filters;
	}

	/**
	 * Construtor com lista de ordenação e filtro.
	 *
	 * @param sorts {@link List} do tipo {@link Sort}
	 * @param filters {@link List} do tipo {@link Filter}
	 */
	public Pagination(final List<Sort> sorts, final List<Filter> filters) {
		this.sorts = sorts;
		this.filters = filters;
	}

	/**
	 * Construtor sobescrito inicio, tamanho da página, ordenação e lista de filtro.
	 *
	 * @param first Primeiro registro
	 * @param pageSize Total por página
	 * @param sort Ordenação do tipo {@link Sort}
	 * @param filters {@link List} do tipo {@link Filter}
	 */
	public Pagination(final int first, final int pageSize, final Sort sort, final List<Filter> filters) {
		this.first = first;
		this.pageSize = pageSize;
		this.sorts.add(sort);
		this.filters = filters;
	}

	/**
	 * Construtor sobescrito inicio, tamanho da página, lista de ordenação e lista de filtro.
	 *
	 * @param first Primeiro registro
	 * @param pageSize Total por página
	 * @param sorts {@link List} do tipo {@link Sort}
	 * @param filters {@link List} do tipo {@link Filter}
	 */
	public Pagination(final int first, final int pageSize, final List<Sort> sorts, final List<Filter> filters) {
		this.first = first;
		this.pageSize = pageSize;
		this.sorts = sorts;
		this.filters = filters;
	}

	/**
	 * @return valor do first
	 */
	public int getFirst() {
		return first;
	}

	/**
	 * @return valor do pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @return valor do sorts
	 */
	public List<Sort> getSorts() {
		return sorts;
	}

	/**
	 * @return valor do filters
	 */
	public List<Filter> getFilters() {
		return filters;
	}

	@Override
	public int hashCode() {
		return EqualsHashCode.hashCode(this.first, this.pageSize, this.filters, this.sorts);
	}

	@Override
	public boolean equals(final Object other) {
		if (other instanceof Pagination) {
			final Pagination otherPagination = (Pagination) other;

			return EqualsHashCode.equalsHelper()
								 .append(this.first, otherPagination.first)
								 .append(this.pageSize, otherPagination.pageSize)
								 .append(this.filters, otherPagination.filters)
								 .append(this.sorts, otherPagination.sorts)
								 .isEquals();
		}

		return false;
	}

}
