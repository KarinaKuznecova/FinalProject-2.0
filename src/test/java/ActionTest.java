import data.Storage;
import org.junit.BeforeClass;
import org.junit.Test;
import service.Worker;

import java.math.BigDecimal;

import static service.category.*;
import static org.junit.Assert.assertNotNull;
import static junit.framework.Assert.*;

public class ActionTest {

    Worker worker = new Worker();

    @BeforeClass
    public static void before() {
        ActionTest tester = new ActionTest();
        tester.before2();
    }

    void before2() {
        worker.createNew("First milk", BigDecimal.valueOf(100), DRINKS);
    }

    @Test
    public void shouldCreateNew() {
        System.out.println("Test shouldCreateNew");
        long startingSize = worker.getStorageSize()+1;
        worker.createNew("First milk", BigDecimal.valueOf(100), DRINKS);
        long actualSize = worker.getStorageSize();
        assertEquals(startingSize, actualSize);
    }

    @Test
    public void shouldRemove() {
        System.out.println("Test shouldRemove");
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
        worker.changeProductInfo(0, "Description set by worker");
        System.out.println(worker.getById(0));

        assertNotNull(worker.getById(0).getDescription());
    }

    @Test
    public void shouldClearAll(){
        System.out.println("ShouldClearAll");
        int expected = 0;
        worker.removeAll();
        int actual = worker.getStorageSize();
        before2();
        assertEquals(expected, actual);
    }
}
