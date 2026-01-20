package methods.paramvalidation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class GoodPriceList {

    private final List<BigDecimal> prices;

    private GoodPriceList(List<BigDecimal> prices) {
        this.prices = prices;
    }

    static GoodPriceList emptyPriceList() {
        return new GoodPriceList(new ArrayList<>());
    }

    void addPrice(BigDecimal price) {
        Objects.requireNonNull(price);
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price below 0: " + price);
        }
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
