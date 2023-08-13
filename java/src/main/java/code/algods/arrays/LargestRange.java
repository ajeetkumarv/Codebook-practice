package code.algods.arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LargestRange {
    /**
     * In an unsorted array, find the largest range bounds.
     * eg. in [1,11,3,0,15,5,2,4,10,7,12,6], largest range is [0,7] => all values from 0 to 7 are present in array.
     */
    public static void main(String[] args) {

        int[] numbers = {1,11,3,0,15,5,2,4,10,7,12,6};

        int[] theLargestRange = findTheLargestRange(numbers);
        System.out.println(Arrays.toString(theLargestRange));
    }

    private static int[] findTheLargestRange(int[] numbers) {

        Set<Integer> numberStore = Arrays.stream(numbers).boxed().collect(Collectors.toSet());

        int[] range = null;
        int maxRangeSize = -1; // bcz if array has just 2 element pair 1-1 = 0 will fail in range check

        for (int n: numbers) {

            if (range != null && n >= range[0] && n <= range[1]) {
                continue;
            }

            int leftNum = n - 1;
            int rightNum = n + 1;

            while(numberStore.contains(leftNum)) {
                leftNum--;
            }
            while(numberStore.contains(rightNum)) {
                rightNum++;
            }

            //adjust bounds
            leftNum++;
            rightNum--;

            if (maxRangeSize < rightNum - leftNum) {
                maxRangeSize = rightNum - leftNum;
                range = new int[]{leftNum, rightNum};
            }
        }

        System.out.println("Max range: " + maxRangeSize);

        return range;
    }
}
