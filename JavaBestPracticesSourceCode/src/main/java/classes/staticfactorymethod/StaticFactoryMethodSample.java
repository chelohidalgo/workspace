package classes.staticfactorymethod;

import java.time.LocalDate;
import java.util.Map;

public class StaticFactoryMethodSample {

    public static void main(String[] args) {
        System.out.println("-- CLASSIC APPROACH --");
        showClassicApproach();

        System.out.println("\n-- ALTERNATIVE APPROACH --");
        showAlternativeApproach();
    }

    private static void showClassicApproach() {
        PersonClassicApproach person = new PersonClassicApproach("John", LocalDate.of(1992, 10, 15));
    }

    private static void showAlternativeApproach() {
        PersonAlternativeApproach person = PersonAlternativeApproach.of("John", LocalDate.of(1992, 10, 15));

        // sample static factory methods from standard Java packages
        Integer.valueOf(5);
        Map.of("SampleKey", 1);
        Map.of("SampleKey", 1, "AnotherKey", 2);
    }

}
