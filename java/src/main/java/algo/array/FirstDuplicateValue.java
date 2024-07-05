package algo.array;

/**
 * First Duplicate Value
 * Given an array of integers between 1 and n, inclusive, where n is the length of the array, write a function that returns the first integer that appears more than once (when the array is read from left to right).
 *
 * In other words, out of all the integers that might occur more than once in the input array, your function should return the one whose first duplicate value has the minimum index.
 *
 * If no integer appears more than once, your function should return -1.
 *
 * Note that you're allowed to mutate the input array.
 */
public class FirstDuplicateValue {

	public int firstDuplicate(int[] arr) {
		for (int n: arr) {
			int absValue = Math.abs(n);
			if (arr[absValue - 1] < 0) return absValue;

			arr[absValue - 1] = arr[absValue - 1] * -1;
		}

		return -1;
	}
}
