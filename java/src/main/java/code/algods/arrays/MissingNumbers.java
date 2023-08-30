package code.algods.arrays;

public class MissingNumbers {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3};
        int total = 0;
        for (int i=1;i<nums.length+ 3;i++) {
            total += i;
        }

        System.out.println("Sequence total: " + total);

        for (int i: nums)
            total = total - i;

        System.out.println("Avg of missing nums: " + (total/2));

        int avgMissingValue = (total)/2;

        int foundFirstHalf = 0;
        int foundSecondHalf = 0;

        for (int num: nums) {
            if (num <= avgMissingValue) {
                foundFirstHalf = foundFirstHalf + num;
            } else {
                foundSecondHalf = foundSecondHalf + num;
            }
        }

        int expFirstHalf = 0;
        int expSecondHalf = 0;

        for (int i = 1;i<= avgMissingValue;i++) {
            expFirstHalf = expFirstHalf + i;
        }

        for (int i = avgMissingValue + 1; i< nums.length + 3; i++) {
            expSecondHalf = expSecondHalf + i;
        }

        System.out.println(expFirstHalf - foundFirstHalf);
        System.out.println(expSecondHalf - foundSecondHalf);
    }
}
