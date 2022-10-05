package org.ysfyrdmcl.config.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.ysfyrdmcl.services.AuthService;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetails implements UserDetailsService {
    @Autowired
    AuthService authService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
    public UserDetails loadUserByUserId(Long authId) throws UsernameNotFoundException {

        boolean isUserExist = authService.findById(authId).getId() != null;
        if(isUserExist){
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            authorities.add(new SimpleGrantedAuthority("ADMIN"));


            return User.builder() .username(authId.toString())
                    .password("")
                    .accountExpired(false)
                    .accountLocked(false)
                    .authorities(authorities)
                    .build();
        }
        return null ;
    }













}
