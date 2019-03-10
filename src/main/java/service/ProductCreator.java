package service;

import java.math.BigDecimal;

import static service.Worker.storage;

class ProductCreator {

    void createNew(String name, BigDecimal price, category type) {
        switch (type) {
            case FRUIT:
                Fruit fruit = new Fruit(name, price);
                storage.putNewProduct(fruit.getId(), fruit);
                break;
            case VEGETABLE:
                Vegetable vegetable = new Vegetable(name, price);
                storage.putNewProduct(vegetable.getId(), vegetable);
                break;
            case DRINKS:
                Drink drink = new Drink(name, price);
                storage.putNewProduct(drink.getId(), drink);
                break;
            case DAIRY:
                Dairy dairy = new Dairy(name, price);
                storage.putNewProduct(dairy.getId(), dairy);
                break;
            case MEAT:
                Meat meat = new Meat(name, price);
                storage.putNewProduct(meat.getId(), meat);
                break;
            case FISH:
                Fish fish = new Fish(name, price);
                storage.putNewProduct(fish.getId(), fish);
                break;
            case SWEETS:
                Sweets sweets = new Sweets(name, price);
                storage.putNewProduct(sweets.getId(), sweets);
                break;
            default:
                System.out.println("Something wrong");
                break;
        }
    }
}
