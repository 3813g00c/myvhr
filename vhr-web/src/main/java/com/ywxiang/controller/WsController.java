package com.ywxiang.controller;

import com.ywxiang.entity.ChatMsg;
import com.ywxiang.entity.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import java.util.Date;

/**
 * @author ywxiang
 * @date 2020/8/3 下午8:52
 */
@Controller
public class WsController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/ws/chat")
    public void handleMsg(Authentication authentication, ChatMsg msg){
        Hr hr = (Hr) authentication.getPrincipal();
        msg.setFrom(hr.getUsername());
        msg.setFromNickname(hr.getName());
        msg.setDate(new Date());
        simpMessagingTemplate.convertAndSendToUser(msg.getTo(), "/queue/chat", msg);
    }
}
