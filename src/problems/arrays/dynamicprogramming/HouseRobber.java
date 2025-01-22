package problems.arrays.dynamicprogramming;

import java.util.Arrays;

public class HouseRobber {
    public static int findSolution1(int[] arr) {
        if (arr.length == 0) return 0;
        if (arr.length == 1) return arr[0];

        int[] dp = new int[arr.length];
        Arrays.fill(dp, 0);

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }
        return dp[arr.length - 1];
    }

    public static int findSolution2(int[] arr) {
        int p1 = 0, p2 = 0;
        for (int i : arr) {
            int curr = Math.max(p1, i + p2);
            p2 = p1;
            p1 = curr;
        }
        return p1;
    }

    public static void main(String[] args) {
        System.out.println(findSolution1(new int[]{3, 2, 5, 10, 7}));
        System.out.println(findSolution2(new int[]{3, 2, 5, 10, 7}));
    }
}
