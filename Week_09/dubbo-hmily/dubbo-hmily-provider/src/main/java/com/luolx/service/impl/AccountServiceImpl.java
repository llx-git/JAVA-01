package com.luolx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luolx.entity.Account;
import com.luolx.mapper.AccountMapper;
import com.luolx.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @author: luolixi
 * @date: 2021-04-30
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Override
    public void subMoneyUsd(Integer userId) {
        this.baseMapper.subMoneyUsd(userId);
    }

    @Override
    public void addMoneyCny(Integer userId) {
        this.baseMapper.addMoneyCny(userId);
    }

    @Override
    public void subMoneyCny(Integer userId) {
        this.baseMapper.subMoneyCny(userId);
    }

    @Override
    public void addMoneyUsd(Integer userId) {
        this.baseMapper.addMoneyUsd(userId);
    }
}
