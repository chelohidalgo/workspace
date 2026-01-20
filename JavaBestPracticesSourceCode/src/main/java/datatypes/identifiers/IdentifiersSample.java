package datatypes.identifiers;

import java.util.Random;
import java.util.UUID;

public class IdentifiersSample {

    public static void main(String[] args) {
        System.out.println("-- BAD PRACTICE --");
        showBadPractice();

        System.out.println("\n-- GOOD PRACTICE --");
        showGoodPractice();
    }

    private static void showBadPractice() {
        long policyNumber = 456780532;
        int newBusinessId = new Random().nextInt();
        System.out.println("For policy no: " + policyNumber + " we have generated a new id: " + newBusinessId);
    }

    private static void showGoodPractice() {
        String policyNumber = "456780532";
        UUID newBusinessId = UUID.randomUUID();
        System.out.println("For policy no: " + policyNumber + " we have generated a new id: " + newBusinessId);
    }

}
