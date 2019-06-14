package com.api.gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

@Configuration
@EnableAuthorizationServer
public class OAuthAuthorizationServer extends AuthorizationServerConfigurerAdapter {
    @Autowired
    CustomAuthenticationManager customAuthenticationManager;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    CustomClientDetailsService customClientDetailsService;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll")
                .checkTokenAccess("isAuthenticated");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // need to set the credentials, secret, scopes etc for clients
        clients.withClientDetails(customClientDetailsService);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        String defaultEndpoint = "/oauth/token";
        String customEndpoint = "/*/oauth/token";

        // changing oAuth2 token endpoint
        endpoints
                .pathMapping(defaultEndpoint, customEndpoint)
                .authenticationManager(customAuthenticationManager)
                .tokenStore(customJwtTokenStore())
                .accessTokenConverter(customJwtAccessTokenEnhancer());
    }



    @Bean
    public TokenStore customJwtTokenStore() {
        return new JwtTokenStore(customJwtAccessTokenEnhancer());
    }



    @Bean
    protected JwtAccessTokenConverter customJwtAccessTokenEnhancer() {
        // TODO externalize the keystore
        String internalKeystore = "eag-jwt-keystore.jks";
        String keyStorePassword = "I6X7O0H60X";
        String keyPairAlias = "j2-eag-api-jwt-dev";

        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource(internalKeystore),
                keyStorePassword.toCharArray());

        JwtAccessTokenConverter converter = new CustomJwtAccessTokenEnhancer();
        // for asymmetric signing/verification
        converter.setKeyPair(keyStoreKeyFactory.getKeyPair(keyPairAlias));

        return converter;
    }

}
