package problems.arrays.twopointers;

import java.util.Arrays;

public class ZerosToEnd {
    static void sort(int[] arr) {
        int nonZeroIdx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[nonZeroIdx];
                arr[nonZeroIdx] = arr[i];
                arr[i] = temp;
                nonZeroIdx++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
