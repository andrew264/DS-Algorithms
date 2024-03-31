package problems.beginner;

import java.util.HashMap;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        // Time complexity: O(m)
        // Space complexity: O(1)
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);

            int count = map.getOrDefault(c, 0);
            if (count == 0) {
                return false;
            }
            map.put(c, count - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));  // Output: false
        System.out.println(canConstruct("aa", "ab"));  // Output: false
        System.out.println(canConstruct("aa", "aab"));  // Output: true
    }
}
