package code.problems;

import java.util.Arrays;

public class MinimumUnfairnessChocolateBag {

    public static void main(String[] args) {
        int[] data = {3, 4, 1, 9, 56, 7, 9, 12};
        int m = 5;

        Arrays.sort(data);

        int start = 0, end = m - 1; // window of m elements
        int minUnfairness = data[end] - data[start]; // max possible diff in set

        while (end < data.length) {
            int diff = data[end] - data[start];
            if (minUnfairness > diff) {
                minUnfairness = diff;
            }

            start++;
            end++;
        }

        System.out.println("Minimum unfairness: " + minUnfairness);
    }
}
