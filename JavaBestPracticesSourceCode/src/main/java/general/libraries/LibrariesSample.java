package general.libraries;

import java.util.Objects;

public class LibrariesSample {

    public static void main(String[] args) {
        String toReverse = "Once upon a time, there was a Java developer that really wanted to become good at programming.";
        System.out.println("-- BAD PRACTICE --");
        long startTime = System.currentTimeMillis();
        reverseStringBadPractice(toReverse);
        System.out.println("Time spent in ms: " + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        System.out.println("\n-- GOOD PRACTICE --");
        reverseStringGoodPractice(toReverse);
        System.out.println("Time spent in ms: " + (System.currentTimeMillis() - startTime));
    }

    private static String reverseStringBadPractice(String input) {
        String result = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            result += input.charAt(i);
        }
        return result;
    }

    private static String reverseStringGoodPractice(String input) {
        Objects.requireNonNull(input);
        return new StringBuilder(input).reverse().toString();
    }

}
