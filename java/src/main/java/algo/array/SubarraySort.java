package algo.array;

/**
 * Subarray Sort
 * Write a function that takes in an array of at least two integers and that returns an array of the starting and ending indices of the smallest subarray in the input array that needs to be sorted in place in order for the entire input array to be sorted (in ascending order).
 *
 * If the input array is already sorted, the function should return [-1, -1].
 *
 * Sample Input
 * array = [1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19]
 * Sample Output
 * [3, 9]
 */
public class SubarraySort {

	public int[] method1(int[] array) {
		int minOutOfOrder = Integer.MAX_VALUE;
		int maxOutOfOrder = Integer.MIN_VALUE;

		for (int i = 0; i< array.length ; i++) {
			if (isOutOfOrder(i, array)) {
				minOutOfOrder = Math.min(array[i], minOutOfOrder);
				maxOutOfOrder = Math.max(array[i], maxOutOfOrder);
			}
		}

		if (minOutOfOrder == Integer.MAX_VALUE) {
			return new int[] {-1, -1}; // no out of order elements found
		}

		int minIndex = 0;
		int maxIndex = array.length - 1;

		while (minOutOfOrder >= array[minIndex])
			minIndex++;

		while(maxOutOfOrder <= array[maxIndex])
			maxIndex--;

		return new int[] {minIndex, maxIndex};
	}

	private boolean isOutOfOrder(int i, int[] array) {
		int num = array[i];
		if (i ==0)
			return num > array[i + 1];

		if (i == array.length - 1)
			return num < array[i-1];

		return num > array[i+1] || num < array[i-1];
	}
}
