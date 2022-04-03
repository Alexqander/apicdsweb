package com.cds.mx.apicds.security.controller;

import com.cds.mx.apicds.security.model.AuthUser;
import com.cds.mx.apicds.user.controller.UserService;
import com.cds.mx.apicds.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthService implements UserDetailsService {

    @Autowired
    UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByUsername(username).get();
        return AuthUser.build(user);
    }


}
