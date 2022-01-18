package code.generics;

import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

interface Fruit {
    void taste();
}

interface Vegetable {
    void taste();
}

class Cucumber implements Fruit, Vegetable {
    public void taste() {

    }
}

class Banana implements Fruit {
    public void taste() {

    }
}

/**
 * https://itnext.io/java-generics-intersection-types-23b2fbdddfbb
 *
 * Intersections type one case case can be you want to put Serializable constraint on element
 * so I'll process a type that is certainly Serializable
 *
 */
public class IntersectionTypeDemo {
    public static void main(String[] args) {
        test(List.of(new Cucumber()));
        //test(List.of(new Banana())); // thisdoesn't work
    }

    /**
     * Only accept elements which are both Fruit and Vegetable
     *
     * @param eatable
     * @param <T>
     */
    static <T extends Fruit & Vegetable> void test(List<T> eatable) {
        //This won't work if Fruit has no SAM
        Fruit fruitForSerialization = (Fruit & Serializable) () -> doEat();
    }

    static void doEat() {
    }
}
