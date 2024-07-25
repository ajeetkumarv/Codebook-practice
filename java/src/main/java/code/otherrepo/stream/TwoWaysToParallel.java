package code.otherrepo.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TwoWaysToParallel {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(1,2,3,4,5);
        test(data.stream());
        test(data.parallelStream());
        test(data.stream().parallel());

    }

    private static void test(Stream<Integer> stream) {}
}
