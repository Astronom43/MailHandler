package ru.sergshubin.spring_mail_handler.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergshubin.spring_mail_handler.domain.Message;
import ru.sergshubin.spring_mail_handler.repo.IMailSend;
import ru.sergshubin.spring_mail_handler.service.MessageService;

import javax.annotation.Resource;

@RestController
public class MessageSender {

    @Resource(name = "IMailSend")
    IMailSend mailSend;

    @Resource(name = "messageService")
    MessageService service;

    @Scheduled(initialDelay = 1000, fixedDelay = 3000)
    void scheduler(){
        if(!service.isEmpty()){
            send(service.pool());
        }
    }


    @PostMapping("/message")
    private void send(Message pool) {
        mailSend.PutMessage(pool);
    }
}
