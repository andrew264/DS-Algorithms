package tests;

import data_structures.Queue;

public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.peek());  // 1
        queue.print();  // 1 2 3
        System.out.println(queue.dequeue()); // 1
        queue.enqueue(4);
        queue.print();  // 2 3 4
        System.out.println("Queue is empty: " + queue.isEmpty());  // false
    }
}
