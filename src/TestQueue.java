public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.peek());  // 1
        queue.print();  // 1 2 3
        queue.dequeue();
        queue.enqueue(4);
        queue.print();  // 2 3 4
    }
}
