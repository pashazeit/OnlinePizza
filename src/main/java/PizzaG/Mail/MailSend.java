package PizzaG.Mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Zeit on 05.01.2017.
 * 13:16
 */

public class MailSend extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String NameMail = request.getParameter("your-name");
        String NumberMail = request.getParameter("your-number");
        String MessageMail = request.getParameter("your-message");

        Po4ta(NameMail, NumberMail, MessageMail);
        response.sendRedirect("PizzaTest");
    }


    private static void Po4ta(String nameMail, String NumberMail, String MessageMail) {
        System.out.println("asdasdasd");

        String to = "teachmeskill@mail.ru";
        String from = "teachmeskill@mail.ru";
        String host = "smtp.mail.ru";
        final String username = "teachmeskill";
        final String password = "wadtlp123";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        username, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Новое сообщение с сайта.");
            message.setText("Пользователь: " + nameMail
                    + "\r\n Отправил следующее сообщение: " + MessageMail
                    + "\r\n Номер телефона для связи: " + NumberMail);
            Transport.send(message);

            System.out.println("Отправлено");
        } catch (MessagingException mex) {
            System.out.println("Ошибка отправки");
        }
    }
}


