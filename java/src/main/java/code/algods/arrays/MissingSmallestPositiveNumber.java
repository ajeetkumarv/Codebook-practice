package code.algods.arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * find the first missing number > 0 in the array
 *
 */
public class MissingSmallestPositiveNumber {
    public static void main(String[] args) {
        //int[] A = {1,3,6,4,1,2};
        int[] A = {-1, -3};

        Set<Integer> collect = Arrays.stream(A)
                .filter(n -> n > 0)
                .distinct()
                .boxed()
                .collect(Collectors.toSet());

        Integer i1 = Stream.iterate(1, i -> i + 1)
                .filter(n -> !collect.contains(n))
                .findFirst()
                .get();

        System.out.println(i1);
    }
}
