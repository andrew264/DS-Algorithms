package problems.strings;

import java.util.*;

public class RemoveInvalidParentheses {

    public static void main(String[] args) {
        String input1 = "()())()";
        String input2 = "(a)())()";
        String input3 = ")(";
        String input4 = "((abc)((de))";

        System.out.println(removeInvalidParentheses(input4));
        System.out.println(removeInvalidParentheses(input1));
        System.out.println(removeInvalidParentheses(input2));
        System.out.println(removeInvalidParentheses(input3));
    }

    public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (isValid(current)) {
                result.add(current);
                found = true;
            }

            if (found) continue;

            for (int i = 0; i < current.length(); i++) {
                if (current.charAt(i) != '(' && current.charAt(i) != ')') continue;

                String next = current.substring(0, i) + current.substring(i + 1);

                if (!visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                }
            }
        }

        return result;
    }

    private static boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
}


