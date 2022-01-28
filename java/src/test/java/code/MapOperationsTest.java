package code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.counting;

class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + name + ':' + age + '}';
    }
}

public class MapOperationsTest {

    enum AgeGroup {
        KID, TEENAGE, ADULT;

        public static AgeGroup getAgeGroup(Person person) {
            int age = person.getAge();
            if (age < 15) return KID;
            if (age < 20) return TEENAGE;
            return ADULT;
        }
    }

    // key should be group of 5-10,11-15 and list of Person as value
    // https://www.baeldung.com/java-spliterator
    // individual age is easy right
    @Test
    public void testGetYounger() {
        Map<String, Person> namePersonMap = getPeople().stream()
                    .collect(Collectors.toMap(Person::getName, p -> p, MapOperationsTest::getYounger));
    }

    @Test
    public void testCsvNamesOfAdult() {
        String csv = getPeople().stream()
                .filter(p -> p.getAge() > 10)
                .map(p-> p.getName())
                .distinct()
                .collect(Collectors.joining(", "));

        System.out.println("Names in csv: " + csv);
    }

    @Test
    public void testCountingAdult() {
        int total = getPeople().stream()
                .filter(p -> p.getAge() > 10)
                .map(p-> p.getName())
                .distinct() //or directly do .count()
                .collect(Collectors.counting())
                .intValue();

        System.out.println("Count: " + total);
    }

    @Test
    public void testAgeAndListOfNames() {
        Map<Integer, List<String>> ageGroupAndNames = getPeople().stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));

        System.out.println("Age grouping by names: " + ageGroupAndNames);
    }

    @Test
    public void testPartitionBy() {
        Map<Boolean, List<Person>> evenOddPerson = getPeople().stream()
                .filter(p -> p.getAge() > 10)
                .collect(Collectors.partitioningBy(p -> p.getAge() % 2 ==0));

        System.out.println("Even odd age grouping: " + evenOddPerson);
    }

    @Test
    public void testPartitionByEvenAgainstCsv() {
        Map<Boolean, String> evenOddPersonCsv = getPeople().stream()
                .filter(p -> p.getAge() > 10)
                .collect(Collectors.partitioningBy(
                        p -> p.getAge() % 2 ==0,
                        Collectors.mapping(Person::getName, Collectors.joining(", ")))
                );

        System.out.println("Even odd age grouping and csv names: " + evenOddPersonCsv);
    }

    /**
     * Filtering
     */
    @Test
    public void testGroupAndProcessLater() {
        Map<Integer, List<String>> evenOddPersonCsv = getPeople().stream()
                .filter(p -> p.getAge() > 5)
                .collect(
                        Collectors.groupingBy(
                                Person::getAge,
                                Collectors.mapping(
                                        Person::getName,
                                        Collectors.filtering(name -> name.length() > 3, Collectors.toList())
                                )
                        )
                );

        System.out.println("Even odd age grouping and csv names: " + evenOddPersonCsv);
    }

    @Test
    public void testGroupAndTransformLater() {
        Map<Integer, String> ageIntegerCount =  getPeople().stream()
                .collect(
                        groupingBy(Person::getAge, mapping(
                                Person::getName,
                                collectingAndThen(counting(), val -> String.valueOf(val.intValue()))
                        ))
                );

        System.out.println("Even odd age grouping and csv names: " + ageIntegerCount);
    }

    @Test
    public void testAgeSortedCsv() {
        Map<Integer, String> ageSortedCsvNames =  getPeople().stream()
                .collect(groupingBy(
                        Person::getAge,
                        TreeMap::new,
                        mapping(Person::getName, joining(", ")))
                );

        System.out.println("Even odd age grouping and csv names: " + ageSortedCsvNames);
    }

    @Test
    public void testAgeRangeGroup() {
        Map<AgeGroup, String> ageModifiedCsvNames =  getPeople().stream()
                .collect(groupingBy(AgeGroup::getAgeGroup, mapping(Person::getName, joining(", "))));
        System.out.println("Age Grouped: " + ageModifiedCsvNames);

        Map<AgeGroup, List<Person>> collect1 = getPeople().stream()
                .collect(groupingBy(AgeGroup::getAgeGroup));

        Map<AgeGroup, List<String>> collect2 = getPeople().stream()
                .collect(groupingBy(AgeGroup::getAgeGroup, Collectors.mapping(Person::getName, toList())));
    }

    @Test
    public void testNumberToRange() {
        List<List<Integer>> ranged = Stream.iterate(1, e -> e +1)
                .limit(10)
                .map(n -> List.of(n-1, n+1))
                .collect(Collectors.toList());

        System.out.println("Ranged: " + ranged);
    }

    @Test
    public void testNumberToRangeFlattened() {
        List<Integer> ranged = Stream.iterate(1, e -> e +1)
                .limit(10)
                .map(n -> List.of(n-1, n+1))
                .flatMap(l -> l.stream())
                .collect(Collectors.toList());

        System.out.println("Ranged: " + ranged);

        List<Integer> ranged1 = Stream.iterate(1, e -> e +1)
                .limit(10)
                .flatMap(n -> List.of(n-1, n+1).stream())
                .collect(Collectors.toList());

        System.out.println("Ranged: " + ranged1);
    }

    @Test
    public void testNameChars() {
        Map<Integer, Set<String>> collect = getPeople().stream()
                .collect(
                        groupingBy(
                                Person::getAge,
                                mapping(p -> p.getName().toUpperCase(),
                                        flatMapping(name -> Stream.of(name.split("")), toSet())
                                )
                        )
                );

        System.out.println("Age and Chars: " + collect);
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
                new Person("Ian", 15),
                new Person("J", 15),
                new Person("J", 25)
        );
        return people;
    }

}

