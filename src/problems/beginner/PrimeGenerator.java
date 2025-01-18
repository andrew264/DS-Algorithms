package problems.beginner;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeGenerator {
    static int[] genPrime(int n) {
        if (n < 1) return new int[0];

        int[] result = new int[n];
        int count = 0;
        int num = 2;
        while (count < n) {
            if (isPrime(num)) {
                result[count++] = num;
            }
            num++;
        }
        return result;
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        sc.close();
        int[] primes = genPrime(n);
        System.out.println("First " + n + " prime numbers: " + Arrays.toString(primes));
    }
}
