package general.optimisation;

import java.util.HashMap;
import java.util.Map;

public class BitwiseSquareCalculator {

    private static final Map<Long, Long> cache = new HashMap<>();

    public static long getSquare(long number) {
        if (cache.containsKey(number)) {
            return cache.get(number);
        }

        if (number == 0) {
            return 0;  // The square of 0 is 0.
        }

        if (number < 0) {
            // Handle negative numbers
            number = -number;
        }

        long result = 0;
        long originalNumber = number;

        for (int i = 0; i < 31; i++) {
            if ((number & 1) == 1) {
                result += originalNumber << i;
            }
            number >>= 1;
        }
        cache.put(number, result);
        return result;
    }
}
