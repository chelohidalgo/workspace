package classes.immutability;

import java.util.ArrayList;
import java.util.Arrays;

public class ImmutabilitySample {

    public static void main(String[] args) {
        System.out.println("-- BAD PRACTICE --");
        showBadPractice();

        System.out.println("\n-- GOOD PRACTICE --");
        showGoodPractice();
    }

    private static void showBadPractice() {
        var sneakyGenres = new ArrayList<>(Arrays.asList("fantasy", "science"));
        var book = new ImmutableBook("The life of Java", "John Doe", sneakyGenres);
        System.out.println(book);
        // problem 1: can modify sneakyGenres
        sneakyGenres.clear();
        System.out.println(book);

        // problem 2: can access the mutable list using a getter
        var genres = book.getGenres();
        genres.add("surprise!");
        System.out.println(book);
    }

    private static void showGoodPractice() {
        var sneakyGenres = new ArrayList<>(Arrays.asList("fantasy", "science"));
        var book = new GoodImmutableBook("The life of Java", "John Doe", sneakyGenres);
        System.out.println(book);
        // problem 1: can modify sneakyGenres
        sneakyGenres.clear();
        System.out.println(book);

        // problem 2: can access the mutable list using a getter
        var genres = book.getGenres();
        genres.add("surprise!");
        System.out.println(book);
    }

}
