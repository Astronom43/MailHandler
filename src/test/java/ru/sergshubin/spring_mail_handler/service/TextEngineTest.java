package ru.sergshubin.spring_mail_handler.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import ru.sergshubin.spring_mail_handler.domain.Item;
import ru.sergshubin.spring_mail_handler.domain.Order;
import ru.sergshubin.spring_mail_handler.domain.User;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TextEngineTest {

    Order order;



    @Autowired
    TextEngine engine;
    @Value("classpath:test.txt")
    Resource resource;

    @BeforeEach
    void init() throws IOException {
        order = new Order();
        User user = new User();
        user.setfName("a");
        user.setlName("b");
        Item i1 = new Item("name1","descr1","100.00",2);
        Item i2 = new Item("name2","descr2","200.00",3);
        Item i3 = new Item("name3","descr3","300.00",2);
        Item[] items = {i1,i2,i3};
        order.setItems(items);
        order.setBuyer(user);
        //order.setTotalPrice(new BigDecimal("1000.10"));
    }

    @Test
    void getText() throws IOException {
        StringBuilder builder = new StringBuilder();
        try(FileReader fileReader = new FileReader(resource.getFile())) {
            int c;
            while ((c=fileReader.read())!=-1){
                builder.append((char)c);
            }
        }
        assertEquals(builder.toString(),engine.getText(order));
    }
}