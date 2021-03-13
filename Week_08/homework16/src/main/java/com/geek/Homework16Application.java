package com.geek;

import com.geek.conf.TransactionConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(TransactionConfiguration.class)
public class Homework16Application {

    public static void main(String[] args) {
        SpringApplication.run(Homework16Application.class, args);
    }

}
