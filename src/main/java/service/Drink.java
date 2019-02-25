package service;

import java.math.BigDecimal;

public class Drink extends Product {


    Drink(String name, BigDecimal price) {
        setName(name);
        setPrice(price);
        setId();
        setCategory(category.DRINKS);
    }
}
