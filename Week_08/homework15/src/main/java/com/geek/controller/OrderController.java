package com.geek.controller;

import com.geek.entity.OrderEntity;
import com.geek.service.OrderService;
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

    @GetMapping
    public List<OrderEntity> list(){
        return orderService.list();
    }

    @PostMapping
    public void add(@RequestBody OrderEntity orderEntity){
        orderService.save(orderEntity);
    }

    @PutMapping
    public void update(@RequestBody OrderEntity orderEntity){
        orderService.save(orderEntity);
    }

    @DeleteMapping("{orderId}")
    public void delete(@PathVariable Long orderId){
        orderService.removeById(orderId);
    }
}
