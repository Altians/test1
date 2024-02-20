package com.example.appdo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.appdo.mapper")
public class AppDoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppDoApplication.class, args);
    }

}
