package classes.visibility;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class ShoppingCart {
    private final List<String> items;
    private BigDecimal total;

    ShoppingCart() {
        items = new ArrayList<>();
        total = BigDecimal.ZERO;
    }

    void addItem(String item, BigDecimal price) {
        if (!isValidPrice(price)) {
            throw new IllegalArgumentException("Price below zero: " + price);
        }
        items.add(item);
        total = total.add(price);
    }

    void displayItems() {
        System.out.println("Items in the cart:");
        for (String item : items) {
            System.out.println(item);
        }
    }

    private boolean isValidPrice(BigDecimal price) {
        return price.compareTo(BigDecimal.ZERO) > 0;
    }

}
