package com.auth.config;

import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Map;

public class CustomJwtAccessTokenConverter extends JwtAccessTokenConverter implements JwtAccessTokenConverterConfigurer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        var defaultAccessToken = new DefaultOAuth2AccessToken(accessToken);
        defaultAccessToken.setAdditionalInformation(
                Map.of("email", "example@jwt.com", "applicationName", "auth-server"));
        return super.enhance(defaultAccessToken, authentication);
    }

    @Override
    public void configure(JwtAccessTokenConverter jwtAccessTokenConverter) {
        jwtAccessTokenConverter.setAccessTokenConverter(this);
    }
}
