package service;

import data.Storage;

import java.math.BigDecimal;

public class Worker {

    public Product createNew(String name, BigDecimal price, category type) {
        String typeString = type.toString();
        return category.valueOf(typeString).createNew(name, price);
    }

    public Product getById(long Id) {
        System.out.println(Storage.allProducts.get(Id));
        return Storage.allProducts.get(Id);
    }

    public void listAll() {
        for (Product i : Storage.allProducts.values()) {
            System.out.println(i);
        }
    }

    public void deleteById(long Id) {
        Storage.allProducts.remove(Id);
    }

    public void listByCategory(category type) {
        for (Product i : Storage.allProducts.values()) {
            if (i.getCategory() == type) {
                System.out.println(i);
            }
        }
    }

    public void setDiscountForCategory(category type, BigDecimal discount){
        for (Product i : Storage.allProducts.values()) {
            if (i.getCategory() == type) {
                i.setDiscount(discount);
            }
        }
    }

}
