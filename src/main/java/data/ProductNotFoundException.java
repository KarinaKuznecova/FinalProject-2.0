package data;

public class ProductNotFoundException extends RuntimeException {
    ProductNotFoundException(String message) {
        super(message);
    }
}