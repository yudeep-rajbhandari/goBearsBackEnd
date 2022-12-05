package com.se.goBears.controller;


import com.se.goBears.entity.AnonymousPrinciple;
import com.se.goBears.entity.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This controller class handles the request for web socket.
 */
@Controller
@CrossOrigin(origins = "*")
public class WebSocketController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private SimpUserRegistry simpUserRegistry;


    @MessageMapping("/message")
    private void receiveMyMessage(@RequestBody MyMessage message) {
        List<AnonymousPrinciple> a = simpUserRegistry.getUsers().stream().map(j -> (AnonymousPrinciple) j.getPrincipal()).filter(j -> j.getState().equals(AnonymousPrinciple.State.Online)).collect(Collectors.toList());
        for (AnonymousPrinciple p : a) {
            simpMessagingTemplate.convertAndSendToUser(p.getName(), "/topic/public", message);
        }
    }

}
