package code.problems.slidingwindow;

import java.util.*;

public class SmallestSubarrayOfTargetValue {

    public static void main(String[] args) {

        int[] input = {1,2,1,2,3,7,2,3,4};
        int[] output = find(input, 5);
        System.out.println("Result: " + Arrays.toString(output));

    }

    private static int[] find(int[] input, int target) {
        int[] output = new int[0];
        Queue<Integer> trails = new LinkedList<>();
        int trailingSum = 0;

        for (int n: input) {
            if (n == target || trailingSum == target) {
                System.out.println("Possible subarray: " + trails);

                if (output.length == 0 || output.length > trails.size()) {
                    output = trails.stream().mapToInt( i -> i).toArray();
                }

                Integer num = trails.poll();
                trailingSum = trailingSum - num;
            }

            trailingSum += n;
            trails.add(n);

            if (trailingSum > target) {
                Integer num = trails.poll();
                trailingSum = trailingSum - (num == null ? 0 : num);
            }
        }

        return output;
    }

}
