package code.problems;

import java.util.HashMap;
import java.util.Map;

public class PairAddUptoTargetSum {

    public static void main(String[] args) {
        //printPairs();
        countPairs();
    }

    private static void printPairs() {
        int[] data = {1,2,3,7,4,8,5};
        Map<Integer, Integer> complement = new HashMap<>();

        int target = 8;

        for (int n: data) {

            if (!complement.containsKey(n)) {
                complement.put(target - n, n);
            } else {
                System.out.println(n + ", " + complement.get(n));
                complement.put(complement.get(n), n);
            }

        }
    }

    private static void countPairs() {
        int[] data = {1, 5, 7, 1};

        int targetSum = 6;
        int pairCount = 0;

        Map<Integer, Integer> complement = new HashMap<>();

        for (Integer item: data) {
            if (!complement.containsKey(item)) {
                complement.put(targetSum - item, item);
            } else {
                pairCount++;
                complement.put(complement.get(item), item);
            }
        }

        System.out.println("Count of pairs: " + pairCount);

    }

}
