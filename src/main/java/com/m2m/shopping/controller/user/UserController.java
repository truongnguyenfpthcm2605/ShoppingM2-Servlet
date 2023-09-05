package com.m2m.shopping.controller.user;

import com.m2m.shopping.dao.AccountDAO;
import com.m2m.shopping.dao.impl.AccountDAOImpl;
import com.m2m.shopping.entity.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet({"/login","/register","/logout"})
public class UserController extends HttpServlet {

    AccountDAO dao = new AccountDAOImpl();

//    doGet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        HttpSession session = req.getSession();
        switch(path){
            case "/login":
                doGetLogin(req, resp);
                break;
            case "/register":
                doGetRegister(req, resp);
                break;
            case "/logout":
                doGetLogout(session,req, resp);
                break;
        }
    }

    protected void doGetLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);
    }

    protected void doGetRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/user/register.jsp").forward(req, resp);
    }


    protected void doGetLogout(HttpSession session,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session.removeAttribute("current");
        resp.sendRedirect("home");
    }

    //    doPost
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String path = req.getServletPath();
        switch(path){
            case "/login":
                doPostLogin(session,req, resp);
                break;

        }
    }

    protected void doPostLogin(HttpSession session,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("email");
        String password = req.getParameter("password");
        System.out.println(username+" - "+password);
        try {
            Account account = dao.findByUsernameAndPassword(username, password);
            if(account != null){
                session.setAttribute("current", account);
                resp.sendRedirect("home");
            }
        }catch(Exception e){
            resp.sendRedirect("login");
            req.setAttribute("error", "Tai khoan hoac mat khau khong dung!");
        }
    }

}
