package ru.sergshubin.spring_mail_handler.repo;

import org.springframework.stereotype.Repository;
import ru.sergshubin.spring_mail_handler.domain.Message;

@Repository
public interface IMessageRepo {
    boolean offer(Message m);
    Message pool();
    boolean isEmpty();
}
