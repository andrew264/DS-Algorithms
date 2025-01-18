package problems.backtracking;

import java.util.ArrayList;

public class DecodingDigitSequence {
    static boolean validSegment(String s) {
        int value = Integer.parseInt(s);
        return value > 0 && value < 27;
    }

    static void backtrack(String digits, ArrayList<String> combinations, int start, ArrayList<String> path) {
        if (start == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (String segment : path)
                sb.append((char) (Integer.parseInt(segment) + 'A' - 1));
            combinations.add(sb.toString());
            return;
        }
        for (int end = start + 1; end < Math.min(start + 3, digits.length() + 1); end++) {
            String segment = digits.substring(start, end);
            if (validSegment(segment)) {
                path.add(segment);
                backtrack(digits, combinations, end, path);
                path.removeLast();
            }
        }
    }

    static ArrayList<String> possibleDecoding(String digits) {
        ArrayList<String> combinations = new ArrayList<>();
        backtrack(digits, combinations, 0, new ArrayList<>());
        return combinations;
    }

    public static void main(String[] args) {
        System.out.println(possibleDecoding("121"));
        System.out.println(possibleDecoding("1234"));
        System.out.println(possibleDecoding("226"));
    }
}
