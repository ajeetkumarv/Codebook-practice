package code.arraybased;

import java.util.LinkedList;
import java.util.Queue;

public class MovingWindowAverage {

    static int windowSize = 4;
    static float sum = 0f;
    static Queue<Integer> elemQueue = new LinkedList<>();

    public static void main(String[] args) {
        Integer[] data = {1,2,3,4,5,6,7,8,9};

        for (Integer d: data) {
            addElement(d);
            System.out.println(average());
        }
    }

    static float average() {
        System.out.println(" Sum " + sum);
        return sum / windowSize;
    }

    static void addElement(Integer element) {
        System.out.print ("Adding: " + element);
        elemQueue.add(element);
        if (elemQueue.size() > windowSize) {
            Integer elem = elemQueue.poll();
            sum = sum - elem;
            System.out.print("Removing: " + elem);
        }

        sum = sum + element;
    }

}
