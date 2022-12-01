package com.se.goBears.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {
//    @Autowired
//    private MailgunMessagesApi mailgunMessagesApi;
@Autowired
private JavaMailSender emailSender;
//    public String sendEmail(String message,String email){
//        Message message1 = Message.builder()
//                .from("gobearsapp@gmail.com")
//                .to("yudeep.rajbhandari@gmail.com")
//                .subject("Status changed")
//                .html("<html>\n" +
//                        "<body>\n" +
//                        "\t<p \" \">Hey</a></p>\n" +
//                        message+
//                        "</body>\n" +
//                        "</html>")
//                .build();
//        return mailgunMessagesApi.sendMessage(domain, message1).toString();
//    }

    public void sendEmail1(String message1,String email) throws  MessagingException {

        SimpleMailMessage message = new SimpleMailMessage();
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg = "<html>\n" +
                "<body>\n" +
                "\t<p \" \">Hey</a></p>\n" +
                message1+
                "</body>\n" +
                "</html>";
        helper.setText(htmlMsg, true); // Use this or above line.
        helper.setTo("bhagatpranish@gmail.com");
        helper.setSubject("Status change");
        helper.setFrom("gobearsapp@gmail.com");
        emailSender.send(mimeMessage);
    }



}
