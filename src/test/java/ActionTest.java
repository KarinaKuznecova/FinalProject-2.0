import data.ProductNotFoundException;
import data.Storage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.Worker;

import java.math.BigDecimal;

import static service.category.*;
import static org.junit.Assert.*;

public class ActionTest {
    private Worker worker;

    @Before
    public void before() {
        worker = new Worker(new Storage());
        worker.createNew("Milk", BigDecimal.valueOf(20), DRINKS);
    }

    @After
    public void after(){
        worker.removeAll();
    }

    @Test
    public void shouldCreateNew() {
        long startingSize = worker.getStorageSize() + 1;
        worker.createNew("Apple", BigDecimal.valueOf(100), FRUIT);
        long actualSize = worker.getStorageSize();
        assertEquals(startingSize, actualSize);
    }

    @Test
    public void shouldRemove() {
        long startingSize = worker.getStorageSize();
        worker.createNew("Milkshake", BigDecimal.valueOf(18.20), DAIRY);
        worker.deleteById(1);
        long actualSize = worker.getStorageSize();
        assertEquals(startingSize, actualSize);
    }

    @Test
    public void listByCategory() {
        System.out.println("Test shouldListCategory");
        worker.createNew("Apple Juice", BigDecimal.valueOf(20), DRINKS);
        worker.createNew("Extra Fresh Milk", BigDecimal.valueOf(210), DAIRY);
        worker.createNew("Candy", BigDecimal.valueOf(20), SWEETS);
        worker.listByCategory(DRINKS);
    }

    @Test
    public void listAll() {
        System.out.println("Test shouldListAll");
        worker.createNew("Salmon", BigDecimal.valueOf(20), FISH);
        worker.createNew("Chicken", BigDecimal.valueOf(210), MEAT);
        worker.createNew("Cucumber", BigDecimal.valueOf(20), VEGETABLE);
        worker.listAll();
    }

    @Test
    public void shouldSetDescription() {
        worker.changeProductDescription(0, "Description set by worker");
        System.out.println(worker.getById(0));

        assertNotNull(worker.getById(0).getDescription());
    }

    @Test
    public void shouldChangeName(){
        worker.changeName(0, "Not Milk");
        assertEquals("Not Milk", worker.getNameById(0));
    }

    @Test
    public void shouldClearAll() {
        int expected = 0;
        worker.removeAll();
        int actual = worker.getStorageSize();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldBeNotFound(){
        assertNull(worker.getById(9999999));
    }
}