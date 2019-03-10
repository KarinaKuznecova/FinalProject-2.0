package service;

import java.math.BigDecimal;

class Fruit extends Product {

    Fruit(String name, BigDecimal price) {
        setName(name);
        setPrice(price);
        setId();
        setCategory(category.FRUIT);
    }
}
