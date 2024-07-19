package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;

        int mid = arr.length / 2;

        int[] left = new int[mid];
        System.arraycopy(arr, 0, left, 0, mid);
        mergeSort(left);

        int[] right = new int[arr.length - mid];
        System.arraycopy(arr, mid, right, 0, arr.length - mid);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 10, 7, 2, 3, 6, 8, 9, 0, 1, -1};
        System.out.println("Unsorted Array: " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("After Quick Sort: " + Arrays.toString(arr));
    }
}
