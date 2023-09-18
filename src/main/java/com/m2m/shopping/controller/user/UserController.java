package com.m2m.shopping.controller.user;

import com.m2m.shopping.Service.AESService;
import com.m2m.shopping.Service.AccountService;
import com.m2m.shopping.Service.EmailService;
import com.m2m.shopping.Service.Impl.AESServiceImpl;
import com.m2m.shopping.Service.Impl.AccontServiceImpl;
import com.m2m.shopping.Service.Impl.EmailServiceImpl;
import com.m2m.shopping.entity.Account;
import com.m2m.shopping.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet({"/login", "/register", "/logout", "/verify"})
public class UserController extends HttpServlet {


    private static final String secret = "mySecretKey";
    private final AccountService accountService = new AccontServiceImpl();
    private final EmailService emailService = new EmailServiceImpl();
    private final AESService cryptService = new AESServiceImpl();
    private CookieUtils cookie;

    //    doGet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        HttpSession session = req.getSession();
        switch (path) {
            case "/login":
                doGetLogin(req, resp);
                break;
            case "/register":
                doGetRegister(req, resp);
                break;
            case "/logout":
                doGetLogout(req, resp);
                break;
        }
    }

    protected void doGetLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (cookie != null) {
            req.setAttribute("email", cookie.getCookie(req, "usernameCookie"));
            req.setAttribute("password", cookie.getCookie(req, "passwordCookie"));
        }
        req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);
    }

    protected void doGetRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/user/register.jsp").forward(req, resp);
    }


    protected void doGetLogout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("current");
        resp.sendRedirect("home");
    }

    //    doPost
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String path = req.getServletPath();
        switch (path) {
            case "/login":
                doPostLogin(session, req, resp);
                break;
            case "/register":
                doPostRegister(session, req, resp);
                break;
            case "/verify":
                doPostVerify(session, req, resp);
                break;


        }
    }

    protected void doPostLogin(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("email");
        String password = req.getParameter("password"); // 123
        String remember = req.getParameter("remember");
        String encryptedPassword = cryptService.enCrypt(password, secret);
        try {
            if (checkLogin(username, password, encryptedPassword)) {
                Account account = accountService.findByUsernameAndPassword(username, encryptedPassword);
                if (Boolean.parseBoolean(remember)) {
                    cookie.setCookie(req, resp, "usernameCookie", username);
                    cookie.setCookie(req, resp, "passwordCookie", password);
                }
                session.setAttribute("current", account);
                resp.sendRedirect("home");
            }
        } catch (Exception e) {
            req.setAttribute("error", "Tai khoan hoac mat khau khong dung!");
            req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);

        }

    }

    private boolean checkLogin(String username, String password, String encryptedPassword) {
        String storedHashedPassword = accountService.findByUsernameAndPassword(username, encryptedPassword).getPassword(); //abc

        String decryptedHashedPassword = cryptService.deCrypt(storedHashedPassword, "mySecretKey"); //123

        System.out.println(decryptedHashedPassword);

        return decryptedHashedPassword.equals(password); //123 .
    }

    protected void doPostRegister(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("token");
        Account accountTemp = (Account) session.getAttribute("currentToken");
        if (code.equals(accountTemp.getToken())) {
            accountTemp.setToken(code);
            accountService.save(accountTemp);
            session.setAttribute("current", accountTemp);
            resp.sendRedirect("home");
        } else {
            req.setAttribute("message", "Mã xác thực không đúng, vui lòng kiểm tra lại");
            req.getRequestDispatcher("/views/user/register.jsp").forward(req, resp);
        }
    }

    protected void doPostVerify(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String encryptedPassword = cryptService.enCrypt(password, secret);
        String fullname = req.getParameter("fullname");
        Boolean gender = Boolean.valueOf(req.getParameter("gender"));
        Account accountTemp = new Account(email, encryptedPassword, fullname, gender);
        try {
            if (accountTemp.getEmail().equals(accountService.findByUsernameAndPassword(accountTemp.getEmail(), encryptedPassword).getEmail())) {
                req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);
                req.setAttribute("message", "Tài khoản đã tồn tại");
            }
        } catch (Exception e) {
            session.setAttribute("currentToken", accountTemp);
            emailService.sendMail(getServletContext(), accountTemp, "register");
            req.setAttribute("message", "Mã xác thực đã gửi đến mail " + accountTemp.getEmail() + " vui lòng kiểm tra");
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.setAttribute("fullname", fullname);
            req.getRequestDispatcher("/views/user/register.jsp").forward(req, resp);
        }
    }


}
