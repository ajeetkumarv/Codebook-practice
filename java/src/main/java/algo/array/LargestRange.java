package algo.array;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Largest Range
 * Write a function that takes in an array of integers and returns an array of length 2 representing the largest range of integers contained in that array.
 *
 * The first number in the output array should be the first number in the range, while the second number should be the last number in the range.
 *
 * A range of numbers is defined as a set of numbers that come right after each other in the set of real integers. For instance, the output array [2, 6] represents the range {2, 3, 4, 5, 6}, which is a range of length 5. Note that numbers don't need to be sorted or adjacent in the input array in order to form a range.
 *
 * You can assume that there will only be one largest range.
 */
public class LargestRange {

	public int[] findLargestRange(int[] array) {
		Set<Integer> nums = Arrays.stream(array).boxed().collect(Collectors.toSet());

		int[] range = {array[0], array[0]};
		boolean firstCheckPending = true;


		for (int num: array) {

			if (!firstCheckPending && (num >= array[0] && num <= array[1])) {
				continue;
			}

			firstCheckPending = false;

			int low = num;
			int high = num;
			int[] currentRange = {low, high};

			while(nums.contains(low-1)){
				low--;
			}
			currentRange[0] = low;

			while(nums.contains(high+1)){
				high++;
			}
			currentRange[1] = high;

			if (range[1] - range[0] < currentRange[1] - currentRange[0]){
				range = currentRange;
			}
		}

		return range;
	}
}
