package exceptions.appropriateex;

import java.util.List;

public class AppropriateExceptionsSample {

    public static void main(String[] args) {
        System.out.println("-- BAD PRACTICE --");
        showBadPractice();

        System.out.println("\n-- GOOD PRACTICE: COMMENT --");
        showGoodPracticeComment();
    }

    private static void showBadPractice() {
        // vague exception that is too general; hard to test
        sumElementsFromRangeBad(null, 0, 5);
        sumElementsFromRangeBad(List.of(5, 4), -4, 2);
    }

    private static int sumElementsFromRangeBad(List<Integer> elements, int startInclusive, int endExclusive) {
        if (elements == null || startInclusive < 0 || startInclusive > endExclusive || endExclusive > elements.size()) {
            throw new RuntimeException("invalid arguments!"); // how do you test for this ex reliably?
        }
        int sum = 0;
        for (int i = startInclusive; i < endExclusive; i++) {
            sum += elements.get(i);
        }
        return sum;
    }

    private static void showGoodPracticeComment() {
        // more meaningful, standard exceptions thrown according to the problem
        sumElementsFromRangeGood(null, 0, 5);
        sumElementsFromRangeGood(List.of(5, 4), -4, 2);
    }

    private static int sumElementsFromRangeGood(List<Integer> elements, int startInclusive, int endExclusive) {
        if (elements == null) {
            throw new NullPointerException("'elements' argument is null!");
        }
        if (startInclusive < 0 || startInclusive > endExclusive || endExclusive > elements.size()) {
            throw new IndexOutOfBoundsException("startInclusive=" + startInclusive + ", endExclusive=" + endExclusive + " list size=" + elements.size());
        }
        int sum = 0;
        for (int i = startInclusive; i < endExclusive; i++) {
            sum += elements.get(i);
        }
        return sum;
    }

}
