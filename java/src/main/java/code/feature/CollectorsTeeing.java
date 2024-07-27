package code.feature;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsTeeing {
    public static void main(String[] args) {
        Integer sumOfMinAndMax = Stream.of(1, 2, 3, 4, 5)
                .collect(
                        Collectors.teeing(
                                Collectors.minBy(Integer::compareTo), //downstream1
                                Collectors.maxBy(Integer::compareTo), //downstream2
                                (min, max) -> min.get() + max.get()   // merger BiFunction
                        )
                );

        System.out.println(sumOfMinAndMax);
    }
}
