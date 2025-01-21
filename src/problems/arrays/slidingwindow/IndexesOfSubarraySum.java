package problems.arrays.slidingwindow;

import java.util.ArrayList;

public class IndexesOfSubarraySum {
    public static ArrayList<Integer> findSolution(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        int s = 0, e = 0;
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
            if (total >= target) {
                e = i;
                while (total > target && s < e) {
                    total -= arr[s];
                    s++;
                }
            }
            if (target == total) {
                result.add(s);
                result.add(e);
                return result;
            }

        }
        result.add(-1);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findSolution(new int[]{1, 2, 3, 7, 5}, 12));
        System.out.println(findSolution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 15));
        System.out.println(findSolution(new int[]{5, 3, 4}, 2));

    }
}
