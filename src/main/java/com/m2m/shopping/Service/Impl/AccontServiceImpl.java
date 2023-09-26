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
    public Account findById(String id) {
        return super.findByid(Account.class, id);
    }

    @Override
    public boolean delete(Account entity) {
        entity.setIsActive(false);
        try {
            super.save(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Account findByToken(String token) {
        String sql = "Select o from Account o where o.token == ?";
        return super.findOne(Account.class, sql,token);
    }


}
