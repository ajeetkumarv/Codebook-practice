package code.problem;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class SegregateNumbers {

    @Test
    public void segregate0And1() {
        int[] data = {0, 1, 0, 1, 1, 1, 0, 0, 1};

        int left = 0, right = data.length -1;

        BiConsumer<Integer, Integer> swap = (l, r) -> {
          int temp = data[l];
          data[l] = data[r];
          data[r] = temp;
        };

        while (left < right) {
            System.out.println(left + " " + right);
            if (data[left] < data[right]) {
                left++;
            } else if (data[left] > data[right]) {
                swap.accept(left, right);
                left++;
                //right--;
            } else if (data[left] == data[right]) {
                right--;
            }
        }


        System.out.println("Data: " + Arrays.toString(data));
    }

    @Test
    public void segregatePositiveAndNegative() {
        int[] data = {10, 1, 20, +6, -5, 11, -10, 40, -1};

        int left = 0, right = data.length -1;

        BiConsumer<Integer, Integer> swap = (l, r) -> {
            int temp = data[l];
            data[l] = data[r];
            data[r] = temp;
        };

        while (left < right) {
            System.out.println(left + " " + right + " " + Arrays.toString(data));

            if (data[left] < 0 && data[right] > 0) {
                left++;
            } else if (data[left] < 0 && data[right] < 0){
                left++;
            } else if (data[left] > 0 && data[right] > 0){
                right--;
            } else {
                swap.accept(left, right);
            }

        }

        System.out.println("Data: " + Arrays.toString(data));
    }

    @Test
    public void segregateByStream() {
        int[] data = {0, 1, 0, 1, 1, 1, 0, 0, 1};

        Map<Boolean, List<Integer>> collect = Arrays.stream(data).boxed()
                .collect(Collectors.partitioningBy(n -> n <= 0));


        System.out.println("Data: " + Arrays.toString(data));
    }

}
