package collections.flatmap;

import collections.Person;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.*;

public class FlatMapTest {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1,2,3);

        List<List<Integer>> numsNested = nums.stream().map(e -> List.of(e-1, e+1)).toList();
        System.out.println("One to Many data: " + numsNested);

        List<Integer> flattened = nums.stream().flatMap(e -> List.of(e-1, e+1).stream()).toList();
        System.out.println("Flattened: " + flattened);

        Map<Integer, Set<String>> collect = getPeople().stream()
                .collect(
                        groupingBy(
                                Person::getAge,
                                mapping(
                                        p -> p.getName().toUpperCase(),
                                        flatMapping(
                                                name -> Stream.of(name.split("")),
                                                toSet()
                                        )
                                )
                        )
                );
        System.out.println("output: " + collect);
    }

    private static List<Person> getPeople() {
        List<Person> people = List.of(
                new Person("Anna", 1),
                new Person("Bon", 2),
                new Person("Cute", 5),
                new Person("Din", 6),
                new Person("Elle", 8),
                new Person("Fox", 11),
                new Person("Gough", 12),
                new Person("Hart", 12),
                new Person("Ini", 15),
                new Person("Jem", 15),
                new Person("Jok", 25)
        );
        return people;
    }
}
