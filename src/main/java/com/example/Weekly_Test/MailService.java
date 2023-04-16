package com.example.Weekly_Test;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class MailService {

    private final String host = "smtp.gmail.com";
    private final String sender = "nitu8860@gmail.com"; // replace with your email address
    private final String password = " "; // replace with your email password
    private final String receiver = "knitu6238@gmail.com"; // replace with the recipient's email address

    private final Properties properties = new Properties();

    @Autowired
    public MailService() {
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
    }

    public void sendEmail(String subject, String body) throws MessagingException {
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sender));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
        message.setSubject(subject);
        message.setText(body);

        Transport.send(message);
    }
}
