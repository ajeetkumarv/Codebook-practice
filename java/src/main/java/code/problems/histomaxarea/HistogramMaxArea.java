package code.problems.histomaxarea;

/**
 * https://www.youtube.com/watch?v=J2X70jj_I1o&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=7
 */
public class HistogramMaxArea {

    Integer[] data = {6, 2, 5, 4, 5, 1, 6};

    public Integer findAreaForIndex(Integer index) {
        Integer indexForSmallerLeft = findIndexForSmallerLeft(index);
        Integer indexForSmallerRight = findIndexForSmallerRight(index);;

        return indexForSmallerRight - indexForSmallerLeft -1;
    }

    private Integer findIndexForSmallerLeft(Integer index) {

        if (index == 0)
            return -1;

        return 0;
    }

    private Integer findIndexForSmallerRight(Integer index) {

        if (index == data.length -1)
            return data.length;

        return 0;
    }

}
