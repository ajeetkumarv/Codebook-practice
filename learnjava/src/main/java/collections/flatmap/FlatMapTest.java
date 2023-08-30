package collections.flatmap;

import collections.Person;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.*;

public class FlatMapTest {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1,2,3);

        List<List<Integer>> numsNested = nums.stream().map(e -> List.of(e-1, e+1)).collect(Collectors.toList());
        System.out.println("One to Many data: " + numsNested);

        List<Integer> flattned = nums.stream().flatMap(e -> List.of(e-1, e+1).stream()).collect(Collectors.toList());
        System.out.println("Flattened: " + flattned);

        getPeople().stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getAge,
                                mapping(p -> p.getName().toUpperCase(),
                                        flatMapping(name -> Stream.of(name.split("")), toSet())
                                )
                        )
                );
    }

    private static List<Person> getPeople() {
        List<Person> people = List.of(
                new Person("A", 1),
                new Person("B", 2),
                new Person("C", 5),
                new Person("D", 6),
                new Person("E", 8),
                new Person("F", 11),
                new Person("G", 12),
                new Person("H", 12),
                new Person("I", 15),
                new Person("J", 15),
                new Person("J", 25)
        );
        return people;
    }
}
