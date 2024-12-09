package com.sasi.spring_security_telusko;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Student {
    int id;

    public Student(int id,String name,  String number) {
        this.name = name;
        this.id = id;
        this.number = number;
    }

    String name;
    String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
