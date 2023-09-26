package com.m2m.shopping.controller.user;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/home","/contact"})
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        switch(path){
            case "/home":
                doGetIndex(req, resp);
                break;
            case "/contact":
                doGetContact(req, resp);
                break;
        }

    }

    protected void doGetIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/user/index.jsp").forward(req, resp);
    }
    protected void doGetContact(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/user/contact.jsp").forward(req, resp);
    }

}
