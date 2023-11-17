
package controller;

import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailSMTP {
    String numberOTP;

    public String getNumberOTP() {
        return numberOTP;
    }

    public void setNumberOTP(String numberOTP) {
        this.numberOTP = numberOTP;
    }
    
    public int generateRandomOTP() {
        Random random = new Random();
        // Tạo một số ngẫu nhiên từ 100000 đến 999999 (gồm 6 chữ số)
        int min = 100000;
        int max = 999999;
        int randomNumber = random.nextInt(max - min + 1) + min;
        setNumberOTP(randomNumber+"");
        return randomNumber;
    }

    public void sendOTP(String emailTo) {
        String otp = generateRandomOTP()+"";
        String username = "endless.shoeshop@gmail.com";
        String password = "uawv lhuq ixuk iipy";
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
            message.setSubject("Yêu cầu thay đổi mật khẩu");
            message.setText("Xin chào !\n"
                    + "\n"
                    + "Ai đó đã yêu cầu đặt lại mật khẩu cho tài khoản của bạn, nếu đây không phải là bạn, vui lòng bỏ qua email này.\n"
                    + "\n"
                    + "Sử dụng mã kích hoạt này để khôi phục mật khẩu của bạn: " + otp);
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
