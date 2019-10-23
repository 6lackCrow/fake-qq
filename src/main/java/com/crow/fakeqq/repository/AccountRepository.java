package com.crow.fakeqq.repository;

import com.crow.fakeqq.entity.Account;
import com.crow.fakeqq.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String > {
    Account findAccountByUsername(String username);
    Account findAccountById(String id);
}
