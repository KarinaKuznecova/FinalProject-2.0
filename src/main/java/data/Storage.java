package data;

import service.Product;
import service.category;
import service.Worker;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    //public static Map<Long, Product> allProducts = new HashMap<Long,Product>();
    private Map<Long, Product> allProducts = new HashMap<Long,Product>();

    public void putNewProduct(Long Id, Product product){
        allProducts.put(Id, product);
    }

    public Product getById(long Id) {
        return allProducts.get(Id);
    }

    public void printAll() {
        for (Product i : allProducts.values()) {
            System.out.println(i);
        }
    }

    public void listByCategory(category type){
        for (Product i : allProducts.values()) {
            if (i.getCategory() == type){
                System.out.println(i);
            }
        }
    }

    public void setDiscountForCategory(category type, BigDecimal discount) {
        for (Product i : allProducts.values()) {
            Worker worker = new Worker();
            if (i.getCategory() == type){
                worker.setDiscountById(i.getId(), discount);
                }
            }
        }

    public void deleteById(long Id) {
        allProducts.remove(Id);
    }

    public int getStorageSize(){
        return allProducts.size();
    }

    public void removeAll() {
        allProducts.clear();
    }
}
