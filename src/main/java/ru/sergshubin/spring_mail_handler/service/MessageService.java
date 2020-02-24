package ru.sergshubin.spring_mail_handler.service;

import org.springframework.stereotype.Service;
import ru.sergshubin.spring_mail_handler.domain.Message;
import ru.sergshubin.spring_mail_handler.repo.IMessageRepo;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

@Service

public class MessageService implements IMessageRepo {


    private final Queue<Message> queue = new PriorityQueue<Message>(16, Comparator.comparingInt(Message::getPriority));

    @Override
    public boolean offer(Message m) {
        return queue.offer(m);
    }

    @Override
    public Message pool() {
        return queue.poll();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }


}
