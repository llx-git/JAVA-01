package com.luolx.service;

import com.luolx.dto.AccountDTO;
import org.dromara.hmily.annotation.Hmily;

/**
 * @Description:
 * @author: luolixi
 * @date: 2021-04-28
 */

public interface TransferMoneyService {

    @Hmily
    void transMoney(String sign, AccountDTO accountDTO);
}
