package interview.streams;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise {

    public static void main(String[] args) {
        //Use Stream API to square each number in the list and collect the result into a new list
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numbersSquare = numbers.stream().map(number -> number * number).toList();
        numbersSquare.stream().forEach(System.out::println);

        //Use Stream API to find the length of the longest name in the list
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eva");
        Optional<Integer> max = Optional.of(names.stream()
                .map(String::length)
                .max(Integer::compareTo)).orElse(Optional.empty());
        System.out.println(max.get());

        //Use Stream API to count the total number of distinct words (case-insensitive) in all the sentences.
        List<String> sentences = Arrays.asList(
                "Java Stream API provides a fluent interface for processing sequences of elements.",
                "It supports functional-style operations on streams of elements, such as map-reduce transformations.",
                "In this exercise, you need to count the total number of words in all sentences."
        );

        long count = sentences.stream()
                .flatMap(e -> Arrays.stream(e.split(" ")))
                .distinct()
                .count();
        System.out.println(count);

        //Use Stream API to find the concatenation of the first two words that have even lengths.
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        String result = words.stream()
                .filter(word -> word.length()%2 == 0)
                .limit(2)
                .collect(Collectors.joining());
        System.out.println(result);

        //Use Stream API to find the sum of the squares of even numbers in the list
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = numbers2.stream().filter(number-> number%2 == 0)
                .mapToInt(number->number*number)
                .sum();
        System.out.println(sum);

        List<Product> products = List.of(
                new Product("Book", 12.99, "Stationery"),
                new Product("Pen", 1.49, "Stationery"),
                new Product("Notebook", 5.25, "Electronics"),
                new Product("Pencil", 0.99, "Stationery")
        );

        //Filter products with price > 1.00, sorted descending and only names
        String resultSorted = products.stream()
                .filter(product -> product.price > 1)
                .sorted(Comparator.comparing(Product::price, Comparator.reverseOrder()))
                .map(Product::name)
                .collect(Collectors.joining(","));
        System.out.println(resultSorted);

        String resultSorted2 = products.stream()
                .filter(product -> product.price() > 1)
                .sorted(Comparator.comparing(Product::price).reversed())
                .map(Product::name)
                .collect(Collectors.joining(", "));
        System.out.println(resultSorted2);

        //Group by category
        Map<String, List<Product>> byCategory = products.stream().collect(Collectors.groupingBy(Product::category));
        System.out.println(byCategory);

        //Product Names by Category
        Map<String, List<String>> namesByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::category,
                        Collectors.mapping(Product::name, Collectors.toList())
                ));
        System.out.println(namesByCategory);

        //calculate total price per category:
        Map<String, Double> totalByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::category,
                        Collectors.reducing(0.0, Product::price, Double::sum)
                ));
        System.out.println(totalByCategory);

        List<Employee> employees = List.of(
                new Employee("Alice", "HR", 4200),
                new Employee("Bob", "IT", 5000),
                new Employee("Carol", "HR", 3900),
                new Employee("Dave", "IT", 5500),
                new Employee("Eve", "Finance", 4800)
        );

        //Group employees by department.Compute the average salary per department.Sort departments by average salary descending
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::dept,
                        Collectors.averagingDouble(Employee::salary)));

        result = avgSalaryByDept.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue(Comparator.reverseOrder()))
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining("\n"));

        System.out.println(result);

        //Find the employee with the highest salary in each department.
        Map<String, Optional<Employee>> employeeMaxsalary = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::dept,
                        Collectors.maxBy(Comparator.comparing(Employee::salary))));
        System.out.println(employeeMaxsalary);

        //If I want to remove the optional then use
        Map<String, Employee> employeeMaxsalary2 = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::dept,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Employee::salary)),
                                Optional::get
                        )
                ));
        System.out.println(employeeMaxsalary2);

        //Print the department name and that employee’s name.
        Map<String, List<Employee>> dptoAndEmployees = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::dept,
                        Collectors.toList()));
        dptoAndEmployees.forEach((dept, list) -> {
            System.out.println(dept + "->" + list.stream().map(Employee::name).collect(Collectors.joining(", ")));
        });


        //Using functional interfaces (Predicate, Function, and Consumer):
        //
        //Filter out empty names.
        //
        //Convert remaining names to uppercase.
        //
        //Print each one.
        List<String> nombres = List.of("Alice", "", "Bob", "Carol", "");

        Predicate<String> isNotEmpty = s -> !s.isEmpty();
        Function<String,String> upperCase = String::toUpperCase;
        Consumer<String> print = System.out::println;
        for (String name : nombres) {
            if(isNotEmpty.test(name)) {
                name = upperCase.apply(name);
                print.accept(name);
            }
        }

        differencesOfTimeInStream();

    }

    private static void differencesOfTimeInStream() {
        List<Integer> numbers = IntStream.rangeClosed(1, 1_000_000)
                .boxed()
                .toList();

// Sequential
        long start = System.currentTimeMillis();
        long sum1 = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sequential took: " + (System.currentTimeMillis() - start) + "ms");

// Parallel
        start = System.currentTimeMillis();
        long sum2 = numbers.parallelStream().reduce(0, Integer::sum);
        System.out.println("Parallel took: " + (System.currentTimeMillis() - start) + "ms");

    }

    record Product(String name, double price, String category) {}

    record Employee(String name, String dept, double salary) {}

}
