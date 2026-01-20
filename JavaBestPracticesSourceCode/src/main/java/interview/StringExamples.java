package interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StringExamples {
    public static void main(java.lang.String[] args) {
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

//        List<String> inmutableList1 = Arrays.asList("Uno", "Dos", "Tres");
//        inmutableList1.add("Cuatro"); // --> throw java.lang.UnsupportedOperationException
//        inmutableList1.remove(1); // same
//        inmutableList1.stream().forEach(System.out::println);

        // Since java 9
        List<String> inmutableList2 = List.of("Uno", "Dos", "Tres");
        inmutableList2.add("New");
        inmutableList2.stream().forEach(System.out::println);
        Set<String> countries = Set.of("EC", "US", "BR");
        Map<Integer, String> errorCodes = Map.of(404, "Not Found", 500, "Server Error");




    }
}
