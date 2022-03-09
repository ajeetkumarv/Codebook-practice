package code.problems;

import java.util.HashSet;
import java.util.Set;

public class SubArraySum0 {


    public static void main(String[] args) {
        int[] data = {4, 2, -3, 1, 6};

        Set<Integer> trailingSum = new HashSet<>();
        int sum = 0;
        boolean subArrayexists = false;

        for (Integer item: data) {

            sum = sum + item;

            if (item == 0 || sum == 0 || trailingSum.contains(sum)) {
                subArrayexists = true;
                break;
            } else {
                trailingSum.add(sum);
            }
        }
        System.out.println("Subarray exists: " + subArrayexists);
    }
}
