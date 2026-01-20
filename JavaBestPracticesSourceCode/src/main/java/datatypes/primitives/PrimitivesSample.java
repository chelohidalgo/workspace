package datatypes.primitives;

public class PrimitivesSample {

    static Integer internalNumber;

    public static void main(String[] args) {

        //showBadPracticeNulls();

        System.out.println("-- BAD PRACTICE --");
        long startTime = System.currentTimeMillis();
        showBadPracticePerformance();
        System.out.println("Time spent in ms: " + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        System.out.println("\n-- GOOD PRACTICE --");
        showGoodPracticePerformance();
        System.out.println("Time spent in ms: " + (System.currentTimeMillis() - startTime));
    }

    private static void showBadPracticeNulls() {
        if (internalNumber == 108) {
            System.out.println("The internal number is 108!");
        }
    }

    private static void showBadPracticePerformance() {
        Integer sum = 0;
        for (int i = 0; i < 10_000_000; i++) {
            sum += 1;
        }
        System.out.println("Final number: " + sum);
    }

    private static void showGoodPracticePerformance() {
        int sum = 0;
        for (int i = 0; i < 10_000_000; i++) {
            sum += 1;
        }
        System.out.println("Final number: " + sum);
    }

    private static boolean areEqual(int a) {
        return a == 42;
    }

}
