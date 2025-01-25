package problems.arrays.twopointers;

import java.util.Arrays;

public class DutchSort {
    static void findSolution(int[] arr, int pivotValue) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == pivotValue) {
                mid++;
            } else if (arr[mid] < pivotValue) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else {
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 2, 3, 0, 2, 1, 1};
        findSolution(arr1, 1);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = {0, 1, 2, 3, 0, 2, 1, 1};
        findSolution(arr2, 2);
        System.out.println(Arrays.toString(arr2));
    }
}
