package methods.returntypes;

import java.util.ArrayList;
import java.util.List;

public class WhatToReturnCollectionsSample {

    public static void main(String[] args) {
        System.out.println("-- BAD PRACTICE --");
        showBadPractice();

        System.out.println("\n-- GOOD PRACTICE --");
        showGoodPractice();
    }

    private static void showBadPractice() {
        var numberList = getNaturalNumbersAsStringListBadPractice(0);
        if (numberList != null) {
            numberList.forEach(element -> System.out.println("List element: " + element));
        }
    }

    private static List<String> getNaturalNumbersAsStringListBadPractice(int max) {
        if (max <= 0) {
            return null;
        }
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            numbers.add(String.valueOf(i));
        }
        return numbers;
    }

    private static void showGoodPractice() {
        getNaturalNumbersAsStringListGoodPractice(0)
                .forEach(element -> System.out.println("List element: " + element));
    }

    private static List<String> getNaturalNumbersAsStringListGoodPractice(int max) {
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            numbers.add(String.valueOf(i));
        }
        return numbers;
    }

}
