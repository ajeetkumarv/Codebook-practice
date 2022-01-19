package code.arraybased;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * [10, 6, 5, 10, 7, 8, 7, 9, 10, 8]
 * Sort the array based on frequency of elements, if freq is same then sort on element value
 *
 */
public class SortOnFrequencyComparator {

    public static void main(String[] args) {
        Integer[] data = {10, 6, 5, 10, 7, 8, 7, 9, 10, 8}; // if it is int[] will cause troupble in IntStream and comparator

        Map<Integer, Integer> elemFreq = toFreqMap(Arrays.stream(data)); //mapToObj bcz IntStream was returned

        Comparator<Integer> comparator = (e1, e2) -> {
            var f1 = elemFreq.get(e1);
            var f2 = elemFreq.get(e2);

            if (f1 != f2)
                return f1 -f2;

            return e2 - e1;
        };

        Arrays.sort(data, comparator);

        System.out.println("Result: " + Arrays.toString(data));

    }

    private static Map<Integer, Integer> toFreqMap(Stream<Integer> data) {
        // returs Long and needs mapToObj also
        //return data.collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        //return data.collect(Collectors.groupingBy(e -> e, Collectors.summingInt(e -> 1)));
        return data.collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
    }

}
