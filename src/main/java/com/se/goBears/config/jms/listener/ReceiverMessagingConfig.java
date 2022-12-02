package com.se.goBears.config.jms.listener;

import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.support.converter.MessageConverter;


@Configuration
public class ReceiverMessagingConfig {

  @Autowired
  private MessageConverter messageConverter;

  @Bean
  public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {

    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setConnectionFactory(new PooledConnectionFactory("tcp://localhost:61617"));
    factory.setMessageConverter(messageConverter);
    return factory;
  }

  
}
