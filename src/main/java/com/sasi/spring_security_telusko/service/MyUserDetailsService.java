package com.sasi.spring_security_telusko.service;

import com.sasi.spring_security_telusko.entity.UserPrinciples;
import com.sasi.spring_security_telusko.entity.Users;
import com.sasi.spring_security_telusko.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user= repo.findByUsername(username);
        if(user==null){
            System.out.println("no user exist");
            throw  new UsernameNotFoundException("User not found");
        }
        return  new UserPrinciples(user);
    }
}
