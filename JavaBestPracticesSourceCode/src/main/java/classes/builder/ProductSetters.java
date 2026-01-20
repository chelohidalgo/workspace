package classes.builder;

import java.math.BigDecimal;

class ProductSetters {
    private String productId;
    private String name;
    private BigDecimal price = BigDecimal.ZERO;
    private String manufacturer = "";
    private String description = "";
    private String category = "";

    public ProductSetters(String productId, String name) {
        this.productId = productId;
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductSetters{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", manufacturer='" + manufacturer + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
