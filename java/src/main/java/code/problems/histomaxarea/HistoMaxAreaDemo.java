package code.problems.histomaxarea;

public class HistoMaxAreaDemo {

    public static void main(String[] args) {
        Integer[] data = {6, 2, 5, 4, 5, 1, 6};
        HistogramMaxArea histoArea = new HistogramMaxArea(data);

        System.out.println("Max Area Serial  : " + histoArea.getMaxArea());
        System.out.println("Max Area Parallel: " + histoArea.getMaxAreaParallel());
    }

}
