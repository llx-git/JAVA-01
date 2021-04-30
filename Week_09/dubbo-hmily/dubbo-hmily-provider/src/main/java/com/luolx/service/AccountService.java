package com.luolx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luolx.entity.Account;

/**
 * @Description:
 * @author: luolixi
 * @date: 2021-04-30
 */
public interface AccountService extends IService<Account> {
    void subMoneyUsd(Integer userId);

    void addMoneyCny(Integer userId);

    void subMoneyCny(Integer userId);

    void addMoneyUsd(Integer userId);
}
