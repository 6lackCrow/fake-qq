package com.crow.fakeqq.controller;

import com.crow.fakeqq.entity.Account;
import com.crow.fakeqq.entity.Token;
import com.crow.fakeqq.repository.AccountRepository;
import com.crow.fakeqq.service.AccountService;
import com.crow.fakeqq.service.TokenService;
import com.crow.fakeqq.util.IdUtils;
import com.crow.fakeqq.util.TimestampUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
public class AccountController {
    @Resource
    AccountService accountService;
    @Resource
    TokenService tokenService;
    @PostMapping("/register")
    public Object register(Account account){
        account.setId(IdUtils.getUUID());
        account.setCreate_time(TimestampUtils.getTimestamp());
        return accountService.userRegister(account);
    }
    @PostMapping("/login")
    public Object login(String username,String password){
        if (username == null && username == ""){
            return ResponseEntity.badRequest().body("请输入用户名称");
        }
        if (password == null && password == ""){
            return ResponseEntity.badRequest().body("请输入密码");
        }
        Account account = accountService.findAccountByUsername(username);
        if (account == null){
            return ResponseEntity.badRequest().body("用户未找到");
        }
        if(password.equals(account.getPassword())){
            Token token = new Token();
            token.setUser_id(account.getId());
            token.setToken(IdUtils.getUUID());
            tokenService.setToken(token);
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(403).body("密码不正确");
    }
    @GetMapping("/userinfo")
    public Object getUserInfo(String userid,String token){
        Token tokenByToken = tokenService.findTokenByToken(token);
        if (tokenByToken == null){
            return ResponseEntity.status(401).build();
        }
        if(!tokenByToken.getUser_id().equals(userid)){
            return ResponseEntity.status(401).build();
        }
        Optional<Account> accountOptional = Optional.ofNullable(accountService.findAccountById(userid));
        if (accountOptional.isPresent()){
            return accountOptional.get();
        }
        return ResponseEntity.notFound().build();
    }

}
