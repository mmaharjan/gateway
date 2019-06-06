package com.api.gateway.security;

import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationManager {

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
