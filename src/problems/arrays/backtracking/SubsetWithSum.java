package problems.arrays.backtracking;

import java.util.ArrayList;

public class SubsetWithSum {
    static void backtrack(ArrayList<ArrayList<Integer>> result, int start, ArrayList<Integer> path, int[] arr, int sum, int curSum) {
        if (sum == curSum) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (curSum > sum || start >= arr.length) return;

        for (int i = start; i < arr.length; i++) {
            path.add(arr[i]);
            backtrack(result, i + 1, path, arr, sum, curSum + arr[i]);
            path.removeLast();
        }
    }

    public static ArrayList<ArrayList<Integer>> findSolution(int[] arr, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(result, 0, new ArrayList<>(), arr, sum, 0);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findSolution(new int[]{1, 2, 3, 4, 5}, 6));
    }
}
