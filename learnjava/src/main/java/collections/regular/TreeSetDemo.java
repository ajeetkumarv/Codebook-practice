package collections.regular;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@Data
@AllArgsConstructor
class Fruit implements Comparable<Fruit> {
    private int weight;

    @Override
    public int compareTo(Fruit o) {
        return this.weight < o.weight ? -1 : 1;
    }
}

public class TreeSetDemo {
    public static void main(String[] args) {

        /*
        Exception in thread "main" java.lang.ClassCastException:
        class collections.regular.Fruit cannot be cast to class java.lang.Comparable (collections.regular.
        Fruit is in unnamed module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')
        	 */
        /*
        Comparable on Fruit on Comparator in TreeSet required
         */
        Comparator<Fruit> fCompare = Comparator.comparing(Fruit::getWeight);
        Set<Fruit> fruits = new TreeSet<>(); // either Fruit should be Comparable or we supply a Comparator
        fruits.add(new Fruit(10));
        fruits.add(new Fruit(5));
        fruits.add(new Fruit(4));
        fruits.add(new Fruit(9));

        System.out.println(fruits);
    }
}
