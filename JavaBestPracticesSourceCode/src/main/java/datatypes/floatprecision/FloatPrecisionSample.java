package datatypes.floatprecision;

import java.math.BigDecimal;

public class FloatPrecisionSample {

    public static void main(String[] args) {
        System.out.println("-- BAD PRACTICE --");
        showBadPractice();

        System.out.println("\n-- GOOD PRACTICE 1 --");
        showGoodPracticeIntegers();

        System.out.println("\n-- GOOD PRACTICE 2 --");
        showGoodPracticeBigDecimals();
    }

    private static void showBadPractice() {
        double budgetUsd = 1.00;
        double itemPriceUsd = 0.1;

        System.out.println("Initial budget: " + budgetUsd);
        System.out.println("Item price: " + itemPriceUsd);
        System.out.println("Money left after buying 9 items: " + (budgetUsd - itemPriceUsd * 9));
    }

    private static void showGoodPracticeIntegers() {
        int budgetUsd = 100;
        int itemPriceUsd = 10;

        System.out.println("Initial budget [cents]: " + budgetUsd);
        System.out.println("Item price [cents]: " + itemPriceUsd);
        System.out.println("Money left after buying 9 items: " + (budgetUsd - itemPriceUsd * 9));
    }

    private static void showGoodPracticeBigDecimals() {
        final BigDecimal budgetUsd = new BigDecimal("1.0");
        final BigDecimal itemPriceUsd = new BigDecimal("0.1");

        System.out.println("Initial budget: " + budgetUsd);
        System.out.println("Item price: " + itemPriceUsd);
        System.out.println("Money left after buying 9 items: " + (budgetUsd.subtract(itemPriceUsd.multiply(new BigDecimal("9.0")))));
    }

}
