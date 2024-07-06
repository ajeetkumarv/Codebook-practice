package algo.array;

import java.util.Arrays;

/**
 * Majority Element
 * Write a function that takes in a non-empty, unordered array of positive integers and returns the array's majority element without sorting the array and without using more than constant space.
 *
 * An array's majority element is an element of the array that appears in over half of its indices. Note that the most common element of an array (the element that appears the most times in the array) isn't necessarily the array's majority element; for example, the arrays [3, 2, 2, 1] and [3, 4, 2, 2, 1] both have 2 as their most common element, yet neither of these arrays have a majority element, because neither 2 nor any other element appears in over half of the respective arrays' indices.
 *
 * You can assume that the input array will always have a majority element.
 */
public class MajorityElement {

	/**
	 * sort the array and choose the middle element
	 */
	int method1(int[] arr) {
		Arrays.sort(arr);
		// works only if guaranteed that it does have a mojority element
		return arr[arr.length/2];
	}

	int method2(int[] arr) {
		int answer = arr[0];
		int count = 0;

		for (int num: arr) {
			if (count == 0) { // means previous subarray didn't have majority
				answer = num; // so the current number is new candidate
			}

			if (num == answer) {
				count++;
			} else {
				count--;
			}
		}

		return answer;
	}
}
