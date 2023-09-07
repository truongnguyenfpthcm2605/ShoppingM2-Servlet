package com.m2m.shopping.controller.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/product","/detail"})
public class ProductController  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        switch(path){
            case "/product":
                doGetProduct(req, resp);
                break;
            case "/detail":
                doDetatil(req, resp);
                break;
        }
    }

    protected void doGetProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/user/product.jsp").forward(req, resp);
    }

    protected void doDetatil(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/user/detail.jsp").forward(req, resp);
    }
}
