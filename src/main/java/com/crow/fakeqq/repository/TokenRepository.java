package com.crow.fakeqq.repository;

import com.crow.fakeqq.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token,Long> {
    Token findTokenByToken(String token);
}
