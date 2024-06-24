package problems.mid;

public class NiceSubArrays {
    public static int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private static int atMost(int[] nums, int k) {
        int count = 0, odds = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 1) {
                odds++;
            }
            while (odds > k) {
                if (nums[left] % 2 == 1) {
                    odds--;
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(numberOfSubarrays(nums, k));  // 2
        int[] nums2 = {2, 4, 6};
        int k2 = 1;
        System.out.println(numberOfSubarrays(nums2, k2));  // 0
        int[] nums3 = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k3 = 2;
        System.out.println(numberOfSubarrays(nums3, k3));  // 16
    }
}
