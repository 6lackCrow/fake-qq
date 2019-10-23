package com.crow.fakeqq.service;

import com.crow.fakeqq.entity.Token;
import com.crow.fakeqq.repository.TokenRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class TokenService {
    @Resource
    TokenRepository tokenRepository;

    public Token setToken(Token token){
        return tokenRepository.save(token);
    }
    public Token findTokenByToken(String token){
        return tokenRepository.findTokenByToken(token);
    }
}
