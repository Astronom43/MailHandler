package ru.sergshubin.spring_mail_handler.repo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sergshubin.spring_mail_handler.domain.Message;

@FeignClient(url = "http://localhost:8080")
public interface IMailSend {

    @RequestMapping(method = RequestMethod.POST, path = "/message", consumes = "application/json")
    Message PutMessage(Message message);
}
