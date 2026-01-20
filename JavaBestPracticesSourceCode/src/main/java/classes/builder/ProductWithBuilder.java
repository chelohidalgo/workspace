package classes.builder;

import java.math.BigDecimal;

class ProductWithBuilder {
    private final String productId;
    private final String name;
    private final BigDecimal price;
    private final String manufacturer;
    private final String description;
    private final String category;

    private ProductWithBuilder(Builder builder) {
        this.productId = builder.productId;
        this.name = builder.name;
        this.price = builder.price;
        this.manufacturer = builder.manufacturer;
        this.description = builder.description;
        this.category = builder.category;
    }

    @Override
    public String toString() {
        return "ProductWithBuilder{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", manufacturer='" + manufacturer + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    static class Builder {
        private final String productId;
        private final String name;
        private BigDecimal price = BigDecimal.ZERO;
        private String manufacturer = "";
        private String description = "";
        private String category = "";

        public Builder(String productId, String name) {
            this.productId = productId;
            this.name = name;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder manufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public ProductWithBuilder build() {
            return new ProductWithBuilder(this);
        }
    }

}
