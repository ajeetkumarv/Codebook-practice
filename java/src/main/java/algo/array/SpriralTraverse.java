package algo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Spiral Traverse
 * Write a function that takes in an n x m two-dimensional array (that can be square-shaped when n == m) and returns a one-dimensional array of all the array's elements in spiral order.
 *
 * Spiral order starts at the top left corner of the two-dimensional array, goes to the right, and proceeds in a spiral pattern all the way until every element has been visited.
 *
 * Sample Input
 * array = [
 *   [1,   2,  3, 4],
 *   [12, 13, 14, 5],
 *   [11, 16, 15, 6],
 *   [10,  9,  8, 7],
 * ]
 * Sample Output
 * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
 */
public class SpriralTraverse {

	public static Integer [] method(int [][] matrix) {

		List<Integer> array = new ArrayList<>();

		int rowStart = 0, rowEnd = matrix.length-1;
		int colStart = 0, colEnd = matrix[0].length-1;

		while (rowStart <= rowEnd && colStart <= colEnd) {
			//to right
			for (int col = colStart; col <= colEnd; col++) {
				array.add(matrix[rowStart][col]);
			}

			//to botton
			for (int row = rowStart + 1 ; row <= rowEnd; row++) {
				array.add(matrix[row][colEnd]);
			}
			//to left
			for (int col = colEnd - 1; col >= colStart; col--) {
				if (rowStart == rowEnd) break;
				array.add(matrix[rowEnd][col]);
			}

			//to up
			for (int row= rowEnd-1; row > rowStart;row--) {
				if (colStart == colEnd) break;
				array.add(matrix[row][colStart]);
			}

			rowStart++;
			colStart++;
			rowEnd--;
			colEnd--;
		}

		return array.toArray(Integer[]::new);
	}

	public static void main(String[] args) {
		int[][] matrix = {
				{1,2,3,4},
				{12,13,14,5},
				{11,16,15,6},
				{10,9,8,7}
		};
		int[][] matrix1 = {
				{1,2,3,4},
				{11,12,13,6},
				{10,9,8,7}
		};

		System.out.println(Arrays.toString(method(matrix1)));
	}
}
