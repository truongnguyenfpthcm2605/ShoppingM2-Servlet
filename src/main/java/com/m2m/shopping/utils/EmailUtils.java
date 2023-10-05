package com.m2m.shopping.utils;


import com.m2m.shopping.entity.Account;
import jakarta.mail.*;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeUtility;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class EmailUtils {
    public String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }


        public static void sendEmail (String host, String port,
        final String userName, final String password, String toAddress,
                String subject, String message) throws AddressException,
                MessagingException, UnsupportedEncodingException {

            // sets SMTP server properties
            Properties properties = new Properties();
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port", port);
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            // creates a new session with an authenticator
            Authenticator auth = new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName, password);
                }
            };

            Session session = Session.getInstance(properties, auth);

            // creates a new e-mail message
            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(userName));
            InternetAddress[] toAddresses = {new InternetAddress(toAddress)};
            msg.setRecipients(Message.RecipientType.TO, toAddresses);
            msg.setSubject(MimeUtility.encodeText(subject,
                    "utf-8",
                    "B"));
            msg.setSentDate(new Date());
            msg.setContent(message,"text/html; charset=UTF-8");

            // sends the e-mail
            Transport.send(msg);


    }
}
