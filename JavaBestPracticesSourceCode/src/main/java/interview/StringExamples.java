package interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StringExamples {
    public static void main(java.lang.String[] args) {
        System.out.println("cuando si son diferentes 2 strings");
        otherAttempt();


        String a = "Hola";
        String b = "Hola";
        if (a.equals(b))
            System.out.println("Iguales");
        else
            System.out.println("No Iguales");

        if (a ==b)
            System.out.println("Iguales");
        else
            System.out.println("No Iguales");

        // New elements can't be added because are fixed list
        List<String> inmutableList1 = Arrays.asList("Uno", "Dos", "Tres");
        inmutableList1.add("Cuatro"); // --> throw java.lang.UnsupportedOperationException
        inmutableList1.remove(1); // same
        inmutableList1.stream().forEach(System.out::println);

        // Since java 9
        List<String> inmutableList2 = List.of("Uno", "Dos", "Tres");
        inmutableList2.add("New");
        inmutableList2.stream().forEach(System.out::println);
        Set<String> countries = Set.of("EC", "US", "BR");
        Map<Integer, String> errorCodes = Map.of(404, "Not Found", 500, "Server Error");




    }

    private static void otherAttempt(){
        String hola = "hola";
        //String hola1 = "hola";
        String hola1 = new String("hola");

        if (hola == hola1) {
            System.out.println("same address memory, but 2 references");
        } else {
            System.out.println("2 different objects and 2 memory address");
        }

        if (hola.equals(hola1)) {
            System.out.println("String values are equal");
        } else {
            System.out.println("Strings values are NOT equal");
        }
    }
}
