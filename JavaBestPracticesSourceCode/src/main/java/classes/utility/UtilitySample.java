package classes.utility;

public class UtilitySample {

    public static void main(String[] args) {
        System.out.println("-- BAD PRACTICE --");
        showBadPractice();

        System.out.println("\n-- GOOD PRACTICE --");
        showGoodPractice();
    }

    private static void showBadPractice() {
        // unnecessary instantiation
        BrokenStringUtils utils = new BrokenStringUtils();
        String sample = "sample string";
        System.out.println("Sample string=" + sample + ", reversed=" + UsefulStringUtils.reverseString(sample));
    }

    private static void showGoodPractice() {
        // cannot instantiate
        // UsefulStringUtils utils = new UsefulStringUtils();
        String sample = "sample string";
        System.out.println("Sample string=" + sample + ", reversed=" + UsefulStringUtils.reverseString(sample));
    }


}
