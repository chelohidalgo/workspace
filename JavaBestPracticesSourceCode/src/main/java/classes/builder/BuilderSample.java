package classes.builder;

import java.math.BigDecimal;

public class BuilderSample {

    public static void main(String[] args) {
        // goal: create products with 6 fields
        // 2 mandatory fields: id and name
        // 4 optional fields: price, manufacturer, description, category

        System.out.println("-- CONSTRUCTOR --");
        showConstructor();

        System.out.println("\n-- SETTERS --");
        showSetters();

        System.out.println("\n-- BUILDER --");
        showBuilder();
    }

    private static void showConstructor() {
        // constructor
        ProductConstructor productConstructor = new ProductConstructor("1", "Laptop", BigDecimal.valueOf(999.99), "HP", "High-performance laptop", "Electronics");
        System.out.println(productConstructor);
    }

    private static void showSetters() {
        ProductSetters productSetters = new ProductSetters("1", "Laptop");
        productSetters.setPrice(BigDecimal.valueOf(999.99));
        System.out.println(productSetters);
        productSetters.setManufacturer("HP");
        productSetters.setDescription("High-performance laptop");
        productSetters.setCategory("Electronics");
        System.out.println(productSetters);
    }

    private static void showBuilder() {
        ProductWithBuilder product = new ProductWithBuilder.Builder("1", "Laptop")
                .price(BigDecimal.valueOf(999.99))
                .manufacturer("HP")
                .description("High-performance laptop")
                .category("Electronics")
                .build();
        System.out.println(product);
    }

}
