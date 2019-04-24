package service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
    public static Long productsTotal = 0L;
    private String name;
    private Long id;
    private BigDecimal price;
    private category productCategory;
    private BigDecimal discount;
    private String description;
    private BigDecimal discountPrice;

    Product(String name, BigDecimal price, category productCategory) {
        this.name = name;
        this.price = price;
        this.productCategory = productCategory;
        setId();
    }

    public static Long getProductsTotal() {
        return productsTotal;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    Long getId() {
        return id;
    }

    private void setId() {
        id = productsTotal;
        productsTotal++;
    }

    BigDecimal getPrice() {
        price = price.setScale(2, RoundingMode.HALF_UP);
        return price;
    }

    void setPrice(BigDecimal price) {
        this.price = price;
        setDiscount(BigDecimal.valueOf(0));
    }

    public category getCategory() {
        return productCategory;
    }

    private BigDecimal getDiscount() {
        return discount;
    }

    void setDiscount(BigDecimal discount) {
        if (discount.intValue() > 0 && discount.intValue() < 100) {
            this.discount = discount;
            setDiscountPrice();
        } else if (discount.intValue() == 0) {
            this.discount = null;
            this.discountPrice = null;
        } else {
            System.out.println("Discount must be in range 0 - 100");
        }
    }

    public String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    private void setDiscountPrice() {
        BigDecimal discount = getDiscount().multiply(((getPrice().divide(new BigDecimal("100")))));
        discountPrice = getPrice().subtract(discount).setScale(2, RoundingMode.CEILING);
    }

    static void resetProductsTotal() {
        productsTotal = 0L;
    }

    @Override
    public String toString() {
        String info = "Product: " + this.getId() + '\n' +
                "name = " + name + '\n' +
                "price = " + price + '\n' +
                "productCategory = " + productCategory + '\n';
        if (getDiscount() != null && discount.intValue() != 0) {
            info = info + "discount = " + discount + "%" + '\n' +
                    "discountPrice = " + discountPrice + '\n';
        }
        if (getDescription() != null) {
            info = info + "description = " + description;
        }
        return info;
    }
}