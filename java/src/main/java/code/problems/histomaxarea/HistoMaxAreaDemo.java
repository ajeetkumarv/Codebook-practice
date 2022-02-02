package code.problems.histomaxarea;

public class HistoMaxAreaDemo {

    public static void main(String[] args) {
        Integer[] data = {6, 2, 5, 4, 5, 1, 6};
        HistogramMaxArea histoArea = new HistogramMaxArea(data);

        System.out.println("Max Area Serial  : " + histoArea.getMaxArea());
        System.out.println("Max Area Reuse  : " + new HistogramMaxArea(data).getMaxAreaReuse());
        System.out.println("Max Area Parallel: " + histoArea.getMaxAreaParallel());

        Integer[] data2 = {6, 2, 4, 5, 4, 5, 1, 6};
        HistogramMaxArea histoArea2 = new HistogramMaxArea(data2);

        System.out.println("Max Area Reuse  : " + histoArea2.getMaxAreaReuse());
    }

}
