package com.example.demo.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class Auther {
    private String id;
    private String name;

    public Auther(){
        this.id = UUID.randomUUID().toString();
    }
    public Auther(String name){
        this();
        this.name=name;
    }
}
