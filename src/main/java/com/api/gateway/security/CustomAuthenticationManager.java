package com.api.gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationManager implements AuthenticationManager {

    // autowire authentication providers here
    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    private ClientDetailsService clientDetailsService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {


        //OAuth2ClientDetails clientDetails =

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken;

        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(userName);
        usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails.getUsername(),
                userDetails.getPassword());

//        usernamePasswordAuthenticationToken.

        return usernamePasswordAuthenticationToken;
    }


}


/*@Service
public class CustomAuthenticationManager implements AuthenticationManager {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken;

        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(userName);
        usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails.getUsername(),
                userDetails.getPassword());

        return usernamePasswordAuthenticationToken;
    }

}*/
