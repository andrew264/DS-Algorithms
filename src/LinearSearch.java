import java.util.Arrays;
import java.util.Scanner;

public class LinearSearch {
    // Complexity: O(N)
    static boolean linearSearch(int[] arr, int target) {
        for (int j : arr) {
            if (j == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] anArray = {4, 5, 7, 2, 3, 6, 8, 9, 0};
        Scanner sc = new Scanner(System.in);
        System.out.println("Array: " + Arrays.toString(anArray));
        System.out.print("Enter a num: ");
        int t = sc.nextInt();
        boolean isFound = linearSearch(anArray, t);
        if (isFound) System.out.printf("%d is in Array", t);
        else System.out.printf("%d is not in Array", t);

    }
}
