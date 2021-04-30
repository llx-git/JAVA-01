package com.luolx.dubbo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.luolx.dto.AccountDTO;
import com.luolx.entity.Account;
import com.luolx.entity.FreezeAccount;
import com.luolx.service.AccountService;
import com.luolx.service.FreezeAccountService;
import com.luolx.service.TransferMoneyService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 金钱转换
 * @author: luolixi
 * @date: 2021-04-28
 */
@DubboService
public class TransferMoneyServiceImpl implements TransferMoneyService {

    @Autowired
    private AccountService accountService;
    @Autowired
    private FreezeAccountService freezeAccountService;

    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public void transMoney(String sign, AccountDTO accountDTO) {
        FreezeAccount freezeAccount = new FreezeAccount();
        freezeAccount.setUserId(accountDTO.getUserId());
        //1美元换7人民币
        if (StringUtils.equals(sign, "cny")) {
            //准备数据，将1美元冻结
            accountService.subMoneyUsd(accountDTO.getUserId());

            freezeAccount.setMoneyUsd(1D);
            freezeAccountService.save(freezeAccount);
        } else {
            //7人民币换1美元
            accountService.subMoneyCny(accountDTO.getUserId());

            freezeAccount.setMoneyCny(7D);
            freezeAccountService.save(freezeAccount);
        }
    }

    public void confirm(String sign, AccountDTO accountDTO) {
        //1美元换7人民币
        if (StringUtils.equals(sign, "cny")) {
            accountService.addMoneyCny(accountDTO.getUserId());

            QueryWrapper<FreezeAccount> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", accountDTO.getUserId());
            freezeAccountService.remove(queryWrapper);
        } else {
            //7人民币换1美元
            accountService.addMoneyUsd(accountDTO.getUserId());

            QueryWrapper<FreezeAccount> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", accountDTO.getUserId());
            freezeAccountService.remove(queryWrapper);
        }
    }

    public void cancel(String sign, AccountDTO accountDTO) {
        //1美元换7人民币
        if (StringUtils.equals(sign, "cny")) {
            accountService.addMoneyUsd(accountDTO.getUserId());
        } else {
            accountService.addMoneyCny(accountDTO.getUserId());
        }
    }
}
