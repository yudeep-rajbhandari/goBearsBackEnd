package com.se.goBears.config;

import com.mailgun.api.v3.MailgunMessagesApi;
import com.mailgun.client.MailgunClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailGunConfig {

    @Bean
    public MailgunMessagesApi mailgunMessagesApi() {
        return MailgunClient.config("1f64dcfd57fd8eb386b125032b4d51b0-f2340574-92cd3647")
                .createApi(MailgunMessagesApi.class);
    }
}
