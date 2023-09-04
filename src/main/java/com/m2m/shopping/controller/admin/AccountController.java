package com.m2m.shopping.controller.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin/accounts"}, name = "AccountControllerOfAdmin")
public class AccountController extends HttpServlet {

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

    private void doGetOverView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/admin/accounts.jsp").forward(req, resp);
    }

    private void doGetDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void doGetAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/admin/accounts_edit.jsp").forward(req, resp);
    }

    private void doGetEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
