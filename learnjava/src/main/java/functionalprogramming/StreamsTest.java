package functionalprogramming;

import java.util.Arrays;
import java.util.List;

/**
 * Java 8 Language Capabilities, What's in it for you?
 * https://www.youtube.com/watch?v=j9nj5dTo54Q&t=1594s
 */
public class StreamsTest {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(1,2,3,4,5);

        int total1 = imperativeWay(data);
        int total2 = functionalWay(data);
        int total3 = functionalWay2(data);

        System.out.println("Total 1: " + total1);
        System.out.println("Total 2: " + total2);
        System.out.println("Total 3: " + total3);

        //you can create parallel stream in two ways
        // 1. data.parallelStream()
        // 2. data.stream().parallel()
        // Foundit here: https://www.youtube.com/watch?v=15X0qFtBqiQ&list=WL&index=1
        // Functional Programming with Java 8 by Venkat Subramaniam
            

    }

    private static int imperativeWay(List<Integer> data) {
        int total = 0;
        //this is doing lot mutation hence bad practice
        for(int i=0;i< data.size();i++) {
            total += i * 2;
        }

        return total;
    }

    /**
     * this code is easy to parallelize
     * no risk of mutation
     * @param data
     * @return
     */
    private static int functionalWay(List<Integer> data) {
        return data
            .stream()
            .map(e -> e * 2)
            //for two number perform c + e operation
            //ie to reduce 10 numbers, the relation between two nums is +
            //ie. BinaryOperator ie. take two give one
            .reduce(0, (c, e) -> c + e);
    }

    private static int functionalWay2(List<Integer> data) {
        return data
            .stream()
            .mapToInt(e -> e * 2) // gives you IntStream
            .sum();
    }
    
}
