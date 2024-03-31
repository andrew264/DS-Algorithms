package problems.beginner;

public class NumStepsToZero {
    public static void main(String[] args) {
        System.out.println(numStepsToZero(14));  // 6
    }

    public static int numStepsToZero(int num) {
        // Time complexity: O(log n)
        // Space complexity: O(1)
        int steps = 0;
        while (num != 0) {
            if ((num & 1) == 0) {  // num % 2 == 0
                num >>= 1;  // num /= 2
            } else {
                num--;
            }
            steps++;
        }
        return steps;
    }
}
