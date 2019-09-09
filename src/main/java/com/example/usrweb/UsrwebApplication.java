package com.example.usrweb;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class UsrwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsrwebApplication.class, args);
    }

}
