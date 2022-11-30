package com.se.goBears.config.jms.listener;

import com.se.goBears.entity.Reservations;
import com.se.goBears.repository.UserRepository;
import com.se.goBears.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class OrderListener {

  @Autowired
  private MailService mailService;

  @Autowired
  private UserRepository userRepository;

  @JmsListener(destination = "yudeep.myqueue")
  public void receiveOrder(Reservations form) throws Exception {
    String message = "Your reservation status for room "+form.getRoomId() + " has changed to "+form.getStatus();
    String email = userRepository.findUserById(Long.valueOf(form.getBookedBy())).getEmail();
    mailService.sendEmail(message,email);
  }
  
}
