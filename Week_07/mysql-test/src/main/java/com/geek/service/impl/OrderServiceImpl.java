package com.geek.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geek.entity.OrderEntity;
import com.geek.mapper.OrderMapper;
import com.geek.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @author: luolixi
 * @date: 2021-03-02
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements OrderService {


    @Override
    public void loadData(String filePath) {
        this.baseMapper.loadData(filePath);
    }
}
