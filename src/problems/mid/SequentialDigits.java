package problems.mid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {
    // Given an integer low and high, return a list of all the sequential digits in the range [low, high] inclusive.
    // A sequential digit is a digit such that every digit in the number is one greater than the previous digit.
    // Complexity: O(1) - constant time to generate all sequential digits
    public static void main(String[] args) {
        int low = 100;
        int high = 300;
        System.out.println(sequentialDigits(low, high));  // [123,234]

        int low2 = 1000;
        int high2 = 13000;
        System.out.println(sequentialDigits(low2, high2));  // [1234,2345,3456,4567,5678,6789,12345]
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        for (int start = 1; start <= 9; start++) {
            int num = start;
            while (num <= high) {
                if (low <= num) {
                    result.add(num);
                }
                int nextDigit = num % 10 + 1;
                if (nextDigit > 9) {
                    break;
                }
                num = num * 10 + nextDigit;
            }
        }
        Collections.sort(result);
        return result;
    }
}
