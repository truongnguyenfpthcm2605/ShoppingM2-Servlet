package com.m2m.shopping.controller.user;

import com.m2m.shopping.Service.AESService;
import com.m2m.shopping.Service.AccountService;
import com.m2m.shopping.Service.EmailService;
import com.m2m.shopping.Service.Impl.AESServiceImpl;
import com.m2m.shopping.Service.Impl.AccontServiceImpl;
import com.m2m.shopping.Service.Impl.EmailServiceImpl;
import com.m2m.shopping.entity.Account;
import com.m2m.shopping.utils.CookieUtils;
import com.m2m.shopping.utils.GoogleDriveApi;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5
)
@WebServlet({"/login", "/register", "/logout", "/verify", "/edit-profile", "/forget", "/change-pass"})
public class UserController extends HttpServlet {


    private static final String SECRET_KEY = "mySecretKey";
    private static final String TEMP_USER = "currentToken";
    private static final String CURRENT_USER = "current";
    private final AccountService accountService = new AccontServiceImpl();
    private final EmailService emailService = new EmailServiceImpl();
    private final AESService cryptService = new AESServiceImpl();
    private final CookieUtils cookie = new CookieUtils();
    private GoogleDriveApi googleDriveApi;

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
            case "/edit-profile":
                doGetEdit(session, req, resp);
                break;
            case "/forget":
                doGetForget(req, resp);
                break;
            case "/change-pass":
                doGetChangePass(req, resp);
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
        session.removeAttribute(CURRENT_USER);
        resp.sendRedirect("home");
    }

    protected void doGetEdit(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account account = (Account) session.getAttribute(CURRENT_USER);
        try {
            File img = googleDriveApi.downloadImageFromFolder(account.getImg(), "account");
            req.setAttribute("img", img.getName());
        } catch (Exception e) {
            System.out.println(e);
        }
        req.getRequestDispatcher("/views/user/edit-profile.jsp").forward(req, resp);
    }

    protected void doGetForget(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/user/forget.jsp").forward(req, resp);
    }

    protected void doGetChangePass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String key = req.getParameter("key");
        if (!key.equals("")) {
            Account account = accountService.findByToken(key);
            session.setAttribute(CURRENT_USER, account);
        } else {
            Account account = (Account) session.getAttribute(CURRENT_USER);
        }
        req.getRequestDispatcher("/views/user/changepass.jsp").forward(req, resp);
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
            case "/edit-profile":
                doPostEdit(session, req, resp);
                break;
            case "/forget":
                doPostForget(req, resp);
                break;
            case "/change-pass":
                doPostChangePass(session, req, resp);
                break;


        }
    }

    protected void doPostLogin(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("email");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        String encryptedPassword = cryptService.enCrypt(password, SECRET_KEY);
        try {
            if (checkLogin(username, password, encryptedPassword)) {
                Account account = accountService.findByUsernameAndPassword(username, encryptedPassword);
                if (Boolean.parseBoolean(remember)) {
                    cookie.setCookie(req, resp, "usernameCookie", username);
                    cookie.setCookie(req, resp, "passwordCookie", password);
                }
                session.setAttribute(CURRENT_USER, account);
                resp.sendRedirect("home");
            }
        } catch (Exception e) {
            req.setAttribute("error", "Tai khoan hoac mat khau khong dung!");
            req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);
        }

    }

    private boolean checkLogin(String username, String password, String encryptedPassword) {
        String storedHashedPassword = accountService.findByUsernameAndPassword(username, encryptedPassword).getPassword(); //abc

        String decryptedHashedPassword = cryptService.deCrypt(storedHashedPassword, SECRET_KEY); //123

        return decryptedHashedPassword.equals(password); //123 .
    }

    protected void doPostRegister(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("token");
        Account accountTemp = (Account) session.getAttribute(TEMP_USER);
        if (code.equals(accountTemp.getToken())) {
            accountTemp.setToken(code);
            accountService.save(accountTemp);
            session.setAttribute(CURRENT_USER, accountTemp);
            resp.sendRedirect("home");
        } else {
            req.setAttribute("message", "Mã xác thực không đúng, vui lòng kiểm tra lại");
            req.getRequestDispatcher("/views/user/register.jsp").forward(req, resp);
        }
    }

    protected void doPostVerify(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String encryptedPassword = cryptService.enCrypt(password, SECRET_KEY);
        String fullname = req.getParameter("fullname");
        Boolean gender = Boolean.valueOf(req.getParameter("gender"));
        Account accountTemp = new Account(email, encryptedPassword, fullname, gender);
        Account account = accountService.findByUsernameAndPassword(accountTemp.getEmail(), encryptedPassword);
        if (account != null && accountTemp.getEmail().equals(account.getEmail())) {
            req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);
            req.setAttribute("message", "Tài khoản đã tồn tại");
        } else {
            session.setAttribute(TEMP_USER, accountTemp);
            emailService.sendMail(getServletContext(), accountTemp, "register");
            req.setAttribute("message", "Mã xác thực đã gửi đến mail " + accountTemp.getEmail() + " vui lòng kiểm tra");
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.setAttribute("fullname", fullname);
            req.getRequestDispatcher("/views/user/register.jsp").forward(req, resp);
        }
    }

    protected void doPostEdit(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();

        Account account = (Account) session.getAttribute(CURRENT_USER);
        account.setFullname(req.getParameter("fullname"));
        account.setAddress(req.getParameter("address"));
        account.setPhoneNumbers(req.getParameter("phoneNumbers"));
        account.setGender(Boolean.parseBoolean(req.getParameter("gender")));

        String webappPath = context.getRealPath("/");
        String imgPath = webappPath + "templates/user/img/account/";

        Part imgPart = req.getPart("img");
        String imgFileName = imgPart.getSubmittedFileName();
        File dir = new File(imgPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File photoFile = new File(dir, imgPart.getSubmittedFileName());
        imgPart.write(photoFile.getAbsolutePath());
        System.out.println(photoFile.getAbsolutePath());
        try {
            account.setImg(imgFileName);
            googleDriveApi.uploadImageToFolder(photoFile, imgFileName, "account");
        } catch (Exception e) {
            System.out.println("Không có thay đổi");
        }
        accountService.save(account);
        session.setAttribute(CURRENT_USER, account);
        req.setAttribute("message", "Cập nhật thành công!");
        req.getRequestDispatcher("/views/user/edit-profile.jsp").forward(req, resp);
    }

    protected void doPostForget(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        Account account = accountService.findByEmail(email);
        if (account != null && email.equals(account.getEmail())) {
            emailService.sendMail(getServletContext(), account, "forget");
            req.setAttribute("message", "Mã xác thực đã gửi đến mail " + account.getEmail() + " vui lòng kiểm tra");
            accountService.save(account);
            req.getRequestDispatcher("/views/user/forget-verify.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "Tài khoản không tồn tại!");
            req.getRequestDispatcher("/views/user/forget.jsp").forward(req, resp);
        }
    }

    protected void doPostChangePass(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String verifyPass = req.getParameter("verify-password");
        String encryptedPassword = cryptService.enCrypt(password, SECRET_KEY);
        String verifyEncryptedPassword = cryptService.enCrypt(verifyPass, SECRET_KEY);
        Account account = (Account) session.getAttribute(CURRENT_USER);
        if (account != null) {
            if (encryptedPassword.equals(verifyEncryptedPassword)) {
                account.setPassword(encryptedPassword);
                req.setAttribute("message", "Đổi mật khẩu thành công!");
                req.getRequestDispatcher("/views/user/changepass.jsp").forward(req, resp);
            } else {
                req.setAttribute("message", "Mật khẩu & mật khẩu xác nhận không đúng!");
                req.getRequestDispatcher("/views/user/changepass.jsp").forward(req, resp);
            }
        }

    }


}
