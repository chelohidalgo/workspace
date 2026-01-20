package datatypes.stringconcat;

public class StringConcatenationSample {

    public static void main(String[] args) {
        System.out.println("-- BAD PRACTICE --");
        long startTime = System.currentTimeMillis();
        showBadPractice();
        System.out.println("Time spent in ms: " + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        System.out.println("\n-- GOOD PRACTICE --");
        showGoodPractice();
        System.out.println("Time spent in ms: " + (System.currentTimeMillis() - startTime));
    }

    private static void showBadPractice() {
        String numericalSequence = "";
        for (int i = 0; i < 10_000; i++) {
            numericalSequence += i;
        }
        System.out.println(numericalSequence);
    }

    private static void showGoodPractice() {
        StringBuilder numericalSequence = new StringBuilder();
        for (int i = 0; i < 10_000; i++) {
            numericalSequence.append(i);
        }
        System.out.println(numericalSequence);
    }

}
