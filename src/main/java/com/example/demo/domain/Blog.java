package com.example.demo.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class Blog {

   private String id;
   private String title;
   private Auther auther;
   private Intraction intraction;

   public Blog(){
      this.id = UUID.randomUUID().toString();
   }
   public Blog(String title,Auther auther){
      this();
      this.auther=auther;
      this.title = title;
   }

}
