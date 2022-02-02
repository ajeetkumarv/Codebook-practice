package code.problems.matixmaxarea;

public class MaxAreaMatrixDemo {
    public static void main(String[] args) {
        Integer[][] matrix = {
            {0, 1, 1, 0},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0}
        };

        MaxAreaMatrix areaCalculator = new MaxAreaMatrix(matrix);
        System.out.println("Final Area: " + areaCalculator.getMaxArea());
        areaCalculator.showMatrix();
    }
}
