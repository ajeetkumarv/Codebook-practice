package code.problems;

public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 20;

        Result result = identifyRow(matrix, target);

        if (result.targetFound) {
            System.out.println("Value found at: " + result.rowIndex + ", " + result.colIndex);
        } else {
            int index = inspectInRow(matrix[result.rowIndex], target);

            if (index == -1) {
                System.out.println("Not Found");
            } else {
                System.out.println("Value found at: " + result.rowIndex + ", " + index);
            }
        }
    }

    private static class Result {
        boolean targetFound; int rowIndex, colIndex;
        Result(boolean targetFound, int rowIndex, int colIndex) {
            this.targetFound = targetFound;
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
        }
    }

    private static Result identifyRow(int[][] matrix, int target) {
        final int FIRST_COLUMN = 0;
        int low = 0, high = matrix.length - 1;

        while(low < high) {
            int mid = (low + high) / 2;
            if (matrix[mid][FIRST_COLUMN] == target) {
                return new Result(true, mid, FIRST_COLUMN);
            }

            if (target < matrix[high][FIRST_COLUMN]) high = mid; else low = mid + 1;
        }

        return new Result(false, low, high);
    }

    private static int inspectInRow(int[] matrixRow, int target) {
        int low = 0, high = matrixRow.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if (matrixRow[mid] == target) {
                return mid;
            }

            if (target < matrixRow[high]) high = mid; else low = mid + 1;
        }

        return -1;
    }

}
