package problems.strings.backtracking;

import java.util.ArrayList;

public class StringPermutations {
    static void backtrack(int start, int end, char[] arr, ArrayList<String> results) {
        if (start == end) {
            results.add(String.valueOf(arr));
            return;
        }
        for (int i = start; i < end; i++) {
            char temp = arr[i];
            arr[i] = arr[start];
            arr[start] = temp;
            backtrack(start + 1, end, arr, results);
            temp = arr[i];
            arr[i] = arr[start];
            arr[start] = temp;
        }
    }

    public static ArrayList<String> findSolution(String str) {
        ArrayList<String> result = new ArrayList<>();
        backtrack(0, str.length(), str.toCharArray(), result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Permutations of ABC: " + findSolution("ABC"));
    }
}
