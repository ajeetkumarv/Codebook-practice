package code.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonAmong3Lists {

    public static void main(String[] args) {
        int[] first = {1, 5, 10, 20, 40, 80};
        int[] second = {6, 7, 20, 80, 100};
        int[] third = {3, 4, 15, 20, 30, 70, 80, 120};

        //output  = {20, 80}
        List<Integer> commonElements = new ArrayList<>();

        int i = 0, j = 0, k = 0;

        while (true) {
            int firstNum = first[i];
            int secondNum = second[j];
            int thirdNum = third[k];

            if (firstNum == secondNum && secondNum == thirdNum) {
                commonElements.add(firstNum);
                i++;
                j++;
                k++;
            }

            if (!(i < first.length && j < second.length && k < third.length)) {
                break;
            }

            int tryForNum = Integer.max(first[i], Integer.max(second[j], third[k]));

            while( i < first.length && first[i] < tryForNum) {
                i++;
            }
            if (first[i] > tryForNum) tryForNum = first[i]; //Optimization, will work without this also
            while( j < second.length && second[j] < tryForNum) {
                j++;
            }
            if (second[j] > tryForNum) tryForNum = second[j]; //Optimization, will work without this also
            while( k < third.length && third[k] < tryForNum) {
                k++;
            }

        }

        System.out.println("Common elements: " + commonElements);
    }

}
