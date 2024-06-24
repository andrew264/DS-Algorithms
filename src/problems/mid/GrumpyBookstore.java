package problems.mid;

public class GrumpyBookstore {
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int totalSatisfied = 0;
        int windowSatisfied = 0;
        int maxAdditionalSatisfied = 0;

        for (int i = 0; i < customers.length; i++) {
            windowSatisfied += customers[i] * grumpy[i];

            if (i >= minutes) {
                windowSatisfied -= customers[i - minutes] * grumpy[i - minutes];
            }

            maxAdditionalSatisfied = Math.max(maxAdditionalSatisfied, windowSatisfied);
            totalSatisfied += customers[i] * (grumpy[i] ^ 1);
        }

        return totalSatisfied + maxAdditionalSatisfied;
    }

    public static void main(String[] args) {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;
        System.out.println(maxSatisfied(customers, grumpy, minutes));  // 16

        int[] customers2 = {10, 1, 10, 1, 10, 1, 10};
        int[] grumpy2 = {1, 1, 1, 1, 1, 1, 1};
        int minutes2 = 1;
        System.out.println(maxSatisfied(customers2, grumpy2, minutes2));  // 10
    }
}
