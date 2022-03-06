package code.problems;

import java.util.Arrays;

public class MergeSort {

    static void mergeSortAndCount(int[] arr, int l, int r) {

        if (l < r) {
            int mid = (l + r ) / 2;
            mergeSortAndCount(arr, l, mid);
            mergeSortAndCount(arr, mid + 1, r);

            merge(arr, l, mid, r);
        }

    }

    private static void merge(int[] arr, int l, int mid, int r) {

        int[] temp = new int[r - l + 1];

        int i = l, j = mid + 1, k=0;

        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i];
                i++;
            } else {
                temp[k++] = arr[j];
                j++;
            }
        }

        while(i <= mid) {
            temp[k++] = arr[i++];
        }

        while(j <= r) {
            temp[k++] = arr[j++];
        }

        k = 0;

        while (l <= r) {
            arr[l++] = temp[k++];
        }
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = { 1, 20, 6, 4, 5 };

        mergeSortAndCount(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}
