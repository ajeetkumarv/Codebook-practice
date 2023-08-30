package stream;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperationsTest {
    public static void main(String[] args) {
        Integer total1 = Stream.of(1,2,3,4,5,6)
                .reduce(0, (c, t) -> c + t);

        Integer total2 = Stream.of(1,2,3,4,5,6)
                .reduce(0, Integer::sum);

        System.out.println(total1 + " " + total2);

        List<Customer> custs = Arrays.asList(new Customer("A", 5), new Customer("B", 56));
        Optional<Customer> oldest = custs.stream().max(Comparator.comparing(Customer::getAge));

        Supplier<List<Customer>> supplier = ArrayList::new;
        BiConsumer<List<Customer>, Customer> accumulator = List::add;
        BiConsumer<List<Customer>, List<Customer>> combiner = List::addAll;

        custs.stream().collect(supplier, accumulator, combiner);
        custs.stream().collect(Collectors.toCollection(LinkedList::new));

        custs.stream().collect(Collectors.toMap(
                Customer::getAge,
                Function.identity(),
                (a, b) -> a.getAge() < a.getAge() ? a : b));
        custs.stream().collect(Collectors.groupingBy(Customer::getAge));

    }
}
