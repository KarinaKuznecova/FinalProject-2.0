import service.Product;
import service.Drink;
import org.junit.Test;
import service.Worker;

import static service.category.DRINKS;
import static junit.framework.Assert.*;

import java.math.BigDecimal;

public class DiscountTest {
    @Test
    public void testDiscount() {
        System.out.println("Test discount");
        Worker worker = new Worker();
        Drink whiskey = (Drink) worker.createNew("Whiskey", BigDecimal.valueOf(100), DRINKS);
        whiskey.setDiscount(BigDecimal.valueOf(30));

        BigDecimal actualbd = whiskey.getDiscountPrice();
        Double actual = actualbd.doubleValue();
        assertEquals(70.0, actual);
    }

    @Test
    public void testDiscount2() {
        System.out.println("Test Discount 2");
        Worker worker = new Worker();
        Drink whiskey = (Drink) worker.createNew("Whiskey expensive", BigDecimal.valueOf(20), DRINKS);
        whiskey.setDiscount(BigDecimal.valueOf(130));
        BigDecimal actual = whiskey.getDiscountPrice();
        assertEquals(null, actual);
    }

    @Test
    public void shouldIncrementProductsTotal() {
        System.out.println("Test shouldIncrementProductsTotal");
        long expected = Product.productsTotal + 1;
        Worker worker = new Worker();
        Drink whiskey = (Drink) worker.createNew("Whiskey Jim Beam", BigDecimal.valueOf(20), DRINKS);
        long actual = Product.getProductsTotal();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetDescription() {
        System.out.println("Test shouldSetDescription");
        Worker worker = new Worker();
        Drink milk = (Drink) worker.createNew("Fresh Milk", BigDecimal.valueOf(20), DRINKS);
        milk.setDescription("Fresh milk from lovely cows");
        String expected = "Fresh milk from lovely cows";
        String actual = milk.getDescription();
        System.out.println(milk);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetDiscountToZero() {
        System.out.println("Test shouldSetDiscountToZero");
        Worker worker = new Worker();
        Drink whiskey = (Drink) worker.createNew("Whiskey Tullamore", BigDecimal.valueOf(20), DRINKS);
        whiskey.setDiscount(BigDecimal.valueOf(0));
        BigDecimal actualbd = whiskey.getDiscountPrice();
        Double actual = actualbd.doubleValue();
        double expected = whiskey.getPrice().doubleValue();
        assertEquals(expected, actual);
    }
}