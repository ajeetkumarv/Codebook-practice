package code.example.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Java 8 Language Capabilities, What's in it for you?
 * https://www.youtube.com/watch?v=j9nj5dTo54Q&t=1594s
 */
public class StreamIntOperationsDemo {

    public static void main(String[] args) {

        System.out.println(Stream.of(1,2,3,4,5,6,7)
                .mapToInt(n -> n * 2)
                .sum()
        );

        //for two number perform c + e operation
        //ie to reduce 10 numbers, the relation between two nums is +
        //ie. BinaryOperator ie. take two give one
        System.out.println(Stream.of(1,2,3,4,5, 6, 7)
                .map(n -> n * 2)
                .reduce(0, (a, b) -> a + b)
        );

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

        Integer total1 = Stream.of(1,2,3,4,5,6).reduce(0, (c, t) -> c + t);
        Integer total2 = Stream.of(1,2,3,4,5,6).reduce(0, Integer::sum);
    }

}
