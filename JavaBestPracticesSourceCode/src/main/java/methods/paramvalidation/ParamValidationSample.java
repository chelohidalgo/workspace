package methods.paramvalidation;

import java.math.BigDecimal;

public class ParamValidationSample {

    public static void main(String[] args) {
        System.out.println("-- BAD PRACTICE --");
        showBadPractice();

        System.out.println("\n-- GOOD PRACTICE --");
        showGoodPractice();
    }

    private static void showBadPractice() {
//        var priceListNull = BadPriceList.emptyPriceList();
//        priceListNull.addPrice(null);
//        System.out.println("Sum of prices [priceListNull]: " + priceListNull.getPriceSum());

        var priceListNegative = BadPriceList.emptyPriceList();
        priceListNegative.addPrice(BigDecimal.valueOf(5.0));
        priceListNegative.addPrice(BigDecimal.valueOf(-10.0));
        System.out.println("Sum of prices [priceListNegative]: " + priceListNegative.getPriceSum());
    }

    private static void showGoodPractice() {
//        var priceListNull = GoodPriceList.emptyPriceList();
//        priceListNull.addPrice(null);
//        System.out.println("Sum of prices [priceListNull]: " + priceListNull.getPriceSum());

        var priceListNegative = GoodPriceList.emptyPriceList();
        priceListNegative.addPrice(BigDecimal.valueOf(5.0));
        priceListNegative.addPrice(BigDecimal.valueOf(-10.0));
        System.out.println("Sum of prices [priceListNegative]: " + priceListNegative.getPriceSum());
    }

}
