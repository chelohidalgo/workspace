package classes.builder;

import java.math.BigDecimal;

class ProductConstructor {
    private String productId;
    private String name;
    private BigDecimal price;
    private String manufacturer;
    private String description;
    private String category;


    ProductConstructor(String productId, String name) {
        this.productId = productId;
        this.name = name;
        this.price = BigDecimal.ZERO;
        this.manufacturer = "";
        this.description = "";
        this.category = "";
    }

    ProductConstructor(String productId, String name, BigDecimal price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.manufacturer = "";
        this.description = "";
        this.category = "";
    }

    ProductConstructor(String productId, String name, BigDecimal price, String manufacturer) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.description = "";
        this.category = "";
    }

    ProductConstructor(String productId, String name, BigDecimal price, String manufacturer, String description) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.description = description;
        this.category = "";
    }

    ProductConstructor(String productId, String name, BigDecimal price, String manufacturer, String description, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.description = description;
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductConstructor{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", manufacturer='" + manufacturer + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
