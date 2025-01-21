package problems.arrays;

public class MissingNumber {
    public static int findSolution(int[] arr) {
        long currSum = 0;
        for (int j : arr) {
            currSum += j;
        }
        long n = arr.length + 1;
        long expectedSum = (n * (n + 1)) / 2;
        return (int) (expectedSum - currSum);
    }

    public static void main(String[] args) {
        System.out.println(findSolution(new int[]{1, 2, 3, 5}));
        System.out.println(findSolution(new int[]{8, 2, 4, 5, 3, 7, 1}));
    }
}
