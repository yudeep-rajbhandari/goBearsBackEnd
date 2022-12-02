package com.se.goBears.config.jms;


import com.se.goBears.entity.Reservations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@EnableJms
public class JmsOrderMessagingService  {

  @Autowired
  private JmsTemplate jmsTemplate;


  public void sendOrder(Reservations order) {
    jmsTemplate.convertAndSend("yudeep.myqueue", order);
  }


}
