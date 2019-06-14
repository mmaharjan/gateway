package com.api.gateway.security;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.HashMap;
import java.util.Map;

public class CustomJwtAccessTokenEnhancer extends JwtAccessTokenConverter {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        DefaultOAuth2AccessToken customAccessToken = new DefaultOAuth2AccessToken(accessToken);

        final Map<String, Object> additionalInfo = new HashMap();
        additionalInfo.put("organization", "name");
        additionalInfo.put("application", "gateway");


        // other enhancements go here

        customAccessToken.setAdditionalInformation(additionalInfo);
        return super.enhance(customAccessToken, authentication);
    }
}
