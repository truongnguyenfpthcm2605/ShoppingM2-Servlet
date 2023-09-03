package com.m2m.shopping.controller.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin/products"}, name = "ProductControllerOfAdmin")
public class ProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "view" -> doGetOverView(req, resp);
            case "delete" -> doGetDelete(req, resp);
            case "add" -> doGetAdd(req, resp);
            case "edit" -> doGetEdit(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void doGetOverView(HttpServletRequest req, HttpServletResponse resp) {

    }

    public void doGetDelete(HttpServletRequest req, HttpServletResponse resp) {

    }

    public void doGetAdd(HttpServletRequest req, HttpServletResponse resp) {

    }

    public void doGetEdit(HttpServletRequest req, HttpServletResponse resp) {

    }
}
