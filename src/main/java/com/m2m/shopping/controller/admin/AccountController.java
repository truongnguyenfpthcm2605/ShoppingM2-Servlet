package com.m2m.shopping.controller.admin;

import com.m2m.shopping.Service.AccountService;
import com.m2m.shopping.Service.Impl.AccontServiceImpl;
import com.m2m.shopping.entity.Account;
import com.m2m.shopping.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/accounts"}, name = "AccountControllerOfAdmin")
public class AccountController extends HttpServlet {

    private static AccountService accountService;

    @Override
    public void init() throws ServletException {
        super.init();
        accountService = new AccontServiceImpl();
    }

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
        String isEdit = req.getParameter("isEdit");
        switch (isEdit) {
            case "true" -> doPostEdit(req, resp);
            case "false" -> doPostAdd(req, resp);
        }
    }

    private void doGetOverView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Account> accounts = accountService.findAll();
        req.setAttribute("accounts", accounts);
        req.getRequestDispatcher("/views/admin/accounts.jsp").forward(req, resp);
    }

    private void doGetDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        Account account = accountService.findById(email);
        boolean isDeleted = accountService.delete(account);
        resp.sendRedirect("/admin/accounts?action=view");
    }

    private void doGetAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("isEdit", "false");
        req.getRequestDispatcher("/views/admin/accounts_edit.jsp").forward(req, resp);
    }

    private void doGetEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        Account account = accountService.findById(email);

        req.setAttribute("account", account);
        System.out.println(account.getGender());
        req.setAttribute("isEdit", "true");
        req.getRequestDispatcher("/views/admin/accounts_edit.jsp").forward(req, resp);
    }

    private void doPostAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.sendRedirect("/admin/accounts?action=view");
    }

    private void doPostEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.sendRedirect("/admin/accounts?action=view");
    }
}
