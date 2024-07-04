package algo.array;

/**
 * Validate Subsequence
 * Given two non-empty arrays of integers, write a function that determines whether the second array is a subsequence of the first one.
 *
 * A subsequence of an array is a set of numbers that aren't necessarily adjacent in the array but that are in the same order as they appear in the array. For instance, the numbers [1, 3, 4] form a subsequence of the array [1, 2, 3, 4], and so do the numbers [2, 4]. Note that a single number in an array and the array itself are both valid subsequences of the array.
 *
 * Sample Input
 * array = [5, 1, 22, 25, 6, -1, 8, 10]
 * sequence = [1, 6, -1, 10]
 * Sample Output
 * true
 */
public class ValidateSequence {
	//

	public boolean validate1(int[] array, int[] sequence) {

		int i = 0;

		for (int element: array) {
			int lookoutElement = sequence[i];

			if (lookoutElement == element) {
				i++;
			}

			if (sequence.length == i)
				break;
		}

		return i == sequence.length;
	}

	public boolean validate2(int[] array, int[] sequence) {

		int idxArry = 0;
		int idxSeq = 0;

		while (idxArry < array.length && idxSeq < sequence.length) {
			if (array[idxArry] == sequence[idxSeq]) {
				idxSeq++;
			}
			idxArry++;
		}

		return idxSeq == sequence.length;
	}
}
