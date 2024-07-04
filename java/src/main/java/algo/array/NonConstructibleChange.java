package algo.array;

import java.util.Arrays;

/**
 * Given an array of positive integers representing the values of coins in your possession, write a function that returns the minimum amount of change (the minimum sum of money) that you cannot create. The given coins can have any positive integer value and aren't necessarily unique (i.e., you can have multiple coins of the same value).
 *
 * For example, if you're given coins = [1, 2, 5], the minimum amount of change that you can't create is 4. If you're given no coins, the minimum amount of change that you can't create is 1.
 */
public class NonConstructibleChange {

	public int method1(int[] arr) {
		Arrays.sort(arr);
		int sumOfCoins = 0;

		for (int num: arr) {
			if (num > sumOfCoins + 1) {
				return sumOfCoins + 1;
			}

			sumOfCoins = sumOfCoins + num;
		}

		return sumOfCoins + 1;
	}
}
