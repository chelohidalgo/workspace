package general.optimisation;

public class OptimisationSample {

    public static void main(String[] args) {
        System.out.println("-- BAD PRACTICE --");
        long startTime = System.currentTimeMillis();
        BitwiseSquareCalculator.getSquare(98723980);
        BitwiseSquareCalculator.getSquare(98723980);
        BitwiseSquareCalculator.getSquare(98723980);
        BitwiseSquareCalculator.getSquare(98723980);
        System.out.println("Time spent in ms: " + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        System.out.println("\n-- GOOD PRACTICE --");
        Math.pow(98723980, 2);
        Math.pow(98723980, 2);
        Math.pow(98723980, 2);
        Math.pow(98723980, 2);
        System.out.println("Time spent in ms: " + (System.currentTimeMillis() - startTime));
    }

}
