package sorting;

import java.util.Arrays;

public class SelectionSort {
    static void selectionSort(int[] arr, boolean stable) {
        // Complexity: O(N^2)
        for (int i = 0; i < arr.length; i++) {

            // find minimum element in the array
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[minIdx])
                    minIdx = j;

            int minVal = arr[minIdx];
            if (stable) {  // shift the elements to the right
                while (minIdx > i) {
                    arr[minIdx] = arr[minIdx - 1];
                    minIdx--;
                }
            } else {  // swap the minimum element with the current element
                arr[minIdx] = arr[i];
            }
            arr[i] = minVal;  // insert the minimum element at the correct position
        }
    }

    static void selectionSort(int[] arr) {
        selectionSort(arr, false);
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 3, 6, 8, 9, 0, 1};
        System.out.println("Unsorted Array: " + Arrays.toString(arr));
        selectionSort(arr, true);
        System.out.println("Stable Selection Sort: " + Arrays.toString(arr));
        arr = new int[]{4, 5, 1, 2, 3, 6, 8, 9, 0, 1};
        selectionSort(arr);
        System.out.println("Unstable Selection Sort: " + Arrays.toString(arr));
    }
}
