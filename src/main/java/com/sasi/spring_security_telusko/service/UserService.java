package com.sasi.spring_security_telusko.service;

import com.sasi.spring_security_telusko.entity.Users;
import com.sasi.spring_security_telusko.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public Users register(Users user){
        return userRepo.save(user);
    }
}
