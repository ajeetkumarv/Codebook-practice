package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveAnomalyDemo {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>(Arrays.asList(11,22,33,44,55,3,66));

        //point to note is it has 2 remove() methods
        //1 inherited from Collection class that accepts Object
        //2 list interface which accepts primitive integer

        Integer three = Integer.valueOf(3);
        int primitiveThree = 3;

        data.remove(three);//removes the element 3, not at index 3
        System.out.println("Integer list data: " + data);

        data.remove(primitiveThree);//removes the index 3
        System.out.println("Integer list data: " + data);

        List<String> stringData = new ArrayList<>(Arrays.asList("A","B","C","D","E"));
        stringData.remove(three);// here using as index

        System.out.println("String list data: " + stringData);

    }
}
