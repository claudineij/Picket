package br.com.waio.erp.ejb.dao;

import br.com.waio.erp.ejb.entity.Article;

import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * Implementação para manipulação de dados do cargo.
 *
 * @since 2.0.0
 *
 * @author <a href="mail:fabio.zanardi@w2z.com.br">Fábio Zanardi</a>
 */
@Stateless
@Local
public class ArticleDAOImpl extends AbstractDAOImpl<Article, Long> implements ArticleDAO {

	/**
	 * Construtor.
	 */
	public ArticleDAOImpl() {
		this.setFieldsIs(new String[] { "id" });
	}

}
