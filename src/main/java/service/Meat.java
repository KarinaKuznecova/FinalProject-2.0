package service;

import java.math.BigDecimal;

public class Meat extends Product {
    Meat(String name, BigDecimal price) {
        setName(name);
        setPrice(price);
        setId();
        setCategory(category.MEAT);
    }
}
