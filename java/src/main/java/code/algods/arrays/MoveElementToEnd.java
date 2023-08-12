package code.algods.arrays;

import java.util.Arrays;
import java.util.function.Supplier;

public class MoveElementToEnd {
    public static void main(String[] args) {
        // perform this in place,i.e. mutate the array
        Supplier<int[]> elements = () -> new int[] {5, 2, 1, 2, 2, 2, 3, 4, 2};

        int toMove = 2;

        System.out.println(Arrays.toString(moveElementWithOrder(elements.get(), toMove)));
        System.out.println(Arrays.toString(moveElementWithoutOrder(elements.get(), toMove)));
        System.out.println(Arrays.toString(moveElementWithoutOrderOptimized(elements.get(), toMove)));
    }

    /**
     * maintains order of other elements
     */
    private static int[] moveElementWithOrder(int[] elements, int toMove) {
        int left = 0, right = left + 1;

        if (elements.length == 1) return elements;

        while (right < elements.length) {
            if (elements[left] == toMove && elements[right] != toMove) {
                elements[left] = elements[right];
                elements[right] = toMove;
                left++;
            }

            if (elements[left] != toMove) {
                left++;
            }

            right++;
        }


        return elements;
    }

    /**
     * Order not important
     */
    private static int[] moveElementWithoutOrder(int[] elements, int toMove) {

        int left = 0, right = elements.length - 1;

        while(left < right) {
            if (elements[right] == toMove) {
                right--;
                continue;
            }

            if (elements[left] != toMove) {
                left++;
                continue;
            }

            elements[left] = elements[right];
            elements[right] = toMove;
            left++;
            right--;
        }

        return elements;
    }

    /**
     * Order not important
     */
    private static int[] moveElementWithoutOrderOptimized(int[] elements, int toMove) {

        int left = 0, right = elements.length - 1;

        while(left < right) {
            while(left < right && elements[right] == toMove) {
                right--;
            }

            if (elements[left] == toMove) {
                elements[left] = elements[right];
                elements[right] = toMove;
            }

            left++;
        }

        return elements;
    }
}
