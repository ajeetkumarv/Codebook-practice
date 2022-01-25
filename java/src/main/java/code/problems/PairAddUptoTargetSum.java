package code.problems;

import java.util.HashMap;
import java.util.Map;

public class PairAddUptoTargetSum {

    public static void main(String[] args) {
        int[] data = {1,2,3,7,4,8,5};

        Map<Integer, Integer> complement = new HashMap<>();

        int target = 8;

        for (int n: data) {

            if (!complement.containsKey(n)) {
                complement.put(target - n, n);
            } else {
                System.out.println(n + ", " + complement.get(n));
            }

        }

    }

}
