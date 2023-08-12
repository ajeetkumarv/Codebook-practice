package code.algods.arrays;

import java.util.Arrays;

public class NonConstructibleChange {
    public static void main(String[] args) {
        System.out.println(findNonConstructibleChange(new int [] {5,7,1,1,2,3,22}));
    }

    private static int findNonConstructibleChange(int [] coins) {
        Arrays.sort(coins);
        int sumOfChange = 0;

        for(int coin: coins) {

            if (coin > sumOfChange + 1) {
                return sumOfChange + 1;
            }

            sumOfChange = sumOfChange + coin;
        }

        return sumOfChange + 1;
    }
}
