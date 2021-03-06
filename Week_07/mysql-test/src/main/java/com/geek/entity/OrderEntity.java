package com.geek.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @author: luolixi
 * @date: 2021-03-02
 */
@Data
@TableName("mysql_test.t_order")
public class OrderEntity implements Serializable {

    @TableField
    private String orderId;
    private String userId;
    private String goodsId;
    private Double money;
    private String status;
    private Date createTime;
    @TableLogic
    private Integer isDeleted;
}
