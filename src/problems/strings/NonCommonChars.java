package problems.strings;

import java.util.Arrays;

public class NonCommonChars {
    public static String findNonCommonChars(String str1, String str2) {
        int[] frequencies = new int[26];
        // we can have -1 for common chars in str1 and str2, 0 for not found in both
        // 1 for only in str1. 2 for only in str2
        Arrays.fill(frequencies, 0);

        for (char c : str1.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) frequencies[c - 'a'] = 1;
        }

        for (char c : str2.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                int idx = c - 'a';
                if (frequencies[idx] == 1) frequencies[idx] = -1;  // already found in str1; set it to -1
                else if (frequencies[idx] == 0) frequencies[idx] = 2;  // not found in str1; set it to 2
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > 0) {
                ans.append((char) (i + 'a'));
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String ans1 = findNonCommonChars("alphabet", "character");
        System.out.printf("Uncommon chars for \"alphabet\" and \"character\": %s\n", ans1);
        String ans2 = findNonCommonChars("rome", "more");
        System.out.printf("Uncommon chars for \"rome\" and \"more\": %s", ans2);
    }
}
