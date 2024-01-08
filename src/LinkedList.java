public class LinkedList<T> {
    public int length;
    private Node<T> head;
    private Node<T> tail;

    LinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    void insertAt(T item, int index) throws ArrayIndexOutOfBoundsException {
        if (index > this.length) {
            throw new ArrayIndexOutOfBoundsException("oh no pls don't do that");  // we do not hae this index
        }
        if (index == this.length) {
            this.append(item);  // we are inserting at the end
            return;
        } else if (index == 0) {
            this.prepend(item);  // we are inserting at the beginning
            return;
        }

        // we are inserting in the middle
        Node<T> curr = this.getAt(index);  // get the node at the index
        Node<T> node = new Node<>(item);  // create a new node

        node.next = curr;  // set the new node's next point to the current node
        node.prev = curr.prev;  // set the new node's prev point to the current node's prev
        curr.prev.next = node;  // set the current node's prev's next point to the new node
        curr.prev = node;  // set the current node's prev point to the new node

        this.length++;
    }

    T remove(T item) {
        var curr = this.head;
        for (int i = 0; i < this.length; i++) {
            if (curr.data == item) {  // we found the item
                break;
            }
            curr = curr.next;
        }
        if (curr == null)  // we did not find the item
            return null;

        return this.removeNode(curr);

    }

    T removeAt(int index) {
        Node<T> node = this.getAt(index);
        if (node == null)  // we did find anything at the index
            return null;

        return this.removeNode(node);

    }

    private T removeNode(Node<T> node) {
        this.length--;

        if (this.length == 0) {  // we are removing the last item in the list
            T data = this.head.data;
            this.head = this.tail = null;  // set the head and tail to null
            return data;
        }

        // we are removing a node in the middle of the list
        if (node.prev != null)  // if the node has a prev
            node.prev.next = node.next;  //  set the node's prev's next to the node's next

        if (node.next != null)  // if the node has a next
            node.next.prev = node.prev;  // set the node's next's prev to the node's prev

        // we are removing the head or tail
        if (node == this.head)
            this.head = this.head.next;  // set the head to the next node

        if (node == this.tail)
            this.tail = this.tail.prev;  // set the tail to the prev node

        node.prev = node.next = null;  // set the node's prev and next to null, so we don't have any dangling pointers
        return node.data;
    }

    void append(T item) {
        // add to the end of the list
        Node<T> node = new Node<>(item);
        this.length++;

        if (this.tail == null) {  // if the list is empty
            this.tail = this.head = node;  // set the head and tail to the new node
            return;
        }
        node.prev = this.tail;  // set the new node's prev to the current tail
        this.tail.next = node;  // set the current tail's next to the new node
        this.tail = node;  // set the tail to the new node
    }

    void prepend(T item) {
        // add to the beginning of the list
        Node<T> node = new Node<>(item);
        this.length++;

        if (this.head == null) {  // if the list is empty
            this.head = this.tail = node;  // set the head and tail to the new node
            return;
        }
        node.next = this.head;  // set the new node's next to the current head
        this.head.prev = node;  // set the current head's prev to the new node
        this.head = node;  // set the head to the new node
    }

    T get(int index) {
        return this.getAt(index).data;
    }

    private Node<T> getAt(int index) {
        Node<T> curr = this.head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }


    public String toString() {
        StringBuilder out = new StringBuilder().append("[");
        Node<T> curr = this.head;
        for (int i = 0; i < this.length; i++) {
            out.append(curr.data);
            if (i != this.length - 1) {
                out.append(", ");
            }
            curr = curr.next;
        }
        out.append("]");
        return out.toString();
    }

    private static class Node<T> {
        final T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
}
