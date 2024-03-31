package problems.beginner;

public class FizzBuzz {
    public static void main(String[] args) {
        fizzBuzz(15);
    }

    public static void fizzBuzz(int n) {
        // Time complexity: O(n)
        // Space complexity: O(1)
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else {
                System.out.println(i);
            }
        }
    }
}
