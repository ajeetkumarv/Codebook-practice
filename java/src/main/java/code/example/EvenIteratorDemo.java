package code.example;

import java.util.Iterator;
import java.util.function.Predicate;

class EvenIterator<T> implements Iterator {

    private T[] data;
    private Predicate<T> property;

    private Integer index;

    public EvenIterator(T[] data, Predicate<T> property) {
        this.data = data;
        this.property = property;
        index = -1;
        fixIndex();
    }

    @Override
    public boolean hasNext() {
        return index < data.length;
    }

    @Override
    public T next() {
        T element = data[index];
        fixIndex();
        return element;
    }

    private void fixIndex() {
        index++;

        while(index < data.length && !property.test(data[index])) {
            index++;
        }

    }
}

public class EvenIteratorDemo {

    public static void main(String[] args) {
        Integer[] data = {2,5,6,6,-2, 5, -7, 0, 8,10};

        Iterator<Integer> itr = new EvenIterator(data, (n) -> (Integer)n % 2 ==0);

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

}
