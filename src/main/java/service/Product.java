package service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
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

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public void setId() {
        Id = productsTotal;
        productsTotal++;
    }

    public BigDecimal getPrice() {
        price.setScale(2, RoundingMode.HALF_UP);
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public category getCategory() {
        return productCategory;
    }

    public void setCategory(category productCategory) {
        this.productCategory = productCategory;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        if (discount.intValue() > 0 && discount.intValue() < 100) {
            this.discount = discount;
            setDiscountPrice();
        } else if (discount.intValue() == 0) {
            this.discount = discount.ZERO;
            setDiscountPrice();
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

    public void setDiscountPrice() {
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