package algo.array;

import java.util.Arrays;

/**
 * Smallest Difference
 * Write a function that takes in two non-empty arrays of integers, finds the pair of numbers (one from each array) whose absolute difference is closest to zero, and returns an array containing these two numbers, with the number from the first array in the first position.
 *
 * Note that the absolute difference of two integers is the distance between them on the real number line. For example, the absolute difference of -5 and 5 is 10, and the absolute difference of -5 and -4 is 1.
 *
 * You can assume that there will only be one pair of numbers with the smallest difference.
 */
public class SmallestDiff {

	private int[] first, second;

	public SmallestDiff(int[] first, int[] second) {
		this.first = first;
		this.second = second;
	}

	public static void main(String[] args) {
		int[] first = {-1, 5, 10,20,28,3};
		int[] second = {26,134,135,15,17};

		first = new int[] {1, 5, 10, 20, 28, 3};
		second = new int[] {26, 134, 135, 15, 17};
		SmallestDiff sd = new SmallestDiff(first, second);

		System.out.println(Arrays.toString(sd.findPair()));
	}

	public int[] findPair() {
		Arrays.sort(first);
		Arrays.sort(second);

		int[] closestPair = {first[0], second[0]};
		int smallestGap = Integer.MAX_VALUE;
		int i = 0, j = 0;


		while(i < first.length && j < second.length) {
			int firstNum = first[i];
			int secondNum = second[j];
			int currentGap = 0;

			if (firstNum < secondNum) {
				currentGap = secondNum - firstNum;
				i++;
			} else if (firstNum > secondNum) {
				currentGap = firstNum - secondNum;
				j++;
			} else {
				return new int[] {firstNum, secondNum};
			}

			if (smallestGap > currentGap) {
				smallestGap = currentGap;
				closestPair = new int[]  {firstNum, secondNum};
			}
		}

		return closestPair;
	}
}
