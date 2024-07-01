package search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    // Complexity: O(log N)
    static boolean binSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;  // find the middle index of the array

            if (arr[mid] == target) return true;  // we found the target
            else if (arr[mid] > target) high = mid;  // target is in left half
            else low = mid + 1;  // target is in right half
        }

        return false;  // target is not found
    }

    public static void main(String[] args) {
        int[] anArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};  // Must be sorted fr
        Scanner sc = new Scanner(System.in);
        System.out.println("Array: " + Arrays.toString(anArray));
        System.out.print("Enter a num: ");
        int t = sc.nextInt();
        boolean isFound = binSearch(anArray, t);

        if (isFound) System.out.printf("%d is in Array", t);
        else System.out.printf("%d is not in Array", t);

    }
}
