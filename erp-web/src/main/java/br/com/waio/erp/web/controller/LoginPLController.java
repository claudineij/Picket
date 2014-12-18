/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.waio.erp.web.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.picketlink.Identity;
import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.PermissionManager;
import org.picketlink.idm.credential.Password;

import br.com.waio.erp.ejb.entity.Article;

/**
 * We control the authentication process from this action bean, so that in the event of a failed authentication we can add an
 * appropriate FacesMessage to the response.
 * 
 * @author Shane Bryzak
 * 
 */
@Model
public class LoginPLController {

    @Inject
    private Identity identity;

    @Inject
    PartitionManager partitionManager;

/*
    @Inject
    private FacesContext facesContext;
*/

    @PostConstruct
    public void createData() {
        // Create user john
        br.com.waio.erp.ejb.entity.identity.User john = new br.com.waio.erp.ejb.entity.identity.User("john");
/*
        john.setEmail("john@acme.com");
        john.setFirstName("John");
        john.setLastName("Smith");
*/

        IdentityManager identityManager = this.partitionManager.createIdentityManager();

        identityManager.add(john);
        identityManager.updateCredential(john, new Password("demo"));

        // Create user mary
        br.com.waio.erp.ejb.entity.identity.User mary = new br.com.waio.erp.ejb.entity.identity.User("mary");
/*
        mary.setEmail("mary@acme.com");
        mary.setFirstName("Mary");
        mary.setLastName("Jones");
*/
        identityManager.add(mary);
        identityManager.updateCredential(mary, new Password("demo"));


        PermissionManager permissionManager = partitionManager.createPermissionManager();

        // Grant both john and mary permission to create new articles
        permissionManager.grantPermission(john, Article.class, "create");
        permissionManager.grantPermission(john, Article.class, "update");
        permissionManager.grantPermission(john, Article.class, "delete");
        permissionManager.grantPermission(mary, Article.class, "create");
    }


    public void login() {
        this.identity.login();

        if (this.identity.isLoggedIn()) {
/*
            facesContext.addMessage(
                    null,
                    new FacesMessage("Authentication was unsuccessful.  Please check your username and password "
                            + "before trying again."));
*/
        }
    }
}
