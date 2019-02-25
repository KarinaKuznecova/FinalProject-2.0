package service;

import java.math.BigDecimal;

public class Dairy extends Product {

    Dairy(String name, BigDecimal price) {
        setName(name);
        setPrice(price);
        setId();
        setCategory(category.DAIRY);
    }
}
