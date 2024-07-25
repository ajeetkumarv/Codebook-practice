package code.otherrepo.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AddToNewListDemo {
    public static void main(String[] args) {
        List<Integer> data = IntStream.rangeClosed(0,10)
                .filter(n -> n%2 ==0)
                .boxed() // because that was IntStream, making it Stream
                .reduce(
                        new ArrayList<Integer>(),
                        (list, d) -> { list.add(d); return list;},
                        (list1, list2) -> { list1.addAll(list2); return list1; }
                );
        System.out.println("Using reduce: " + data);

        List<Integer> data2 = IntStream.rangeClosed(0,10)
                .filter(n -> n%2 ==0)
                .boxed() // because that was IntStream, making it Stream
                .collect(Collectors.toList());
        System.out.println("Using toList: " + data2);
    }
}
