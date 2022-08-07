package functionalInterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import collections.Developer;

public class Demo {

    public static void main(String[] args) {

        // Giving implementation for abstract method of functional interface
        Developer dev = (a) -> {
            System.out.println("Dev sleeps impl");
        };
        dev.sleep("");

        // Built in Functional Interfaces

        // Predicate takes an input type and returns true or false with test()
        Predicate<Integer> predicate = (a) -> {
            if (a > 10) {
                return true;
            }
            return false;
        };
        System.out.println(predicate.test(9));

        // Function takes an input and return type and returns something with apply()
        Function<Integer, String> function = (a) -> {
            if (a == 1) {
                return "Provided value is one";
            }
            return "Value provided " + a;
        };
        System.out.println(function.apply(10));

        // Supplier doesn't takes an input but a return type and returns something with
        // get()
        Supplier<String> supplier = () -> {
            return "I am a supplier";
        };
        System.out.println(supplier.get());

        // Consumer takes an input and no return type and doesn't returns with accept()
        Consumer<String> consumer = (a) -> {
            System.out.println("From consumer " + a);
        };
        consumer.accept("t");

        // Function Chaining ---> output of one goes to input of second
        Function<String, String> function2 = (a) -> {
            if (a == "Provided value is one") {
                return "Matched";
            }
            return "Not Matched " + a;
        };
        System.out.println(function.andThen(function2).apply(2));

    }

}
