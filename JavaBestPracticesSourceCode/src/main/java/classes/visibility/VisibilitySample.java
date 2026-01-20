package classes.visibility;

import java.math.BigDecimal;
import java.text.ParseException;

public class VisibilitySample {

    public static void main(String[] args) throws ParseException {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Toothbrush", BigDecimal.valueOf(10.0));
        cart.addItem("Comb", BigDecimal.valueOf(25.0));
        cart.displayItems();
    }

}
