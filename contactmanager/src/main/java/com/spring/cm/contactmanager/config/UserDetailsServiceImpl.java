package com.spring.cm.contactmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spring.cm.contactmanager.dao.UserRepository;
import com.spring.cm.contactmanager.entities.User;

public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //fetching  user from database
        User user=userRepository.getUserByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException(username);
        }
        
        CustomUserDetails customUserDetails=new CustomUserDetails(user);
        return customUserDetails;

    }
        
}