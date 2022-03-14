package code.problems;

import java.util.Arrays;

public class TopNLargestElements {

    public static void main(String[] args) {
        int[] data = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        System.out.println("Result: "
                + Arrays.toString(findThreeLargestNumbers(data)));
    }

    public static int[] findThreeLargestNumbers(int[] array) {
        int n = 2;
        int[] topN = new int[n];

        Arrays.fill(topN, Integer.MIN_VALUE);

        for (int element: array) {
            updateTopN(array, topN, element, n);
        }

        return topN;
    }

    private static void updateTopN(int[] array, int[] topN, int element, int n) {
        for (int i = n - 1; i >= 0; i--) {
            if (topN[i] < element) {
                updateAllTops(element, topN, i);
                break;
            }
        }
    }

    private static void updateAllTops(int element, int[] topN, int rank) {
        for (int i = 0; i < rank; i++) {
            topN[i] = topN[i + 1];
        }
        topN[rank] = element;
    }
}
