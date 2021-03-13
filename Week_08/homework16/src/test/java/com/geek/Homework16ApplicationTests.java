package com.geek;

import com.geek.conf.TransactionConfiguration;
import com.geek.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(TransactionConfiguration.class)
class Homework16ApplicationTests {

    @Autowired
    private OrderService orderService;
    @Test
    void contextLoads() {
        orderService.inserData();
    }

}
