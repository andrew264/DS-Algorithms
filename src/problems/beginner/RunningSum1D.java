package problems.beginner;

public class RunningSum1D {
    public static int[] runningSum(int[] nums) {
        // Time complexity: O(n)
        // Space complexity: O(1)
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        for (int j : runningSum(nums)) {
            System.out.print(j + " ");  // Output: 1 3 6 10 15 21
        }
    }
}
