package problems.arrays.dynamicprogramming;

import java.util.Arrays;

public class KadaneAlgorithm {
    public static int findSolution(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 0);
        dp[0] = arr[0];
        int maxSoFar = dp[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            maxSoFar = Math.max(maxSoFar, dp[i]);
        }
        System.out.println("dp: " + Arrays.toString(dp));
        return maxSoFar;
    }

    public static int findSolution2(int[] arr) {
        int global = arr[0];
        int local = arr[0];
        for (int i = 1; i < arr.length; i++) {
            local = Math.max(arr[i], arr[i] + local);
            global = Math.max(local, global);
        }
        return global;
    }

    public static int[] findSolution3(int[] arr) {
        int global = arr[0];
        int local = arr[0];
        int start = 0, end = 0, tempStart = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i] + local) {
                local = arr[i];
                tempStart = i;
            } else {
                local += arr[i];
            }
            if (local > global) {
                global = local;
                start = tempStart;
                end = i;
            }
        }
        return Arrays.copyOfRange(arr, start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(findSolution(new int[]{2, 3, -8, 7, -1, 2, 3, -20}));
        System.out.println(Arrays.toString(findSolution3(new int[]{2, 3, -8, 7, -1, 2, 3})));
        System.out.println(findSolution2(new int[]{-2, -4}));
        System.out.println(Arrays.toString(findSolution3(new int[]{-2, -4})));
        System.out.println(findSolution(new int[]{5, 4, 1, 7, 8}));
        System.out.println(Arrays.toString(findSolution3(new int[]{5, 4, 1, 7, 8})));
    }
}
