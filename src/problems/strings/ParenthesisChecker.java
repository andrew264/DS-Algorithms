package problems.strings;

import java.util.ArrayDeque;
import java.util.Deque;

public class ParenthesisChecker {
    static boolean findSolution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                char lastC = stack.pop();
                if (lastC != '(' && c == ')' || lastC != '[' && c == ']' || lastC != '{' && c == '}')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(findSolution("[{()}]"));
        System.out.println(findSolution("[()()]{}"));
        System.out.println(findSolution("([]"));
        System.out.println(findSolution("([{]})"));
    }
}
