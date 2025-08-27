package service;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.security.SecureRandom;
import java.util.Properties;

public class SendOTPService {

    // Generate 4-digit OTP
    public String generateOTP() {
        SecureRandom random = new SecureRandom();
        int otp = 1000 + random.nextInt(9000); // Ensures always 4 digits
        return String.valueOf(otp);
    }

    // Send OTP email
    public void sendOTP(String toEmail, String otp) {
        final String fromEmail = "raghavendralamani7@gmail.com";   // Your Gmail
        final String password = "tjzk xdhx gxls dljr";             // App password (NOT Gmail password)

        // Gmail SMTP settings
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Authenticate sender
        Session session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fromEmail, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail, "Raghavendra OTP Service")); // <-- optional display name
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Your OTP Code");
            message.setText("Dear User,\n\nYour 4-digit OTP is: " + otp +
                    "\n\nThis OTP is valid for 5 minutes.\n\nRegards,\nTeam");

            Transport.send(message);

            System.out.println("✅ OTP sent successfully to " + toEmail);

        } catch (Exception e) {
            System.out.println("❌ Error sending OTP: " + e.getMessage());
            e.printStackTrace();
        }
    }
}