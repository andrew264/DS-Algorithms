package problems.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayLeader {
    public static ArrayList<Integer> findSolution(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int max = arr[arr.length - 1];
        result.add(max);
        for (int i = arr.length - 2; i > -1; i--) {  // suffix sum??
            if (arr[i] >= max) {
                result.add(arr[i]);
                max = arr[i];
            }
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findSolution(new int[]{16, 17, 4, 3, 5, 2}));
        System.out.println(findSolution(new int[]{10, 4, 2, 4, 1}));
        System.out.println(findSolution(new int[]{5, 10, 20, 40}));
        System.out.println(findSolution(new int[]{30, 10, 10, 5}));
    }
}
