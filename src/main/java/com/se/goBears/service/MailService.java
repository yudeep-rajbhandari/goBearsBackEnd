package com.se.goBears.service;

import com.mailgun.api.v3.MailgunMessagesApi;
import com.mailgun.model.message.Message;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Service
public class MailService {
//    @Autowired
//    private MailgunMessagesApi mailgunMessagesApi;
    @Value("${SENDGRID_API}")
    private String domain;
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

    public void sendEmail1(String message,String email) throws IOException {
//        Email from = new Email("gobearsapp@gmail.com");
//        String subject = "Status changed";
//        Email to = new Email("yudeep.rajbhandari@gmail.com");
//        Content content = new Content("html", "<html>\n" +
//                "<body>\n" +
//                "\t<p \" \">Hey</a></p>\n" +
//                message+
//                "</body>\n" +
//                "</html>");
//        Mail mail = new Mail(from, subject, to, content);
//
//        SendGrid sg = new SendGrid("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");
//        Request request = new Request();
//        try {
//            request.setMethod(Method.POST);
//            request.setEndpoint("mail/send");
//            request.setBody(mail.build());
//            Response response = sg.api(request);
//            return response.toString();
//
//        } catch (IOException ex) {
//            System.out.println("error");
//        }
//       return null;
        Email from = new Email("gobearsapp@gmail.com");
        String subject = "Status changed";
        Email to = new Email("bhagatpranish@gmail.com");
        Content content = new Content("text/html", "<html>\n" +
                "<body>\n" +
                "\t<p \" \">Hey</a></p>\n" +
                message+
                "</body>\n" +
                "</html>");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(domain);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }

}
