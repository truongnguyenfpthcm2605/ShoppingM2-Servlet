package com.m2m.shopping.Service;

import com.m2m.shopping.entity.Account;

import javax.servlet.ServletContext;

public interface EmailService {
    void sendMail(ServletContext context, Account recipient, String type);
}
