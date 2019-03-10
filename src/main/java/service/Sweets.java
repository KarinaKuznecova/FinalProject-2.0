package service;

import java.math.BigDecimal;

class Sweets extends Product {
    Sweets(String name, BigDecimal price) {
        setName(name);
        setPrice(price);
        setId();
        setCategory(category.SWEETS);
    }
}
