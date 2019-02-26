package service;

import data.Storage;

import java.math.BigDecimal;

public class Worker {
    static Storage storage = new Storage();

    public void createNew(String name, BigDecimal price, category type) {
        String typeString = type.toString();
        category.valueOf(typeString).createNew(name, price);
    }

    public Product getById(long Id) {
        return storage.getById(Id);
    }

    public void listAll() {
        storage.printAll();
    }

    public void deleteById(long Id) {
        storage.deleteById(Id);
    }

    public void listByCategory(category type) {
        storage.listByCategory(type);
    }

    public void setDiscountById(long Id, BigDecimal discount) {
        storage.getById(Id).setDiscount(discount);
    }

    public void setPriceById(long Id, BigDecimal price) {
        storage.getById(Id).setPrice(price);
    }

    public BigDecimal getPriceById(long Id) {
        return storage.getById(Id).getPrice();
    }

    public BigDecimal getDiscountPriceById(long Id) {
        return storage.getById(Id).getDiscountPrice();
    }

    public void setDiscountForCategory(category type, BigDecimal discount) {
        storage.setDiscountForCategory(type,discount);
    }

    public void changeProductInfo(long Id, String description) {
        Product product = getById(Id);
        product.setDescription(description);
    }

    public void removeAll() {
        storage.removeAll();
        Product.resetProductsTotal();
    }

    public int getStorageSize(){
        return storage.getStorageSize();
    }
}
