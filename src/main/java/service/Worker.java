package service;

import data.ProductNotFoundException;
import data.Storage;

import java.math.BigDecimal;

public class Worker {
    private Storage storage;

    public Worker(Storage storage) {
        this.storage = storage;
    }

    public void createNew(String name, BigDecimal price, category type) {
        ProductCreator creator = new ProductCreator();
        Product product = creator.createNew(name, price, type);
        storage.putNewProduct(product.getId(), product);
    }

    public Product getById(long id) {
        try {
            return storage.getById(id);
        } catch (ProductNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void listAll() {
        storage.printAll();
    }

    public void deleteById(long id) {
        try {
            storage.deleteById(id);
        } catch (ProductNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void listByCategory(category type) {
        storage.listByCategory(type);
    }

    public void setDiscountById(long id, BigDecimal discount) {
        storage.getById(id).setDiscount(discount);
    }

    public void setPriceById(long id, BigDecimal price) {
        storage.getById(id).setPrice(price);
    }

    public BigDecimal getPriceById(long id) {
        return storage.getById(id).getPrice();
    }

    public BigDecimal getDiscountPriceById(long id) {
        return storage.getById(id).getDiscountPrice();
    }

    public void setDiscountForCategory(category type, BigDecimal discount) {
        for (int i = 0; i < Product.productsTotal; i++) {
            if (storage.getById(i) != null && storage.getById(i).getCategory() == type) {
                setDiscountById(i, discount);
            }
        }
    }

    public void changeProductDescription(long id, String description) {
        Product product = getById(id);
        product.setDescription(description);
    }

    public void changeName(long id, String name) {
        storage.getById(id).setName(name);
    }

    public void removeAll() {
        storage.removeAll();
        Product.resetProductsTotal();
    }

    public int getStorageSize() {
        return storage.getStorageSize();
    }

    private void updateProductsTotal() {
        Product.productsTotal = (long) getStorageSize();
    }

    public void saveAll() {
        storage.saveAll();
    }

    public void loadAll() {
        storage.loadAll();
        updateProductsTotal();
    }
}