package com.luolx;

import com.luolx.dto.AccountDTO;
import com.luolx.service.TransferMoneyService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: luolixi
 * @date: 2021-04-28
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @DubboReference
    private TransferMoneyService transferMoneyService;

    @GetMapping
    public void test() {

        transferMoneyService.transMoney("cny", new AccountDTO(1));
        transferMoneyService.transMoney("usd", new AccountDTO(2));
    }
}
