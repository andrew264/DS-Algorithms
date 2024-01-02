import java.util.Arrays;

public class BubbleSort {
    // Simplest sorting algo
    // Complexity: O(N^2)
    // actually the complexity is  (N^2)-N/2
    // we don't care about insignificant factors, so it is N^2

    static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length - 1 - i; j++)
                // -1 cuz we don't want the last element, as we compare with a [j+1]
                // -i cuz in bubble sort after every iteration the last i elements in the array is sorted.
                if (arr[j] > arr[j + 1]) {  // if the current element is greater than the next element swap them
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 7, 2, 3, 6, 8, 9, 0, 1};
        System.out.println("Unsorted Array: " + Arrays.toString(arr));
        System.out.println("After Bubble Sort: " + Arrays.toString(bubbleSort(arr)));
    }
}
