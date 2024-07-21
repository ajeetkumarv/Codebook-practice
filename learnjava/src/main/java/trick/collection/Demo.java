package trick.collection;

import java.util.HashSet;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        Set<Person> s = new HashSet<>();
        s.add(new Person("A","B"));
        s.add(new Person("A","B"));

        System.out.println(s.size());

        Set rawSet = s;
        Set raw2 = new HashSet();
        s = raw2;


    }
}
