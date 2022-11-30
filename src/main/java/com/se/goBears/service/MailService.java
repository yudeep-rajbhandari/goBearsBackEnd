package com.se.goBears.service;

import com.mailgun.api.v3.MailgunMessagesApi;
import com.mailgun.model.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class MailService {
    @Autowired
    private MailgunMessagesApi mailgunMessagesApi;
    @Value("${MAILGUN_DOMAIN}")
    private String domain;
    @GetMapping("/sendemail")
    public String sendEmail(String message,String email){
        Message message1 = Message.builder()
                .from("gobearsapp@gmail.com")
                .to("yudeep.rajbhandari@gmail.com")
                .subject("Status changed")
                .html("<html>\n" +
                        "<body>\n" +
                        "\t<p \" \">Hey</a></p>\n" +
                        message+
                        "</body>\n" +
                        "</html>")
                .build();
        return mailgunMessagesApi.sendMessage(domain, message1).toString();
    }
}
