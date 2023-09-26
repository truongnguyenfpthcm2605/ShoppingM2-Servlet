package com.m2m.shopping.controller.admin;

import com.m2m.shopping.Service.AccountService;
import com.m2m.shopping.Service.Impl.AccontServiceImpl;
import com.m2m.shopping.entity.Account;
import com.m2m.shopping.utils.DateUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/accounts"}, name = "AccountControllerOfAdmin")
public class AccountController extends HttpServlet {

    private static AccountService accountService;
    private static DateUtils dateUtils;

    @Override
    public void init() throws ServletException {
        super.init();
        accountService = new AccontServiceImpl();
        dateUtils = new DateUtils();
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
        accountService.delete(account);
        resp.sendRedirect("/admin/accounts?action=view");
    }

    private void doGetAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("isEdit", "false");
        Date currentDate = new Date();
        String createDate = DateUtils.dateToString("yyyy-MM-dd", currentDate);
        req.setAttribute("createDate", createDate);
        req.getRequestDispatcher("/views/admin/accounts_edit.jsp").forward(req, resp);
    }

    private void doGetEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get email and find account by email
        String email = req.getParameter("email");
        Account account = accountService.findById(email);

        // Check if the account exists
        if(account != null) {
            // Convert format date create and update
            String createDate = DateUtils.dateToString("yyyy-MM-dd", account.getCreateDate());
            String updateDate = DateUtils.dateToString("yyyy-MM-dd", account.getCreateUpdate());
            req.setAttribute("createDate", createDate);
            req.setAttribute("updateDate", updateDate);

            req.setAttribute("account", account);
            req.setAttribute("isEdit", "true");

            req.getRequestDispatcher("/views/admin/accounts_edit.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/admin/accounts?action=view");
        }
    }

    private void doPostAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account account = new Account();
        try {
            DateTimeConverter dtc = new DateConverter(new Date());
            dtc.setPattern("yyyy-mm-dd");
            ConvertUtils.register(dtc, Date.class);

            BeanUtils.populate(account, req.getParameterMap());
            accountService.save(account);
        }catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/admin/accounts?action=view");
    }

    private void doPostEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account account = new Account();
        Date date = new Date();
        System.out.println(date);
        try {
            DateTimeConverter dtc = new DateConverter(new Date());
            dtc.setPattern("yyyy-mm-dd");
            ConvertUtils.register(dtc, Date.class);

            BeanUtils.populate(account, req.getParameterMap());

            account.setCreateDate(date);
            accountService.save(account);
        }catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/admin/accounts?action=view");
    }
}
