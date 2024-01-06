import java.util.Arrays;

public class QuickSort {
    // Divide and Conquer Strategy
    // Complexity: O(n log n)
    // has a Worst case of O(n^2) if array is in reverse

    static void quickSort(int[] arr, int lo, int hi) {
        // recursively sort the array
        // lo: low index
        // hi: high index
        if (lo >= hi) {  // if the low index is greater than or equal to the high index, return
            return;
        }

        int pivotIdx = partition(arr, lo, hi);  // partition the array and get the pivot index
        quickSort(arr, lo, pivotIdx - 1);  // sort the left side of the pivot
        quickSort(arr, pivotIdx + 1, hi);  // sort the right side of the pivot

    }

    static int partition(int[] arr, int lo, int hi) {
        // rearrange the array so that all elements less than or equal to the pivot are on the left side of the pivot
        // and all elements greater than the pivot are on the right side of the pivot

        int pivot = arr[hi];  // Choose the last element as the pivot

        int idx = lo - 1;  // temp pivot index


        for (int i = lo; i < hi; i++) {
            if (arr[i] <= pivot) {  // if current element is less than or equal to pivot
                idx++;  // move the temp pivot index forward

                // swap the current element with the element at the temp pivot index
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
            }
        }
        idx++;  // move forward once more, so that the temp pivot index is at the pivot index

        // swap the pivot with the element at the temp pivot index
        arr[hi] = arr[idx];
        arr[idx] = pivot;
        return idx;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 7, 2, 3, 6, 8, 9, 0, 1};
        System.out.println("Unsorted Array: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("After Quick Sort: " + Arrays.toString(arr));
    }
}
