package code.algods.arrays;

import java.util.*;

/**
 * find if array has pair that add to targetSum
 */
public class TargetSum {

    public static void main(String[] args) {

        int[] withDuplicateNumber = {5, 5, 3, 2};
        System.out.println(Arrays.toString(findPairWithTargetSum(withDuplicateNumber, 10)));

        System.out.println(Arrays.toString(findPairWithTargetSumSortedArrayApproach(withDuplicateNumber, 10)));
    }

    private static int[] findPairWithTargetSum(int[] array, int targetSum) {

        Set<Integer> visited = new HashSet<>();

        for(int current: array) {
            int potentialMatch = targetSum - current;
            if (visited.contains(potentialMatch)) {
                return new int[] {current, potentialMatch};
            } else {
                visited.add(current);
            }
        }

        return new int[0];
    }

    private static Integer[][] findPairWithTargetSumSortedArrayApproach(int[] array, int targetSum) {
        Arrays.sort(array);

        List<Integer[]> pairs = new ArrayList<>();

        for (int i=0, j =array.length - 1; i < j;) {
            int sum = array[i] + array[j];

            if (sum == targetSum) {
                pairs.add(new Integer[] {array[i], array[j]});
                i++;
                j--;
            } else if ( sum < targetSum) {
                i++;
            } else {
                j--;
            }
        }

        return pairs.toArray(new Integer[0][]);
    }

}
