package com.api.gateway.security;

import com.api.gateway.domain.User;
import com.api.gateway.security.UserPrincipal;
import com.api.gateway.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println("the user name is :" + userName);
        User user = userRepository.findByUsername(userName);

        if(user == null) {
            throw new UsernameNotFoundException("username not found in the database");
        }

        System.out.println("user: " + user.getUsername() );
        return new UserPrincipal(user);
    }
}
