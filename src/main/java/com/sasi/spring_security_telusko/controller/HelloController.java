package com.sasi.spring_security_telusko.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello(HttpServletRequest request){

      return "Hello sasi..you can do it man.."+request.getSession().getId();
    }
}
