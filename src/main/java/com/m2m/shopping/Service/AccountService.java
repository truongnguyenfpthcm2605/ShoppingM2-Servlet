package com.m2m.shopping.Service;

import com.m2m.shopping.entity.Account;

import java.util.List;

public interface AccountService {

    Account save(Account account);
    Account create(Account account);
    List<Account> findAll();
    Account findById(String id);
    boolean delete(Account account);

    Account findByUsernameAndPassword(String username, String password);

    Account findByToken(String token);
}
