package code.problems.slidingwindow;

public class SlidingWindowWithoutQueue {

    private int window;
    private int sum;
    private int max;

    int i = 0, j = 0;

    private final int[] data;

    private SlidingWindowWithoutQueue(int[] data, int windowSize) {
        this.data = data;
        this.window = windowSize;
    }

    public int getMaxSumInSumArray() {

        max = -1;

        while (j < data.length) {
            System.out.println("Adding " + data[j] + " at " + j);
            sum = sum + data[j];

            if (max < sum) {
                System.out.println("new max: " + sum);
                max = sum;
            }

            if (j - i + 1 == window ) {
                System.out.println("Removing " + data[i] + " at " + i);
                sum = sum - data[i];
            }

            if (j >= window - 1) {
                System.out.println("Locked: " + i);
                i++;
            }

            j++;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 9, 1, 11, 20, 7, 3, 9};
        SlidingWindowWithoutQueue queue = new SlidingWindowWithoutQueue(data, 4);
        System.out.println(queue.getMaxSumInSumArray());
    }

}
