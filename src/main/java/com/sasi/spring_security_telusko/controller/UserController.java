package com.sasi.spring_security_telusko.controller;

import com.sasi.spring_security_telusko.entity.Users;
import com.sasi.spring_security_telusko.repo.UserRepo;
import com.sasi.spring_security_telusko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepo repo;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userService.register(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/get")
    public List<Users> usersList(){
        return repo.findAll();
    }
}
