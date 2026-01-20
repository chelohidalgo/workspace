package exceptions.catchblock;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CatchBlockSample {

    public static void main(String[] args) {
        System.out.println("-- BAD PRACTICE --");
        showBadPractice();

        System.out.println("\n-- GOOD PRACTICE: COMMENT --");
        showGoodPracticeComment();

        System.out.println("\n-- GOOD PRACTICE: INFORMATION --");
        showGoodPracticeInformation();

        System.out.println("\n-- GOOD PRACTICE: TRANSLATE EXCEPTION --");
        showGoodPracticeTranslateException();
    }

    private static void showBadPractice() {
        System.out.println("Retrieving username...");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("non_existent_file.txt"));
            String line = reader.readLine();
            System.out.println("Username is: " + line);
        } catch (IOException e) {
        }
    }

    private static void showGoodPracticeComment() {
        System.out.println("Retrieving username...");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("non_existent_file.txt"));
            String line = reader.readLine();
            System.out.println("Username is: " + line);
        } catch (IOException ignored) {
            // ignored: this method is optional, if you get the username from the file, simply move on
        }
    }

    private static void showGoodPracticeInformation() {
        System.out.println("Retrieving username...");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("non_existent_file.txt"));
            String line = reader.readLine();
            System.out.println("Username is: " + line);
        } catch (IOException e) {
            System.out.println("We cannot get your username because of error: " + e.getMessage());
            // possibly also put some info into logs
        }
    }

    private static void showGoodPracticeTranslateException() {
        System.out.println("Retrieving username...");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("non_existent_file.txt"));
            String line = reader.readLine();
            System.out.println("First line of file is: " + line);
        } catch (IOException e) {
            throw new DataAccessException("Cannot retrieve username!");
        }
    }

}
