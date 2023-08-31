package com.m2m.shopping.utils;

import javax.servlet.http.HttpSession;

public class SessionUtils {

    public static HttpSession session;

    public static Object getSession(String name){
        return session.getAttribute(name);
    }

    public static void setSession(String name, Object value){
        session.setAttribute(name,value);
    }

    public static void removeSession(String name){
        session.removeAttribute(name);
    }
}
