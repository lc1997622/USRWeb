package com.example.usrweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.usrweb.dao")
public class UsrwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsrwebApplication.class, args);
    }

}
