package ru.sergshubin.spring_mail_handler.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.sergshubin.spring_mail_handler.domain.Message;
import ru.sergshubin.spring_mail_handler.domain.Order;
import ru.sergshubin.spring_mail_handler.repo.IMessageRepo;
import ru.sergshubin.spring_mail_handler.service.TextEngine;

import javax.annotation.Resource;

@RestController
@PropertySource("classpath:message.yml")
public class OrderController {

    @Value("${from}")
    private String from;
    @Resource(name = "messageService")
    IMessageRepo repo;
    @Resource(name = "textEngine")
    TextEngine textEngine;

    @PostMapping(value = "/order")
    public void putMessage(@RequestBody Order order){
        Message message = new Message();
        message.setFrom(from);
        message.setTo(new String[]{order.getBuyer().getEmail()});
        message.setSubject("Order #"+order.getId());
        message.setPriority(0);
        message.setText(textEngine.getText(order));
        repo.offer(message);
    }


}
