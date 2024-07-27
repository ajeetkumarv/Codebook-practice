package code.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.Value;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
class Student {
    private String name;
}

public class UnmodifiableCollections {
    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        data.add("One");
        data.add("Two");

        //These are implemented as nested static class
        data = Collections.unmodifiableList(data);

        System.out.println(data.get(0));

        // All other operations will throw UnsupportedOperationException
        // this
        //data.set(0, "New");

        //BUT the element in the list can be mutated.

        List<Student> students = new ArrayList<>();
        students.add(new Student("Abc"));

        students = Collections.unmodifiableList(students);
        System.out.println("Before: " + students);
        Student s = students.get(0);
        s.setName("Def");
        System.out.println("After: " + students); // will result in Def

        //JAVA 9 onwards List.of returns Unmodifiable collection
    }
}
