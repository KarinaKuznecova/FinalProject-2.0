package service;

import java.math.BigDecimal;

public class Vegetable extends Product{
    Vegetable(String name, BigDecimal price) {
        setName(name);
        setPrice(price);
        setId();
        setCategory(category.VEGETABLE);
    }
}
