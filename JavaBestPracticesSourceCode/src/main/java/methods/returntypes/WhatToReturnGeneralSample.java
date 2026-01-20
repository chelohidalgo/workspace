package methods.returntypes;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class WhatToReturnGeneralSample {

    public static void main(String[] args) {
        System.out.println("-- BAD PRACTICE --");
        showBadPractice();

        System.out.println("\n-- GOOD PRACTICE --");
        showGoodPractice();
    }

    private static void showBadPractice() {
        List<String> words = Collections.emptyList();
        // magical value - not aware
        System.out.println("The longest word is: " + getLongestStringMagicValue(words));

        // magical value - aware
        String longestWordMagicValue = getLongestStringMagicValue(words);
        if (!longestWordMagicValue.equals("NOT_SUPPORTED")) {
            System.out.println("The longest word is: " + longestWordMagicValue);
        } else {
            System.out.println("You did not provide any words!");
        }

        // null - not aware
        System.out.println("The longest word is: " + getLongestStringNull(words));

        // null - aware
        String longestWordNull = getLongestStringNull(words);
        if (longestWordNull != null) {
            System.out.println("The longest word is: " + longestWordNull);
        } else {
            System.out.println("You did not provide any words!");
        }
    }

    private static String getLongestStringMagicValue(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            return "NOT_SUPPORTED";
        }
        return Collections.max(strings, Comparator.comparing(String::length));
    }

    private static String getLongestStringNull(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            return null;
        }
        return Collections.max(strings, Comparator.comparing(String::length));
    }

    private static void showGoodPractice() {
        // exception
        List<String> words = Collections.emptyList();
        try {
            System.out.println("The longest word is: " + getLongestStringException(words));
        } catch (IllegalArgumentException ex) {
            System.out.println("You did not provide any words!");
        }

        // reasonable default
        System.out.println("The longest word is: " + getLongestStringDefault(words));

        // Optional
        System.out.println(
                getLongestStringOptional(words)
                        .map(word -> "The longest word is: " + word)
                        .orElse("You did not provide any words!"));
    }

    private static String getLongestStringException(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            throw new IllegalArgumentException("List empty or null!");
        }
        return Collections.max(strings, Comparator.comparing(String::length));
    }

    private static String getLongestStringDefault(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            return "";
        }
        return Collections.max(strings, Comparator.comparing(String::length));
    }

    private static Optional<String> getLongestStringOptional(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(Collections.max(strings, Comparator.comparing(String::length)));
    }

}
