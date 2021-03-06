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

import org.picketlink.Identity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * We control the authentication process from this action bean, so that in the event of a failed authentication we can add an
 * appropriate FacesMessage to the response.
 *
 * @author Shane Bryzak
 *
 */
@Named
@Stateless
public class LoginPLController {

    @Inject
    private Identity identity;

    public void login() {
        this.identity.login();

        if (this.identity.isLoggedIn()) {
            // user logged in
        }
    }
}
