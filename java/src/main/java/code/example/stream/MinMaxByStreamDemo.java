package code.example.stream;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MinMaxByStreamDemo {

    public static void main(String[] args) {
        List<Customer> custs = Arrays.asList(new Customer("A", 56), new Customer("B", 56));
        Optional<Customer> oldest = custs.stream().max(Comparator.comparing(Customer::getAge));

        System.out.println(oldest.get()); // if more than two matchces, return first

        Supplier<List<Customer>> supplier = ArrayList::new;
        BiConsumer<List<Customer>, Customer> accumulator = List::add;
        BiConsumer<List<Customer>, List<Customer>> combiner = List::addAll;

        custs.stream().collect(supplier, accumulator, combiner);
        custs.stream().collect(Collectors.toCollection(LinkedList::new));

        Map<Integer, Customer> collect = custs.stream().collect(Collectors.toMap(
                Customer::getAge,
                Function.identity(),
                (a, b) -> a.getAge() < a.getAge() ? a : b));

        Map<Integer, List<Customer>> collect1 = custs.stream().collect(Collectors.groupingBy(Customer::getAge));
    }

}
