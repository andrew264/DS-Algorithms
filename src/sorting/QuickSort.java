package sorting;

import java.util.Arrays;

public class QuickSort {
    // Divide and Conquer Strategy
    // Complexity: O(n log n)
    // has a Worst case of O(n^2) if array is in reverse

    static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIdx = partition(arr, low, high);  // get the pivot index
            quickSort(arr, low, pivotIdx - 1);  // sort the left side
            quickSort(arr, pivotIdx + 1, high);  // sort the right side
        }
    }

    static int partition(int[] arr, int low, int high) {
        int idx = low - 1;

        for (int j = low; j < high; j++)
            if (arr[j] <= arr[high]) {
                idx++;
                swap(arr, idx, j);
            }

        idx++;
        swap(arr, idx, high);
        return idx;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 7, 2, 3, 6, 8, 9, 0, 1};
        System.out.println("Unsorted Array: " + Arrays.toString(arr));
        quickSort(arr);
        System.out.println("After Quick Sort: " + Arrays.toString(arr));
    }
}
