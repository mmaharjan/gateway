package com.api.gateway.security;

import org.springframework.security.oauth2.provider.client.BaseClientDetails;

public class OAuth2ClientDetails extends BaseClientDetails {
    private String userAuthorities;
    private String clientType;


    public OAuth2ClientDetails(String clientId, String resourceIds, String scopes, String grantTypes,
                               String authorities, String userAuthorities, String clientType) {
        super(clientId, resourceIds, scopes, grantTypes, authorities);
        this.userAuthorities = userAuthorities;
        this.clientType = clientType;
    }

    public String getUserAuthorities(){
        return userAuthorities;
    }


    public String getClientType(){
        return clientType;
    }
}
