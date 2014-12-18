/*
 * JBoss, Home of Professional Open Source
 *
 * Copyright 2013 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.waio.erp.web.controller;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.picketlink.Identity;
import org.picketlink.authorization.annotations.RequiresPermission;
import org.picketlink.idm.PermissionManager;
import org.picketlink.idm.model.basic.User;

import br.com.waio.erp.ejb.dao.ArticleDAO;
import br.com.waio.erp.ejb.entity.Article;
import br.com.waio.erp.util.exception.ChangeCollisionException;
import br.com.waio.erp.util.exception.FieldInvalidException;
import br.com.waio.erp.util.exception.ObjectEmptyException;
import br.com.waio.erp.util.exception.ObjectExistsException;
import br.com.waio.erp.util.exception.ObjectNotFoundException;

/**
 * Action bean for Article related operations
 *
 * @author Shane Bryzak
 * @author Pedro Igor
 */
@Named
//@Stateful
@ConversationScoped
public class ArticleController implements Serializable {

/*
    @Inject
    EntityManager entityManager;
*/

    @EJB
    ArticleDAO articleDAO;

    @Inject
    Conversation conversation;

    @Inject
    Identity identity;

    @Inject
    PermissionManager permissionManager;

    private Article article;

    @RequiresPermission(resourceClass = Article.class, operation = "create")
    public String showCreate() {
        conversation.begin();
        article = new Article();
        return "/article.xhtml";
    }

    @RequiresPermission(resourceClass = Article.class, operation = "update")
    public String showUpdate(Article article) {
        conversation.begin();
        try {
            this.article = articleDAO.getById(article.getId());
        } catch (FieldInvalidException e) {
            e.printStackTrace();
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
        }
        //this.article = this.entityManager.find(article.getClass(), article.getId());
        return "/article.xhtml";
    }

    public String create() {
        User user = (User) identity.getAccount();
        article.setAuthor(user.getFirstName() + " " + user.getLastName());
        try {
            articleDAO.save(article);
        } catch (ObjectEmptyException e) {
            e.printStackTrace();
        } catch (FieldInvalidException e) {
            e.printStackTrace();
        } catch (ObjectExistsException e) {
            e.printStackTrace();
        }
        //entityManager.persist(article);

        // Grant the creating user permission to delete the article
        permissionManager.grantPermission(user, article, "update, delete");

        conversation.end();

        return "/home.xhtml";
    }

    public String update() {
        Article articleToUpdate = getArticle();

        if (!this.identity.hasPermission(articleToUpdate, "update") && !this.identity.hasPermission(Article.class, "update")) {
/*
            facesContext.addMessage(
                null,
                new FacesMessage("You can not update this article. Are you the owner ?"));
*/
        } else {
            //Article storedArticle = this.entityManager.find(articleToUpdate.getClass(), articleToUpdate.getId());
            Article storedArticle = null;
            try {
                storedArticle = articleDAO.getById(articleToUpdate.getId());
            } catch (FieldInvalidException e) {
                e.printStackTrace();
            } catch (ObjectNotFoundException e) {
                e.printStackTrace();
            }

            storedArticle.setContent(articleToUpdate.getContent());
            storedArticle.setTitle(articleToUpdate.getTitle());

            try {
                articleDAO.update(articleToUpdate);
            } catch (ObjectEmptyException e) {
                e.printStackTrace();
            } catch (FieldInvalidException e) {
                e.printStackTrace();
            } catch (ObjectExistsException e) {
                e.printStackTrace();
            } catch (ChangeCollisionException e) {
                e.printStackTrace();
            }
            //this.entityManager.merge(storedArticle);
        }

        conversation.end();

        return "/home.xhtml";
    }

    public String delete(Article articleToDelete) {
        if (!this.identity.hasPermission(articleToDelete, "delete")) {
/*
            facesContext.addMessage(
                null,
                new FacesMessage("You can not delete this article. Are you the owner ?"));
*/
        } else {
            //Article storedArticle = this.entityManager.find(articleToDelete.getClass(), articleToDelete.getId());

            //this.entityManager.remove(storedArticle);
        }

        return "/home.xhtml";
    }

    public List<Article> getArticles() {
        //return this.entityManager.createQuery("select a from Article a").getResultList();
        return articleDAO.list(null);
    }

    public Article getArticle() {
        return article;
    }
}
