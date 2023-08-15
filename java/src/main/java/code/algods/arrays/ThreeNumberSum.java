package code.algods.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {
    public static void main(String[] args) {
        int[] array = {12, 3, 1, 2, -6, 5, -8, 6};
        int targetSum = 0;

        Arrays.sort(array);
        System.out.println("Sorted: " + Arrays.toString(array));
        List<Integer[]> tripletsThatSumToTarget = new ArrayList<>();

        for (int i=0;i<array.length-2;i++) {

            int left = i+1, right=array.length - 1;

            while (left < right) {
                int sum = array[i] + array[left] + array[right];
                if (sum == targetSum) {
                    tripletsThatSumToTarget.add(new Integer[] {array[i], array[left], array[right]});
                }

                if (sum < targetSum) {
                    left++;
                } else {
                    right--;
                }
            }

        }

        tripletsThatSumToTarget.stream().forEach(intArray -> System.out.println(Arrays.toString(intArray)));
    }
}
