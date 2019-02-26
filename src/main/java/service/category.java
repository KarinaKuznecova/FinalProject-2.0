package service;
import data.Storage;
import java.math.BigDecimal;
import static service.Worker.storage;
public enum category {

    DAIRY {
        @Override
        public Dairy createNew(String name, BigDecimal price) {
            Dairy dairy = new Dairy(name, price);
            storage.putNewProduct(dairy.getId(), dairy);
            return dairy;
        }
    },
    DRINKS {
        @Override
        public Drink createNew(String name, BigDecimal price) {
            Drink drink = new Drink(name, price);
            storage.putNewProduct(drink.getId(), drink);
            return drink;
        }
    };

    public abstract Product createNew(String name, BigDecimal price);
}