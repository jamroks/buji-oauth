/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package io.buji.oauth.filter;

import io.buji.oauth.ShiroUserSession;

import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.scribe.up.provider.OAuthProvider;

/**
 * This class specializes the PermissionsAuthorizationFilter to have a login url which is the authorization url of the OAuth provider.
 * 
 * @author Jerome Leleu
 * @since 1.0.0
 */
public class OAuthPermissionsAuthorizationFilter extends PermissionsAuthorizationFilter {
    
    private OAuthProvider provider;
    
    private ShiroUserSession shiroUserSession = new ShiroUserSession();
    
    public String getLoginUrl() {
        return provider.getAuthorizationUrl(shiroUserSession);
    }
    
    public void setProvider(OAuthProvider provider) {
        this.provider = provider;
    }
}
