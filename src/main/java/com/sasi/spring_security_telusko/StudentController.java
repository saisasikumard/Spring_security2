package com.sasi.spring_security_telusko;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<Student> students=new ArrayList<>(List.of(
            new Student(1,"sai","9505726263"),
            new Student(2,"naveen","7887878788")
    ));
    @GetMapping("/students")
    public List<Student> students(){
        return students;
    }
    //get csrf token request to perform POST ,PUT,DELETE
    @GetMapping("/csrf")
    public CsrfToken csrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");

    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }


}
