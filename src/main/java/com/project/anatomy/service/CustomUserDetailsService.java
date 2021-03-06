package com.project.anatomy.service;

import com.project.anatomy.CustomUserDetails;
import com.project.anatomy.repository.UserRepository;
import com.project.anatomy.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = repo.findByLogin(login);
        if(user==null){
            throw new UsernameNotFoundException("User not found.");
        }
        return new CustomUserDetails(user);
    }
}
