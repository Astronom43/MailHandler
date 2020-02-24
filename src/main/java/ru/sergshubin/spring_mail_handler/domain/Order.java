package ru.sergshubin.spring_mail_handler.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    private long id;
    private User buyer;
    private Item[] items;
    private BigDecimal totalPrice;

    public Order(long id, User buyer, Item[] items) {
        this.id = id;
        this.buyer = buyer;
        this.items = items;
        calckTotalPrice();
    }

    private void calckTotalPrice() {
        totalPrice = new BigDecimal("0.00");
        for (Item i:items) {
            BigDecimal localPrice = new BigDecimal(i.getPrice());
            localPrice = localPrice.multiply(new BigDecimal(String.valueOf(i.getCount())));
            totalPrice = totalPrice.add(localPrice);
        }
    }

    public Order() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
        calckTotalPrice();
    }

    public String getTotalPrice() {
        return totalPrice.setScale(2, RoundingMode.HALF_UP).toString();
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = new BigDecimal(totalPrice);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", buyer=" + buyer +
                ", items=" + Arrays.toString(items) +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
