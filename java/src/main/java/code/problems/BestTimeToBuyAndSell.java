package code.problems;

public class BestTimeToBuyAndSell {

    public static void main(String[] args) {
        int[] data = {7, 1, 5, 3, 6, 4};

        int profit = 0;

        int buyIndex = 0;
        int currIndex = 1;
        int sellIndex = 0;

        while(currIndex < data.length) {

            if (data[currIndex] < data[buyIndex]) {
                buyIndex = currIndex;
            }

            int currProfit = data[currIndex] - data[buyIndex];
            if (currProfit > profit) {
                profit = currProfit;
                sellIndex = currIndex;
            }

            currIndex++;
        }

        System.out.println("Profit: " + profit + " at " + buyIndex + " & " + sellIndex);
    }

}
