package code.example.stream;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String firstName, lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

public class MapOperationsDemo {

    public static void main(String[] args) {
        List<Employee> emps = List.of(
                new Employee("C","c"),
                new Employee("A","d"),
                new Employee("B","b"),
                new Employee("A","a"));

        Comparator<Employee> comp = Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName);

        List<Employee> sortedEmp = emps.stream()
                .sorted(comp)
                .collect(Collectors.toList());

        System.out.println(sortedEmp);


        List<String> data  = List.of("A","B","A","A","C","B","D","C");

        var counted = data
                .stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                //.collect(Collectors.maxBy((o1, o2) -> o2.getValue().intValue()));
                .collect(Collectors.maxBy(Map.Entry.comparingByValue()));
        System.out.println(counted);

        String a = null;
        //Without brackets it will concat first and then test for instanaceof
        System.out.println("a instanceof String: " + (a instanceof String));

        Map<String, String> m = new HashMap<>();
        m.put(null, "A");
        System.out.println(m);

        Set<String> set = new HashSet<>();
        set.add(null);
        System.out.println(set);

    }

}
