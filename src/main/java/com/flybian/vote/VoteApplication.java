package com.flybian.vote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VoteApplication {
    public static void main(String[] args){
        System.out.println("hello world");
        SpringApplication.run(VoteApplication.class,args);
    }
}
