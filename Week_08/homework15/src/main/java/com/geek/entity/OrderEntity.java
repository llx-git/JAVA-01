package com.geek.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @author: luolixi
 * @date: 2021-03-02
 */
@Data
@TableName("demo_ds.t_order")
public class OrderEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long orderId;
    private Long userId;
    private Long goodsId;
    private Double money;
    private String status;
    private Date createTime;
    @TableLogic
    private Integer isDeleted;
}
