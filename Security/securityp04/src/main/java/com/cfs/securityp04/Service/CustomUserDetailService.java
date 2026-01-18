package com.cfs.securityp04.Service;

import com.cfs.securityp04.Entity.appUser;
import com.cfs.securityp04.Repo.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private userRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername method called....");
        appUser user=userRepository.findByName(username)
                .orElseThrow(()->new UsernameNotFoundException("User not found "+username));
        System.out.println("Found username = "+user.getName() + " / " +user.getPassword());

        return new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(),user.isEnabled(),true,true,true,
                //user.getRoles().stream().map(role->new SimpleGrantedAuthority(role.getName())).toList()
                user.getRole().stream().map(role -> new SimpleGrantedAuthority("ROLE_" +role.getName())).toList());

    }
}
