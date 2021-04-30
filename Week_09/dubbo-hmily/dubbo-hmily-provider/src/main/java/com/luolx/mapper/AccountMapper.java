package com.luolx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luolx.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @author: luolixi
 * @date: 2021-04-30
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
    void subMoneyUsd(@Param("userId") Integer userId);

    void addMoneyCny(@Param("userId") Integer userId);

    void subMoneyCny(@Param("userId") Integer userId);

    void addMoneyUsd(@Param("userId") Integer userId);
}
