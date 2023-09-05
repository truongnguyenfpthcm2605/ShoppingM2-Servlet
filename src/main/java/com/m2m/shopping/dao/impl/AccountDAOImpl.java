package com.m2m.shopping.dao.impl;

import com.m2m.shopping.dao.AccountDAO;
import com.m2m.shopping.entity.Account;
import com.m2m.shopping.utils.JPAService;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class AccountDAOImpl implements AccountDAO{

    EntityManager em = JPAService.getEntityManager();
    @Override
    public Account findByUsernameAndPassword(String username, String password) {
        String sql = "SELECT o FROM Account o WHERE o.email = :username AND o.password = :password";
        TypedQuery<Account> query = em.createQuery(sql,Account.class);
        query.setParameter("username",username);
        query.setParameter("password",password);
        return query.getSingleResult();
    }
}
