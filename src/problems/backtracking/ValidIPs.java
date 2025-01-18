package problems.backtracking;

import java.util.ArrayList;

public class ValidIPs {
    static boolean validSegment(String s) {
        if (s.length() == 1) return true;

        int value = Integer.parseInt(s);
        return s.charAt(0) != '0' && value >= 0 && value < 256;
    }

    static void backtrack(String rawAddress, ArrayList<String> allIPs, int start, ArrayList<String> path) {
        if (path.size() == 4 && start == rawAddress.length()) {
            allIPs.add(String.join(".", path));
            return;
        }
        if (path.size() > 4) return;
        for (int end = start + 1; end <= Math.min(start + 3, rawAddress.length()); end++) {
            String segment = rawAddress.substring(start, end);
            if (validSegment(segment)) {
                path.add(segment);
                backtrack(rawAddress, allIPs, end, path);
                path.removeLast();
            }
        }
    }

    static ArrayList<String> generateValidIPs(String rawAddress) {
        ArrayList<String> allIPs = new ArrayList<>();
        backtrack(rawAddress, allIPs, 0, new ArrayList<>());
        return allIPs;
    }

    public static void main(String[] args) {
        System.out.println(generateValidIPs("25525511135"));
        System.out.println(generateValidIPs("127001"));
    }
}
