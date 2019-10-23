package com.crow.fakeqq.repository;

import com.crow.fakeqq.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String > {
}
