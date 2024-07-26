package search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    // Complexity: O(log N)
    static int binSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] anArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};  // Must be sorted fr
        Scanner sc = new Scanner(System.in);
        System.out.println("Array: " + Arrays.toString(anArray));
        System.out.print("Enter a num: ");
        int t = sc.nextInt();
        int index = binSearch(anArray, t);

        if (index != -1) System.out.println("Found at index: " + index);
        else System.out.println("Not found!");

    }
}
