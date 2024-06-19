package problems.mid;

public class MakemBouquets {
    public static int minDays(int[] bloomDay, int m, int k) {
        if (((long) m * k) > bloomDay.length)
            // if the number of flowers is less than the number of flowers needed to make a bouquet
            return -1;

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for (int j : bloomDay) {
            left = Math.min(left, j);
            right = Math.max(right, j);
        }

        while (left < right) {  // good old binary search
            int mid = (left + right) >>> 1;
            if (check(bloomDay, m, k, mid))
                right = mid;
            else
                left = mid + 1;
        }
        return left;

    }

    public static boolean check(int[] bloomDay, int m, int k, int day) {
        int current = 0, count = 0;
        for (int bd : bloomDay) {
            current = bd <= day ? current + 1 : 0;
            // if the bloom day is less than or equal to the day, increment the current count
            // reset the current count if the next bloom day is greater than the day
            if (current == k) {
                // if the current count is equal to the number of flowers needed to make a bouquet
                count += 1;
                current = 0;
            }
        }
        return count >= m;  // true if we can make m bouquets
    }

    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3, k = 1;
        System.out.println(minDays(bloomDay, m, k));  // 3
        int[] bloomDay2 = {1, 10, 3, 10, 2};
        int m2 = 3, k2 = 2;
        System.out.println(minDays(bloomDay2, m2, k2));  // -1
    }
}
