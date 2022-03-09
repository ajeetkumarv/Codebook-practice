package code.example;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] data = {8, 5, 2, 9, 5, 6, 3};

        int[] result = bubbleSort(data);

        System.out.println("Final " + Arrays.toString(result));


        int[] data2 = {2, 3, 5, 5, 6, 8, 9};

        int[] result2 = bubbleSort(data2);

        System.out.println("Final " + Arrays.toString(result2));
    }

    public static int[] bubbleSort(int[] array) {
        /*
        isAlreadySorted is an optimization that if we did not make any swap that means it is already sorted
         */
        boolean isAlreadySorted = false;
        for (int i=0; i< array.length - 1 && !isAlreadySorted; i++){
            isAlreadySorted = true;
            System.out.println("For index " + i + " ----------");
            for (int j=0; j< array.length-1 - i; j++){
                //System.out.println("For j " + j);
                if (array[j] > array[j+1]) {
                    //System.out.println("swapping " + array[i] + " " + array[j]);
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isAlreadySorted = false;
                }
            }
            System.out.println(Arrays.toString(array));
        }


        return array;
    }

}
