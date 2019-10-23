package com.crow.fakeqq.service;

import com.crow.fakeqq.entity.Account;
import com.crow.fakeqq.repository.AccountRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class AccountService {
    @Resource
    AccountRepository accountRepository;
    public Object userRegister(Account account){
        return accountRepository.save(account);
    }
    public Account findAccountByUsername(String username){
        return accountRepository.findAccountByUsername(username);
    }
    public Account findAccountById(String id){
        return accountRepository.findAccountById(id);
    }
}
