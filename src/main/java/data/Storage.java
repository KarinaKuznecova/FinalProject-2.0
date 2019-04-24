package data;

import service.Product;
import service.category;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<Long, Product> allProducts = new HashMap<Long, Product>();

    public void putNewProduct(Long id, Product product) {
        allProducts.put(id, product);
    }

    public Product getById(long id) throws ProductNotFoundException {
        if (!allProducts.containsKey(id)) {
            throw new ProductNotFoundException("Product with id: " + id + " not found");
        }
        return allProducts.get(id);

    }

    public void printAll() {
        for (Product i : allProducts.values()) {
            System.out.println(i);
        }
    }

    public void listByCategory(category type) {
        for (Product i : allProducts.values()) {
            if (i.getCategory() == type) {
                System.out.println(i);
            }
        }
    }

    public void deleteById(long id) throws ProductNotFoundException {
        if (!allProducts.containsKey(id)) {
            throw new ProductNotFoundException("Product with id: " + id + " not found");
        }
        allProducts.remove(id);
    }

    public int getStorageSize() {
        return allProducts.size();
    }

    public void removeAll() {
        allProducts.clear();
    }
}