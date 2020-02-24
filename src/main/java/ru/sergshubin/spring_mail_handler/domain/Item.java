package ru.sergshubin.spring_mail_handler.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    private String name;

    private String description;

    private BigDecimal price;

    private int count;

    public Item(String name, String description, String pricePerCount, int count) {
        this.name = name;
        this.description = description;
        this.price = new BigDecimal(pricePerCount);
        this.count = count;
    }

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price.setScale(2, RoundingMode.HALF_UP).toString();
    }

    public void setPrice(String pricePerCount) {
        this.price = new BigDecimal(pricePerCount);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return count == item.count &&
                name.equals(item.name) &&
                Objects.equals(description, item.description) &&
                price.equals(item.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price, count);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", pricePerCount=" + price +
                ", count=" + count +
                '}';
    }
}
