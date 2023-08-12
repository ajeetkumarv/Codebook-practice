package code.algods.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * it's guaranteed that number will be 1..n and n will be length of the array.
 */
public class FirstDuplicateValue {
    public static void main(String[] args) {
        System.out.println(findFirstDuplicate(new int[] {2,1,5,2,3,3,4}));
        System.out.println(simpleSetSolution(new int[] {2,1,5,2,3,3,4}));
    }

    private static int findFirstDuplicate(int[] nums) {
        for (int i=0; i< nums.length; i++) {
            int num = nums[i];
            // -1 because we know num can not be greater than nums.length bcz of problem stmt.
            if (nums[Math.abs(num) -1] < 0) { // <0 implies -ve number, that was set -ve last time num pointed to this index
                return num;
            } else {
                nums[Math.abs(num) -1] *= -1; // make the number -ve
            }
        }

        return -1;
    }

    private static int simpleSetSolution(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num: nums) {
            if (seen.contains(num))
                return num;

            seen.add(num);
        }

        return -1;
    }

}
