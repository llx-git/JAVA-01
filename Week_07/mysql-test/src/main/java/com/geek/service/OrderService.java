package com.geek.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.geek.entity.OrderEntity;

/**
 * @Description:
 * @author: luolixi
 * @date: 2021-03-02
 */
public interface OrderService extends IService<OrderEntity> {

    void loadData(String filePath);
}
