package code.example;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ComparatorDemo {

    public static void main(String[] args) {
        //Way 1
        Optional<Person> person = getPeople().stream()
                .collect(Collectors.maxBy(Comparator.comparing(Person::getAge).thenComparing(Person::getName)));

        System.out.println("Oldest person: " + person.get());

        //Way 2
        String name = getPeople()
                .stream()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Person::getAge)),
                                p -> p.map(Person::getName).orElse("Not Found")
                        )
                );
        System.out.println("Oldest person name: " + name);
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
