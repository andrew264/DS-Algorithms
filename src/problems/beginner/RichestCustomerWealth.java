package problems.beginner;

public class RichestCustomerWealth {
    public static int maximumWealth(int[][] accounts) {
        // Time complexity: O(n * m)
        // Space complexity: O(1)
        int max = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int j : account) {
                sum += j;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] accounts = {{7, 1, 3}, {2, 8, 7}, {1, 9, 5}};
        System.out.println(maximumWealth(accounts));  // Output: 17
    }
}
