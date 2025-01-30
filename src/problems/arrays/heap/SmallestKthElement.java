package problems.arrays.heap;

import java.util.PriorityQueue;

public class SmallestKthElement {
    static int findSolution(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);  // Max Heap
        for (int i : arr) {
            pq.add(i);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        System.out.println(findSolution(new int[]{7, 10, 4, 3, 20, 15}, 3));
        System.out.println(findSolution(new int[]{2, 3, 1, 20, 15}, 4));
    }
}
