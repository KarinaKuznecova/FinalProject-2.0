import data.Storage;
import org.junit.Test;
import service.Drink;
import service.Worker;

import java.math.BigDecimal;

import static service.category.*;
import static org.junit.Assert.assertNotNull;
import static junit.framework.Assert.*;

public class ActionTest {

    @Test
    public void shouldCreateNew() {
        System.out.println("Test shouldCreateNew");
        Worker worker = new Worker();
        worker.createNew("Whiskey Jameson", BigDecimal.valueOf(20), DRINKS);
        worker.getById(0);

        assertNotNull(worker.getById(0));
    }

    @Test
    public void shouldRemove() {
        System.out.println("Test shouldRemove");
        Worker worker = new Worker();
        worker.createNew("Grape Juice", BigDecimal.valueOf(20), DRINKS);
        worker.createNew("Milkshake", BigDecimal.valueOf(210), DAIRY);
        long startingSize = Storage.allProducts.size();
        long IdToRemove = worker.createNew("Whiskey Jack Daniels", BigDecimal.valueOf(20), DRINKS).getId();
        worker.deleteById(IdToRemove);
        long actualSize = Storage.allProducts.size();

        assertEquals(startingSize, actualSize);
    }

    @Test
    public void listByCategory() {
        System.out.println("Test shouldListCategory");
        Worker worker = new Worker();
        worker.createNew("Juice", BigDecimal.valueOf(20), DRINKS);
        worker.createNew("Milk", BigDecimal.valueOf(210), DAIRY);
        worker.createNew("Whiskey", BigDecimal.valueOf(20), DRINKS);
        worker.listByCategory(DRINKS);
    }

    @Test
    public void listAll() {
        System.out.println("Test shouldListAll");
        Worker worker = new Worker();
        worker.createNew("Beer", BigDecimal.valueOf(20), DRINKS);
        worker.createNew("Cheese", BigDecimal.valueOf(210), DAIRY);
        worker.createNew("Cola", BigDecimal.valueOf(20), DRINKS);
        worker.listAll();
    }
}
