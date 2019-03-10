package service;

import java.math.BigDecimal;

class Fish extends Product {

    Fish(String name, BigDecimal price) {
        setName(name);
        setPrice(price);
        setId();
        setCategory(category.FISH);
    }
}
