package com.crow.fakeqq.controller;

import com.crow.fakeqq.entity.Account;
import com.crow.fakeqq.repository.AccountRepository;
import com.crow.fakeqq.service.AccountService;
import com.crow.fakeqq.util.IdUtils;
import com.crow.fakeqq.util.TimestampUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RestController
public class AccountController {
    @Resource
    AccountService accountService;
    @PostMapping("/register")
    public Object register(Account account){
        account.setId(IdUtils.getUUID());
        account.setCreate_time(TimestampUtils.getTimestamp());
        return accountService.userRegister(account);
    }

}
