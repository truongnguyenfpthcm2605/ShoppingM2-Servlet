package com.m2m.shopping.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
    private static final int time  = 864000;
    public Object getCookie(HttpServletRequest request, String name){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if(cookie.getName().equals(name)){
                return cookie;
            }
        }
        return null;
    }

    public void setCookie(HttpServletRequest request,HttpServletResponse response, String name, String value){
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(time);
        response.addCookie(cookie);
    }

    public void removeCookie(HttpServletRequest request,HttpServletResponse response, String name, String value){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if(cookie.getName().equals(name)){
                cookie.setMaxAge(0);
            }
        }
    }
}
