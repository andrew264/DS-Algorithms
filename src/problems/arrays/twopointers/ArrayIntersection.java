package problems.arrays.twopointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayIntersection {
    static int[] intersect(int[] nums1, int[] nums2) {  // two pointer approach
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                nums1[k++] = nums1[i++];
                j++;
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }

    static int[] intersectUnique(int[] nums1, int[] nums2) {  // hash set approach (for unique elements)
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();

        for (int j : nums1) set1.add(j);

        for (int i : nums2)
            if (set1.contains(i))
                intersect.add(i);

        int[] result = new int[intersect.size()];
        int i = 0;
        for (int num : intersect)
            result[i++] = num;
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        System.out.println("Unique Intersection: " + Arrays.toString(intersectUnique(nums1, nums2)));
        System.out.println("Intersection: " + Arrays.toString(intersect(nums1, nums2)));
    }
}
