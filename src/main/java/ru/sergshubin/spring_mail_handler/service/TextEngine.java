package ru.sergshubin.spring_mail_handler.service;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.springframework.stereotype.Service;
import ru.sergshubin.spring_mail_handler.domain.Order;

import java.io.StringWriter;
import java.util.HashMap;

@Service
public class TextEngine {

    public String getText(Order order) {

        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("text.mustache");
        StringWriter writer = new StringWriter();

        HashMap<String, Object> scope = new HashMap<>();
        scope.put("nameBuyer", order.getBuyer().getfName() + " " + order.getBuyer().getlName());
        scope.put("items",order.getItems());
        scope.put("totalPrice",order.getTotalPrice().toString());


        mustache.execute(writer, scope);

        return writer.toString();
    }
}
