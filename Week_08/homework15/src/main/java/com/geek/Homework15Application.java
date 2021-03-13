package com.geek;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@MapperScan(basePackages = "com.geek.mapper")
@SpringBootApplication(exclude = JtaAutoConfiguration.class)
public class Homework15Application {

    public static void main(String[] args) {
        SpringApplication.run(Homework15Application.class, args);
    }

}
