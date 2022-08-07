package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import collections.Employee;

public class Demo {

    public static void main(String[] args) {

        // Using streams to find duplicate value and their frequency
        System.out.println(
                Stream.of(1, 1, 2, 3, 3, 1, 6, 8, 9)
                        .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                        .entrySet().stream()
                        .filter(entry -> entry.getValue() > 1).collect(Collectors.toSet()));

        // Capitalise the first character of employee objects name
        Employee e1 = new Employee(1, "mohd");
        Employee e2 = new Employee(2, "fahad");
        Employee e3 = new Employee(3, "khan");
        Employee[] empArray = { e1, e2, e3 };
        Stream<Employee> stream = Arrays.stream(empArray);
        List<String> nameList = stream.map(emp -> {
            String name = emp.getName();
            return name.toUpperCase().charAt(0) + name.substring(1);
        }).collect(Collectors.toList());

        System.out.println(nameList);
    }

}
