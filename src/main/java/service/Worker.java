package service;

import data.Storage;

import java.math.BigDecimal;

public class Worker {

    public void createNew(String name, BigDecimal price, category type) {
        String typeString = type.toString();
        category.valueOf(typeString).createNew(name, price);
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

    public void setDiscountById(long Id, BigDecimal discount) {
        Storage.allProducts.get(Id).setDiscount(discount);
    }

    public void setPriceById(long Id, BigDecimal price) {
        Storage.allProducts.get(Id).setPrice(price);
    }

    public BigDecimal getPriceById(long Id) {
        return Storage.allProducts.get(Id).getPrice();
    }

    public BigDecimal getDiscountPriceById(long Id) {
        return Storage.allProducts.get(Id).getDiscountPrice();
    }

    public void setDiscountForCategory(category type, BigDecimal discount) {
        for (Product i : Storage.allProducts.values()) {
            if (i.getCategory() == type) {
                i.setDiscount(discount);
            }
        }
    }

    public void changeProductInfo(long Id, String description) {
        Product product = getById(Id);
        product.setDescription(description);
    }

    public void removeAll(){
        Storage.allProducts.clear();
        Product.resetProductsTotal();
    }

}
