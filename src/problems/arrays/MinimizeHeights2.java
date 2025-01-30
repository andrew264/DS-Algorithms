package problems.arrays;

import java.util.Arrays;

public class MinimizeHeights2 {
    // modify the height of each tower either by increasing or decreasing them by K only once
    // After modifying, height should be a non-negative integer.
    // minimum possible difference of the height of shortest and longest towers after you have modified each tower
    static int findSolution(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        if (n==1) return 0;
        int min_elem, max_elem;
        int ans = arr[n - 1] - arr[0];
        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;
        for (int i = 1; i <= n - 1; i++) {
            if (arr[i] >= k) {
                max_elem = Math.max(largest, arr[i - 1] + k);
                min_elem = Math.min(smallest, arr[i] - k);
                ans = Math.min(ans, max_elem - min_elem);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(findSolution(new int[]{1, 5, 8, 10}, 2));
        System.out.println(findSolution(new int[]{3, 9, 12, 16, 20}, 3));
        System.out.println(findSolution(new int[]{1, 8, 10, 6, 4, 6, 9, 1}, 7));
        System.out.println(findSolution(new int[]{380, 156, 781}, 351));
    }
}
