package com.m2m.shopping.Service.Impl;

import com.m2m.shopping.Service.AccountService;
import com.m2m.shopping.entity.Account;
import com.m2m.shopping.repository.JpaRepository;

import java.util.List;

public class AccontServiceImpl extends JpaRepository<Account> implements AccountService {
    @Override
    public Account save(Account account) {
        return super.save(account);
    }

    @Override
    public Account create(Account account) {
        return super.create(account);
    }

    @Override
    public List<Account> findAll() {
        return super.findAll(Account.class, true);
    }

    @Override
    public boolean delete(Account enity) {
        return super.delete(enity);
    }

    @Override
    public Account findByUsernameAndPassword(String username, String password) {
        String sql = "SELECT o FROM Account o WHERE o.email = ?0 AND o.password = ?1";
        return super.findOne(Account.class, sql, username, password);
    }

    @Override
    public Account findByToken(String token) {
        String sql = "SELECT o FROM Account o WHERE o.token = ?0";
        return super.findOne(Account.class, sql, token);
    }

    @Override
    public Account findByEmail(String email) {
        String sql = "SELECT o FROM Account o WHERE o.email = ?0";
        return super.findOne(Account.class, sql, email);
    }


}
