package data;

import service.Product;
import service.category;

import java.io.*;
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

    public void saveAll() {
        try {
            FileOutputStream fos = new FileOutputStream("productData.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(allProducts);

            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println("Data saved");
    }

    public void loadAll() {
        try {
            FileInputStream fis = new FileInputStream("productData.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            allProducts = (HashMap) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Data updated");
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
    }
}