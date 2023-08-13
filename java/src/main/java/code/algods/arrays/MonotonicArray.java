package code.algods.arrays;

public class MonotonicArray {
    public static void main(String[] args) {
        boolean monotonic = isMonotonic(new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001});
        System.out.println(monotonic);

        boolean monotonic2 = isMonotonic2(new int[]{1, 5, 10, 1100, 1100, 1101, 1102, 9001});
        System.out.println(monotonic2);
    }

    private static boolean isMonotonic2(int[] array) {
        boolean increaseMaintained = true;
        boolean decreaseMaintained = true;

        if (array.length <= 2) return true;

        for (int i = 1; i< array.length ;i++) {
            /*if (array[i] > array[i-1])
                decreaseMaintained = false;

            if (array[i] < array[i-1])
                increaseMaintained = false;*/

            decreaseMaintained = decreaseMaintained && array[i] <= array[i-1];
            increaseMaintained = increaseMaintained && array[i] >= array[i-1];
        }

        return increaseMaintained || decreaseMaintained;
    }

    private static boolean isMonotonic(int[] array) {
        if (array.length <= 2) {
            return true;
        }

        int tone = array[1] - array[0];

        for (int i = 2; i < array.length ;i++) {

            if (tone == 0) {
                tone = array[i] - array[i-1];
                continue;
            }

            int diff = array[i] - array[i-1];

            if (diff == 0 || (tone > 0 ? diff > 0 : diff < 0)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}
