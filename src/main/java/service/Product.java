package service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Product {
    public static Long productsTotal = 0l;
    private String name;
    private Long Id;
    private BigDecimal price;
    category productCategory;
    private BigDecimal discount;
    private String description;
    private BigDecimal discountPrice;


    public static Long getProductsTotal() {
        return productsTotal;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    void setId() {
        Id = productsTotal;
        productsTotal++;
    }

    public BigDecimal getPrice() {
        price.setScale(2, RoundingMode.HALF_UP);
        return price;
    }

    void setPrice(BigDecimal price) {
        this.price = price;
    }

    category getCategory() {
        return productCategory;
    }

    void setCategory(category productCategory) {
        this.productCategory = productCategory;
    }

    private BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        if (discount.intValue() > 0 && discount.intValue() < 100) {
            this.discount = discount;
            setDiscountPrice();
        } else if (discount.intValue() == 0) {
            this.discount = discount.ZERO;
            this.discountPrice = null;
        } else {
            System.out.println("Discount must be in range 0 - 100");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    private void setDiscountPrice() {
        BigDecimal discount = getDiscount().multiply(((getPrice().divide(new BigDecimal(100)))));
        discount.setScale(2, RoundingMode.CEILING);
        discountPrice = getPrice().subtract(discount);
    }

    @Override
    public String toString() {
        String info = "Product: " + this.getId() + '\n' +
                "name = " + name + '\n' +
                "price = " + price + '\n' +
                "productCategory = " + productCategory + '\n';
        if (getDiscount() != null && discount.intValue() != 0) {
            info = info + "discount = " + discount + '\n' +
                    "discountPrice = " + discountPrice + '\n';
        }
        if (getDescription() != null) {
            info = info + ", description = " + description;
        }
        return info;
    }
}