package methods.paramvalidation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class BadPriceList {

    private final List<BigDecimal> prices;

    private BadPriceList(List<BigDecimal> prices) {
        this.prices = prices;
    }

    static BadPriceList emptyPriceList() {
        return new BadPriceList(new ArrayList<>());
    }

    void addPrice(BigDecimal price) {
        this.prices.add(price);
    }

    BigDecimal getPriceSum() {
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal price : this.prices) {
            sum = sum.add(price);
        }
        return sum;
    }

}
