package com.api.gateway.domain;

import javax.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String clientId;

    @Column(nullable = true)
    private String clientSecret;

    @Column(nullable = false)
    private String clientType;

    @Column(nullable = false)
    private String scopes;

    @Column(nullable = false)
    private String authorizedGrantTypes;

    @Column(nullable = false)
    private String allowedResourceIDS;

    @Column(nullable = false)
    private String authorities;

    @Column(nullable = false)
    private String userAuthorities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
    }

    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getAllowedResourceIDS() {
        return allowedResourceIDS;
    }

    public void setAllowedResourceIDS(String allowedResourceIDS) {
        this.allowedResourceIDS = allowedResourceIDS;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public String getUserAuthorities() {
        return userAuthorities;
    }

    public void setUserAuthorities(String userAuthorities) {
        this.userAuthorities = userAuthorities;
    }
}
