package service;

import data.Storage;

import java.math.BigDecimal;

public enum category {

    DAIRY {
        @Override
        public Dairy createNew(String name, BigDecimal price) {
            Dairy dairy = new Dairy(name, price);
            Storage.allProducts.put(dairy.getId(), dairy);
            return dairy;
        }
    },
    DRINKS {
        @Override
        public Drink createNew(String name, BigDecimal price) {
            Drink drink = new Drink(name, price);
            Storage.allProducts.put(drink.getId(), drink);
            return drink;
        }
    };

    public abstract Product createNew(String name, BigDecimal price);
}