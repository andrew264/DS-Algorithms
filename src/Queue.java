public class Queue<T> {

    public int size;
    private Node<T> head = null;
    private Node<T> tail = null;

    public Queue() {
        this.size = 0;
    }

    public void enqueue(T value) {  // add a new node to the tail
        Node<T> node = new Node<T>(value);  // create a new node
        this.size++;
        if (this.tail == null) {  // if the queue is empty, set the head and tail to the new node
            this.head = node;
            this.tail = node;
            return;
        }
        this.tail.next = node;  // set the next node of the tail to the new node
        this.tail = node;  // set the tail to the new node
    }

    public T dequeue() {  // remove the head node
        if (this.size == 0) {  // if the queue is empty, return null
            return null;
        }
        this.size--;

        Node<T> temp = this.head;  // save the head node to a variable
        this.head = this.head.next;  // set the head to the next node
        temp.next = null;  // remove the pointer to the next node, so that the garbage collector can free the memory

        if (this.size == 0) {  // if the queue is empty, set the tail to null
            this.tail = null;
        }

        return temp.value;  // return the value of the dequeued node
    }

    public T peek() {  // return the value of the head node
        return this.head.value;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void print() {
        Node<T> current = this.head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    private static class Node<T> {
        public T value;
        public Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

    }

}
