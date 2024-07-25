package code.otherrepo.collections;

import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.maxBy;

public class ComparatorDemo {
    public static void main(String[] args) {

        Optional<Person> oldestPerson = getPeople()
                .stream()
                //.max(Comparator.comparing(Person::getAge))
                .collect(maxBy(comparing(Person::getAge).thenComparing(Person::getName)));
        // if duplicate, first occurred will be considered
        System.out.println("Oldest: " + oldestPerson.get().getName());


        String name = getPeople()
                .stream()
                .collect(collectingAndThen(
                        maxBy(comparing(Person::getAge)),
                        p -> p.map(Person::getName).orElse("Not found"))
                ); // p is Optional<Person> here not person

        System.out.println(">>> " + name);
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
                new Person("K", 25),
                new Person("J", 25)
        );
        return people;
    }
}
