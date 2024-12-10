package com.sasi.spring_security_telusko.repo;

import com.sasi.spring_security_telusko.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {
    public Users findByUsername(String username);
}
