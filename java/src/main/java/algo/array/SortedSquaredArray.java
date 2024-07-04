package algo.array;

import java.util.Arrays;

public class SortedSquaredArray {

	public int[] squaredSorted1(int[] arr) {

		int[] sortedSquared = new int[arr.length];

		int leftIdx = 0;
		int rightIdx = arr.length - 1 ;

		for (int idx = arr.length -1; idx > -1 ;idx-- ) {
			int leftSquaredVal = arr[leftIdx] * arr[leftIdx];
			int rightSquaredVal = arr[rightIdx] * arr[rightIdx];

			if (leftSquaredVal >= rightSquaredVal) {
				sortedSquared[idx] = leftSquaredVal;
				leftIdx++;
			} else {
				sortedSquared[idx] = rightSquaredVal;
				rightIdx--;
			}
		}

		return sortedSquared;
	}

	public int[] squaredSorted2(int[] arr) {
		return Arrays.stream(arr)
				.map(e -> e * e)
				.sorted()
				.toArray();
	}
}
