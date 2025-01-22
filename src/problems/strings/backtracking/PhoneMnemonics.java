package problems.strings.backtracking;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneMnemonics {
    static HashMap<Character, String> mapping = new HashMap<>();

    public static ArrayList<String> computeMnemonics(String s) {
        ArrayList<String> result = new ArrayList<>();
        backtrack(s, result, new ArrayList<>(), 0);
        return result;
    }

    public static void backtrack(String s, ArrayList<String> result, ArrayList<String> currentPath, int index) {
        if (s.length() == index) {
            result.add(String.join("", currentPath));
            return;
        }
        for (char c : mapping.get(s.charAt(index)).toCharArray()) {
            currentPath.add(String.valueOf(c));
            backtrack(s, result, currentPath, index + 1);
            currentPath.removeLast();
        }
    }

    public static void main(String[] args) {
        mapping.put('2', "ABC");
        mapping.put('3', "DEF");
        mapping.put('4', "GHI");
        mapping.put('5', "JKL");
        mapping.put('6', "MNO");
        mapping.put('7', "PQRS");
        mapping.put('8', "TUV");
        mapping.put('9', "WXYZ");

        System.out.println("234: " + computeMnemonics("234"));

    }
}
