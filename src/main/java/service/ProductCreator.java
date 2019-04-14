package service;

import java.math.BigDecimal;

class ProductCreator {

    Product createNew(String name, BigDecimal price, category type) {
        switch (type) {
            case FRUIT:
                return new Fruit(name, price);
            case VEGETABLE:
                return new Vegetable(name, price);
            case DRINKS:
                return new Drink(name, price);
            case DAIRY:
                return new Dairy(name, price);
            case MEAT:
                return new Meat(name, price);
            case FISH:
                return new Fish(name, price);
            case SWEETS:
                return new Sweets(name, price);
            default:
                System.out.println("Something wrong");
                break;
        }
        return null;
    }
}
