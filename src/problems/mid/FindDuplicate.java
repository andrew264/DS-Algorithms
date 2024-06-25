package problems.mid;

public class FindDuplicate {
    public static int findDuplicate(int[] nums) {
        // Floyd's Tortoise and Hare (Cycle Detection)
        // Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
        // There is only one repeated number in nums, return this repeated number.
        // Complexity: O(n) - n is the number of elements in the array
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return hare;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));  // 2

        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println(findDuplicate(nums2));  // 3
    }
}
