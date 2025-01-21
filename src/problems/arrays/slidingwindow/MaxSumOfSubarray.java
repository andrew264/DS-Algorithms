package problems.arrays.slidingwindow;

public class MaxSumOfSubarray {
    public static int findSolution(int[] arr, int k) {
        int max = 0;
        for (int i = 0; i < k; i++)
            max += arr[i];
        int windowSum = max;
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            max = Math.max(windowSum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findSolution(new int[]{1, 4, 2, 10, 2, 3, 1, 0, 20}, 4));
    }
}
