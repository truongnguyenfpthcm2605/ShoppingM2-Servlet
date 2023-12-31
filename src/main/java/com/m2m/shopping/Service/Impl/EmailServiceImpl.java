package com.m2m.shopping.Service.Impl;

import com.m2m.shopping.Service.EmailService;
import com.m2m.shopping.entity.Account;
import com.m2m.shopping.utils.EmailUtils;

import javax.servlet.ServletContext;

public class EmailServiceImpl implements EmailService {

    @Override
    public void sendMail(ServletContext context, Account recipient, String type) {
        String host = context.getInitParameter("host");
        String port = context.getInitParameter("port");
        String user = context.getInitParameter("user");
        String pass = context.getInitParameter("pass");
        String token = String.valueOf((int) (Math.random() * ((9999 - 1000) + 1)) + 1000);
        recipient.setToken(token);

        try {
            String content = null;
            String subject = null;
            switch (type) {
                case "register":
                    content = "<html><head>"
                            + "<style>"
                            + "div {text-align:center}"
                            + "b { font-size: 1rem; color: #187577; }"
                            + "</style>" +
                            "</head><body>"
                            + "<div>"
                            + "<h1>HTMOBILE</h1>"
                            + "<p>Dùng mã này để xác minh địa chỉ email của bạn:</p>"
                            + "<p>Xin chào, chúng tôi cần xác minh địa chỉ email của bạn để đảm bảo có thể liên hệ với bạn sau khi xem xét ID "
                            + recipient.getEmail() + "</p>"
                            + "<p>Mã xác minh: <b>" + recipient.getToken() + "</b></p>"
                            + "<p>Tin nhắn này được gửi tới bạn theo yêu cầu HTMobile.</p></div>"
                            + "</body></html>";
                    subject = "MÃ XÁC NHẬN TỪ HT MOBILE";
                    break;
                case "forget":
                    content = "<html><head>"
                            + "<style>"
                            + "div {text-align:center}"
                            + "b { font-size: 1rem; color: #187577; }"
                            + "a { font-size: 1rem; color: white !important; padding:15px; background-color:blue;border-radius: 8px;text-align:center; text-decoration:none ;border:1px solid black}"
                            + "a:hover{ font-size: 1rem;padding:15px;border-radius: 8px;text-align:center; text-decoration:none;opacity:.8}"
                            + "</style>" +
                            "</head><body>"
                            + "<div>"
                            + "<h1>HTMOBILE</h1>"
                            + "<p>Dùng mã này để xác minh mật khảu mới của bạn:</p>"
                            + "<p>Xin chào, chúng tôi cần xác minh địa chỉ email của bạn để đảm bảo có thể thay đổi mật khẩu của bạn. Nếu đây là bạn hãy nhấp vào link bên dưới để xác minh."
                            + "</p>"
                            + "<p>Mã xác minh: <a href='http://localhost:8080/Shopping_war/change-pass?key=" + recipient.getToken() + "'>Nhấp vào đây</a></p>"
                            + "<p>Tin nhắn này được gửi tới bạn theo yêu cầu HTMobile.</p></div>"
                            + "</body></html>";
                    subject = "MÃ XÁC NHẬN TỪ HT MOBILE";
                    break;
                default:
                    subject = "HTMOBILE";
                    content = "Có sự nhầm lẫn khi bạn nhận được mail này, vui lòng thông cảm";
            }
            EmailUtils.sendEmail(host, port, user, pass, recipient.getEmail(), subject, content);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
