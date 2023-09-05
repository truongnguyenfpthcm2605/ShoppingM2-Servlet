package com.m2m.shopping.dao;

import com.m2m.shopping.entity.Account;

public interface AccountDAO {

    Account findByUsernameAndPassword(String username,String password);
}
