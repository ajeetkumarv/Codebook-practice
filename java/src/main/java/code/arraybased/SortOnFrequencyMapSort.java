package code.arraybased;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * [10, 6, 5, 10, 7, 8, 7, 9, 10, 8]
 * Sort the array based on frequency of elements, if freq is same then sort on element value
 *
 */
public class SortOnFrequencyMapSort {

    public static void main(String[] args) {
        Integer[] data = {10, 6, 5, 10, 7, 8, 7, 9, 10, 8}; // if it is int[] will caue

        Map<Integer, Integer> elemFreq = toFreqMap(Arrays.stream(data)); //mapToObj if IntStream was returned
        var elemFreqSorted = elemFreq.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        List<Integer> finalData = new ArrayList<>();
        //reproducing by extending
        for (Map.Entry<Integer, Integer> entry: elemFreqSorted.entrySet()) {
            for (int i=0;i< entry.getValue();i++) {
                finalData.add(entry.getKey());
            }
        }

        System.out.println("Result: " + finalData);


        var values = elemFreq.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .map(entry -> replicate(entry.getValue(), entry.getKey()))
                .flatMap(v -> v.stream())
                .collect(Collectors.toList());

        System.out.println("Using flat map" + values);

    }

    private static List<Integer> replicate(int times, int number) {
        List<Integer> result = new ArrayList<>();

        for (int i=0;i< times;i++) {
            result.add(number);
        }

        return result;
    }

    private static Map<Integer, Integer> toFreqMap(Stream<Integer> data) {
        // returs Long and needs mapToObj also
        //return data.collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        //return data.collect(Collectors.groupingBy(e -> e, Collectors.summingInt(e -> 1)));
        return data.collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
    }

}
