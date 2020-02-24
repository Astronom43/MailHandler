package ru.sergshubin.spring_mail_handler.domain;

import java.util.Arrays;
import java.util.Objects;


public class Message {
    private long id;

    private String from;

    private String[] to;

    private String subject;

    private String text;

    private int priority;

    public Message(String from, String[] to, String subject, String text, int priority) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.text = text;
        this.priority = priority;
    }

    public Message() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id &&
                from.equals(message.from) &&
                Arrays.equals(to, message.to) &&
                subject.equals(message.subject) &&
                Objects.equals(text, message.text);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, from, subject, text);
        result = 31 * result + Arrays.hashCode(to);
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to=" + Arrays.toString(to) +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }


}
