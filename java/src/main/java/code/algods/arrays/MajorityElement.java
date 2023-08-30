package code.algods.arrays;

public class MajorityElement {
    public static void main(String[] args) {
        // majority means more than half of elements are that
        int[] array = {1, 2 ,3 ,2 ,2 ,2 ,2, 5, 7};

        int count = 0;
        int answer = array[0];

        for (int value: array) {
            if(count == 0) {
                answer = value;
            }

            if (value == answer) {
                count++;
            } else {
                count--;
            }
        }

        System.out.println(answer);
    }

}
