package com.luolx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @author: luolixi
 * @date: 2021-04-30
 */
@Data
@TableName("hmily.freeze_account")
public class FreezeAccount implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer freezeId;

    private Integer userId;

    private Double moneyCny;

    private Double moneyUsd;

    @TableLogic
    private Integer isDeleted;
}
