package code.algods.arrays;

import java.util.Arrays;

public class SortedSquaredArray {
    public static void main(String[] args) {
        Integer[] arr = {-5, -2, 1, 4, 8};

        System.out.println("Original" + Arrays.toString(arr));
        System.out.println(Arrays.toString(sortedSqArrayWithStreams(arr)));
        System.out.println(Arrays.toString(sortedSqArrayTwoPointer(arr)));
    }

    public static Integer[] sortedSqArrayWithStreams(Integer[] arr) {
        return Arrays.stream(arr)
                .map(n -> n * n)
                .sorted()
                .toArray(Integer[]::new);
    }

    public static Integer[] sortedSqArrayTwoPointer(Integer[] arr) {
        Integer[] squared = new Integer[arr.length];

        int left = 0, right = arr.length - 1;

        for (int i = right; i > -1; i--) {
            if (Math.abs(arr[left]) > Math.abs(arr[right])) {
                squared[i] = arr[left] * arr[left];
                left++;
            } else {
                squared[i] = arr[right] * arr[right];
                right--;
            }
        }

        return squared;
    }
}
