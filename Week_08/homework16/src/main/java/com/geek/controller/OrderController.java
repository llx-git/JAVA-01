package com.geek.controller;

import com.geek.entity.OrderEntity;
import com.geek.service.OrderService;
import io.shardingsphere.transaction.annotation.ShardingTransactionType;
import io.shardingsphere.transaction.api.TransactionType;
import io.shardingsphere.transaction.api.TransactionTypeHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * addOne数据正常，addTwo数据异常，在不开启XA事务时，addOne数据插入成功，addTwo数据插入失败
     * 开启XA事务后，两者皆失败
     */
    @PostMapping
    @ShardingTransactionType(TransactionType.XA)
    public void addBatch() {
        orderService.inserData();
    }


}
