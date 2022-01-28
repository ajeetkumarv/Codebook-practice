package code.learning;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamExamples {

    @Test
    public void summint() {
        int[] nums = {4,1,13,19, 16, 2, -2};

        //getAsInt may throw NoSuchElementException is array empty
        Assertions.assertEquals(-2, IntStream.of(nums).min().getAsInt());
    }

    @Test
    public void summary() {
        int[] nums = {4,1,13,19, 16, 2, -2};
        IntSummaryStatistics stats = IntStream.of(nums).summaryStatistics();
        //stats.accept(); this will update the min, max, and sum
    }

    @Test
    public void createCopyOfArray() {
        int[] nums = {4,1,13,19, 16, 2, -2};
        int[] copy= Arrays.copyOf(nums, nums.length);
        int[] copy2 = IntStream.of(nums).toArray();

        String data = Arrays.stream(nums)
                .mapToObj(n -> String.valueOf(n))
                .collect(Collectors.joining(","));

        System.out.println(data);
    }

    @Test
    public void createStreams() {
        int[] nums = {4,1,13,19, 16, 2, -2};
        IntStream.of(nums);
        IntStream.range(1, 101);
        IntStream.rangeClosed(1, 100);

        IntSupplier is = () -> 5;

        IntStream.generate(is);
    }

    @Test
    public void distinctThreeNums() {
        int[] nums = {4,1,13,19, 16, 2, -2};

        IntStream.of(nums)
                .distinct()
                .sorted()
                .limit(3)
                .skip(1) // skip first number
                .forEach(System.out::println);

    }

    @Test
    public void productOfEvenOnlyUsingReduce() {

        //reduce operation should be
            //Stateleess
            //non interfering
            //Associative 10*(2*3) = (10*2)*3

        int[] nums = {4,1,13,19, 8, 2, -2};

        // if we give empty array it returns identity
        int productOfEvens = IntStream.of(nums)
                .reduce(1, (a, b) -> b % 2 == 0 ? a * b : a);

        Assertions.assertEquals(-128, productOfEvens);

        // if we give empty array then it's empty optional
        int[] oneElement = {2};

        //This works because a holds the current result and b holds the next element, as explained earlier.
        OptionalInt productOfEvensOptional = IntStream.of(oneElement)
                .reduce((a, b) -> b % 2 == 0 ? a * b : a);

        Assertions.assertEquals(2, productOfEvensOptional);

    }

    @Test void reduceThirdVersion() {
        int[] nums = {4,1,25,9};

        double productOfSqrRoots2 = IntStream.of(nums)
                .boxed()
                .parallel()
                .reduce(1.0,
                    (a, b) -> a * Math.sqrt(b), // accumulator
                    (a, b) -> a * b); // combiner
        Assertions.assertEquals(30, productOfSqrRoots2);
    }


    @Test
    public void test() {

        List<Integer> inputList = List.of(2,5,4,6,8);

        System.out.println(inputList.stream()
                .collect(Collectors.groupingBy(s -> (s)/3))
                .values());
    }

}
