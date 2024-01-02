public class Stack<T> {
    public int size;
    private Node<T> head;


    public Stack() {
        this.size = 0;
        this.head = null;
    }

    public void push(T value) {
        Node<T> node = new Node<T>(value);
        this.size++;
        if (this.head == null) {  // if the stack is empty, set the head to the new node
            this.head = node;
            return;
        }
        node.prev = this.head;  // set the previous node of the new node to the head
        this.head = node;  // set the head to the new node
    }

    public T pop() {
        if (this.size == 0) {  // if the stack is empty, return null
            return null;
        }
        this.size--;

        Node<T> temp = this.head;  // save the head node to a variable
        this.head = this.head.prev;  // set the head to the previous node
        temp.prev = null;  // remove the pointer to the previous node, so that the garbage collector can free the memory

        return temp.value;
    }

    public T peek() {
        return this.head.value;
    }

    public void print() {
        Node<T> current = this.head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.prev;
        }
        System.out.println();
    }

    private static class Node<T> {
        public T value;
        public Node<T> prev;

        public Node(T value) {
            this.value = value;
            this.prev = null;
        }

    }
}
