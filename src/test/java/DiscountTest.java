import org.junit.BeforeClass;
import org.junit.Test;
import service.Product;
import service.Worker;

import static service.category.DRINKS;
import static org.junit.Assert.*;

import java.math.BigDecimal;

public class DiscountTest {

    private Worker worker = new Worker();

    @BeforeClass
    public static void before() {
        ActionTest tester = new ActionTest();
        tester.before2();
    }

    @Test
    public void testDiscount() {
        System.out.println("Test discount");
        worker.setPriceById(0, BigDecimal.valueOf(100));
        worker.setDiscountById(0, BigDecimal.valueOf(30));
        double actual = worker.getDiscountPriceById(0).doubleValue();
        assertEquals(70.0, actual, 1e-15);
    }

    @Test
    public void testDiscount2() {
        System.out.println("Test Discount 2");
        worker.setDiscountById(0, BigDecimal.valueOf(0));
        worker.setDiscountById(0, BigDecimal.valueOf(130));
        assertNull(worker.getDiscountPriceById(0));
    }

    @Test
    public void shouldIncrementProductsTotal() {
        System.out.println("Test shouldIncrementProductsTotal");
        long expected = Product.productsTotal + 1;
        worker.createNew("Grape Juice", BigDecimal.valueOf(20), DRINKS);
        long actual = Product.getProductsTotal();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetDiscountToZero() {
        System.out.println("Test shouldSetDiscountToZero");
        worker.setDiscountById(0, BigDecimal.valueOf(20));
        worker.setDiscountById(0, BigDecimal.valueOf(0));
        assertNull(worker.getDiscountPriceById(0));
    }

    @Test
    public void shouldSetDiscountForCategory() {
        System.out.println("Test shouldSetDiscountForCategory");
        double expected = (worker.getPriceById(0).divide(new BigDecimal(2), 2)).doubleValue();
        worker.setDiscountForCategory(DRINKS, BigDecimal.valueOf(50));
        double actual = worker.getDiscountPriceById(0).doubleValue();
        assertEquals(expected, actual, 1e-15);
    }
}