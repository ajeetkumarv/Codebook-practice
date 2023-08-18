package code.feature;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsTeeing {
    public static void main(String[] args) {
        Integer sumOfMinAndMax = Stream.of(1, 2, 3, 4, 5)
                .collect(
                        Collectors.teeing(
                                Collectors.minBy(Integer::compareTo),
                                Collectors.maxBy(Integer::compareTo),
                                (min, max) -> min.get() + max.get()
                        )
                );

        System.out.println(sumOfMinAndMax);
    }
}
