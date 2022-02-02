package code.problems.matixmaxarea;

import code.problems.histomaxarea.HistogramMaxArea;

import java.util.Arrays;

public class MaxAreaMatrix {

    private Integer[][] matrix;

    public MaxAreaMatrix(Integer[][] matrix) {
        this.matrix = matrix;
    }

    public Integer getMaxArea() {
        Integer max = -1;

        Integer[] histo = new Integer[matrix[0].length];
        Arrays.fill(histo, 0);

        for (int i=0;i < matrix.length; i++) {

            for(int k = 0;k< matrix[i].length; k++) {
                histo[k] = matrix[i][k] == 0 ? 0 : histo[k] + matrix[i][k];
            }

            HistogramMaxArea histogramMaxArea = new HistogramMaxArea(histo);
            Integer maxArea = histogramMaxArea.getMaxArea();

            if (max < maxArea) {
                max = maxArea;
            }
        }

        return max;
    }

    public void showMatrix() {
        for (int i=0; i< matrix.length;i++) {
            for (int j=0;j < matrix[i].length;j++) {
                System.out.print("\t" + matrix[i][j]);
            }
            System.out.println();
        }
    }

}
