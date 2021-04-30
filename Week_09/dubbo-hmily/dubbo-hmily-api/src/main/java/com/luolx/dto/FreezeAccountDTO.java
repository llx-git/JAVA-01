package com.luolx.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @author: luolixi
 * @date: 2021-04-30
 */
@Data
public class FreezeAccountDTO implements Serializable {

    private static final long serialVersionUID = -1536942435343809026L;
    private Integer freezeId;

    private Integer userId;

    private Double moneyCny;

    private Double moneyUsd;

    private Integer isDeleted;
}
