
import service.Product;

import org.junit.Test;
import service.Worker;

import static service.category.DAIRY;
import static service.category.DRINKS;
import static junit.framework.Assert.*;

import java.math.BigDecimal;

public class DiscountTest {

    Worker worker = new Worker();
    Product product = worker.createNew("Milk", BigDecimal.valueOf(100), DAIRY);


    @Test
    public void testDiscount() {
        System.out.println("Test discount");
        product.setDiscount(BigDecimal.valueOf(30));
        BigDecimal actualbd = product.getDiscountPrice();
        Double actual = actualbd.doubleValue();
        assertEquals(70.0, actual);
    }

    @Test
    public void testDiscount2() {
        System.out.println("Test Discount 2");
        product.setDiscount(BigDecimal.valueOf(130));
        assertNull(product.getDiscountPrice());
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
        product.setDiscount(BigDecimal.valueOf(20));
        product.setDiscount(BigDecimal.valueOf(0));
        assertNull(product.getDiscountPrice());
    }

    @Test
    public void shouldSetDiscountForCategory() {
        System.out.println("Test shouldSetDiscountForCategory");
        worker.createNew("Juice", BigDecimal.valueOf(10), DRINKS);
        Product productOnSale = worker.createNew("Coca-Cola", BigDecimal.valueOf(20), DRINKS);
        worker.setDiscountForCategory(DRINKS, BigDecimal.valueOf(50));
        double expected = 10;
        double actual = productOnSale.getDiscountPrice().doubleValue();
        assertEquals(expected, actual);
    }
}