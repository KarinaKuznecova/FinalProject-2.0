import data.Storage;
import org.junit.Test;
import service.Product;
import service.Worker;

import java.math.BigDecimal;

import static service.category.*;
import static org.junit.Assert.assertNotNull;
import static junit.framework.Assert.*;

public class ActionTest {

    Worker worker = new Worker();
    Product product = worker.createNew("Chocolate milk", BigDecimal.valueOf(100), DRINKS);

    @Test
    public void shouldCreateNew() {
        System.out.println("Test shouldCreateNew");
        assertNotNull(worker.getById(0));
    }

    @Test
    public void shouldRemove() {
        System.out.println("Test shouldRemove");
        long startingSize = Storage.allProducts.size();
        worker.createNew("Milkshake", BigDecimal.valueOf(18.20), DAIRY);
        worker.deleteById(1);
        long actualSize = Storage.allProducts.size();

        assertEquals(startingSize, actualSize);
    }

    @Test
    public void listByCategory() {
        System.out.println("Test shouldListCategory");
        worker.createNew("Apple Juice", BigDecimal.valueOf(20), DRINKS);
        worker.createNew("Extra Fresh Milk", BigDecimal.valueOf(210), DAIRY);
        worker.createNew("Water", BigDecimal.valueOf(20), DRINKS);
        worker.listByCategory(DRINKS);
    }

    @Test
    public void listAll() {
        System.out.println("Test shouldListAll");
        worker.createNew("Fresh Juice", BigDecimal.valueOf(20), DRINKS);
        worker.createNew("Cheese", BigDecimal.valueOf(210), DAIRY);
        worker.createNew("Whiskey", BigDecimal.valueOf(20), DRINKS);
        worker.listAll();
    }

    @Test
    public void shouldSetDescription() {
        System.out.println("Test shouldSetDescription");
        product.setDescription("Fresh milk from lovely cows");
        product.setDiscount(BigDecimal.valueOf(50));
        String expected = "Fresh milk from lovely cows";
        String actual = product.getDescription();
        System.out.println(product);
        assertEquals(expected, actual);
    }
}
