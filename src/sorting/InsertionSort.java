package sorting;

import java.util.Arrays;

public class InsertionSort {
    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 7, 2, 3, 6, 8, 9, 0, 1};
        System.out.println("Unsorted Array: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("After Quick Sort: " + Arrays.toString(arr));
    }
}
