package code.otherrepo.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;

public class MapOperations {
    public static void main(String[] args) {
        //example 1
        // key should be group of 5-10,11-15 and list of Person as value
        // https://www.baeldung.com/java-spliterator
        // individual age is easy right
        Map<Integer, List<Person>> map = getPeople()
                .stream()
                .collect(Collectors.groupingBy(Person::getAge));

        Map<String, Person> map2 = getPeople()
                .stream()
                //.collect(Collectors.toMap(Person::getName, p -> p, (p1,p2) -> p1.getAge() < p2.getAge() ? p1 : p2));
                .collect(Collectors.toMap(Person::getName, p -> p, MapOperations::getYounger));
                //.collect(Collectors.toMap(Person::getName, p -> p)); // if there is no dupicate name
                //.collect(Collectors.toUnmodifiableMap(Person::getName, p -> p, MapOperations::getYounger));

        //map2.put("N",new Person("H", 1)); This will generate error if using toUnmodifiableMap

        String csvNames = getPeople()
                .stream()
                .filter(p -> p.getAge() > 10)
                .map(Person::getName)
                .map(String::toUpperCase)
                .distinct()
                .collect(Collectors.joining(", "));

        System.out.println("CSV Names: " + csvNames);

        Map<Boolean, List<Person>> evenOddAges = getPeople()
                .stream()
                .collect(Collectors.partitioningBy(p -> p.getAge() % 2 ==0));

        int sum = getPeople().stream().mapToInt(Person::getAge).sum(); // returns primitive int

        /* ---------------------------- */
        Map<Integer, List<String>> ageNames =  getPeople().stream()
                .collect(groupingBy(Person::getAge, mapping(Person::getName, toCollection(LinkedList::new))));

        Map<Integer, List<String>> ageNamesGT4length =  getPeople().stream()
                .collect(
                        groupingBy(
                                Person::getAge,
                                mapping(Person::getName, filtering(name -> name.length()>3, toList()))
                        )
                );

        Map<Integer, String> ageCsvNames =  getPeople().stream()
                .collect(groupingBy(Person::getAge, mapping(Person::getName, joining(", "))));

        Map<Integer, Long> ageCount =  getPeople().stream()
                .collect(groupingBy(Person::getAge, mapping(Person::getName, counting())));



        // What if I want Integer, or any other transformation
        // so String.valueOF AND .intValue represents we can do anything after counting
        Map<Integer, String> ageIntegerCount =  getPeople().stream()
                .collect(
                        groupingBy(Person::getAge, mapping(
                                Person::getName,
                                collectingAndThen(counting(), val -> String.valueOf(val.intValue()))
                        ))
                );

        Map<Integer, String> ageSortedCsvNames =  getPeople().stream()
                .collect(groupingBy(
                        Person::getAge,
                        TreeMap::new,
                        mapping(Person::getName, joining(", ")))
                );

        Map<AgeGroup, String> ageModifiedCsvNames =  getPeople().stream()
                .collect(groupingBy(AgeGroup::getAgeGroup, mapping(Person::getName, joining(", "))));
        System.out.println("Age Grouped: " + ageModifiedCsvNames);

    }

    public enum AgeGroup {
        KID, TEENAGE, ADULT;

        public static AgeGroup getAgeGroup(Person person) {
            int age = person.getAge();
            if (age < 15) return KID;
            if (age < 20) return TEENAGE;
            return ADULT;
        }
    }

    private static Person getYounger(Person p1, Person p2) {
        return p1.getAge() < p2.getAge() ? p1 : p2 ;
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
