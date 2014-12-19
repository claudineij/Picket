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
package br.com.waio.erp.ejb.security;

import br.com.waio.erp.ejb.entity.identity.Application;
import br.com.waio.erp.ejb.entity.identity.ApplicationAccess;
import br.com.waio.erp.ejb.entity.identity.ApplicationRealm;
import br.com.waio.erp.ejb.entity.identity.Grant;
import br.com.waio.erp.ejb.entity.identity.Group;
import br.com.waio.erp.ejb.entity.identity.GroupMembership;
import br.com.waio.erp.ejb.entity.identity.Realm;
import br.com.waio.erp.ejb.entity.identity.Role;
import br.com.waio.erp.ejb.entity.identity.User;
import org.picketlink.config.SecurityConfigurationBuilder;
import org.picketlink.event.SecurityConfigurationEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

/**
 * This bean produces the configuration for PicketLink IDM
 *
 * @author Shane Bryzak
 */
@ApplicationScoped
public class SecurityConfiguration {

    public void onInit(@Observes SecurityConfigurationEvent event) {
        SecurityConfigurationBuilder builder = event.getBuilder();

        builder.idmConfig()
            .named("default")
                .stores()
                    .jpa()
            .supportType(User.class, Role.class, Group.class, Realm.class, Application.class, ApplicationRealm.class)
            .supportGlobalRelationship(Grant.class, GroupMembership.class, ApplicationAccess.class)
            .supportPermissions(true)
            .supportCredentials(true);
    }

}
