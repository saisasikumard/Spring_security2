package com.sasi.spring_security_telusko;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello(){
      return "Hello sasi..you can do it man..";
    }
}
