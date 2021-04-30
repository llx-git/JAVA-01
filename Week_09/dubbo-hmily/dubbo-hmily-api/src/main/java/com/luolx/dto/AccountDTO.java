package com.luolx.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @author: luolixi
 * @date: 2021-04-30
 */
@Data
public class AccountDTO implements Serializable {

    private static final long serialVersionUID = 2767064987595878413L;

    public AccountDTO(Integer userId) {
        this.userId = userId;
    }

    private Integer accountId;

    private Integer userId;

    private Double moneyCny;

    private Double moneyUsd;
}
