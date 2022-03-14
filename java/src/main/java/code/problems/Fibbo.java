package code.problems;

public class Fibbo {

    public static void main(String[] args) {
        //find nth fibo number
    }

    private static int best(int n) {

        if (n == 1) return 0;
        if (n == 2) return 1;

        int[] firstTwo = {0, 1};
        int count = 3;
        while (count <= n) {
            int third = firstTwo[0] + firstTwo[1];

            firstTwo[0] = firstTwo[1];
            firstTwo[1] = third;

            count++;
        }

        return firstTwo[1];
    }
}
