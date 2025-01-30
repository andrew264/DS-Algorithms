package problems.arrays.heap;

import java.util.PriorityQueue;

public class MinimumRopeCost {
    static int findSolution(int[] arr) {
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) pq.add(i);
        int r1, r2;
        while (pq.size() > 1) {
            r1 = pq.poll();
            r2 = pq.poll();
            res += r1 + r2;
            pq.add(r1 + r2);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findSolution(new int[]{4, 3, 2, 6}));
        System.out.println(findSolution(new int[]{4, 2, 7, 6, 9}));
        System.out.println(findSolution(new int[]{10}));
    }
}
