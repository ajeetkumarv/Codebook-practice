package code.learning;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
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


}
