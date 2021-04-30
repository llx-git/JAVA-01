package com.luolx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description:
 * @author: luolixi
 * @date: 2021-04-30
 */
@Data
@TableName("hmily.account")
public class Account {

    @TableId(type = IdType.AUTO)
    private Integer accountId;

    private Integer userId;

    private Double moneyCny;

    private Double moneyUsd;
}
