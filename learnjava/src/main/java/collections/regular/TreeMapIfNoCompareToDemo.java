package collections.regular;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeMapIfNoCompareToDemo {
    public static void main(String[] args) {

        /*
        Exception in thread "main" java.lang.ClassCastException:
        class collections.regular.Fruit cannot be cast to class java.lang.Comparable (collections.regular.
        Fruit is in unnamed module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')
        	 */
        /*
        Comparable on Fruit on Comparator in TreeSet required
         */
        Comparator<Fruit> fCompare;
        Set<Fruit> fruits = new TreeSet<>();
        fruits.add(new Fruit(5));
        fruits.add(new Fruit(4));
        fruits.add(new Fruit(9));

        System.out.println(fruits);
    }
}
