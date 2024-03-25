package data_structures;

import java.util.HashMap;

public class LRUCache<K, V> {
    // LRU Cache implementation using a doubly linked list and a hashmap
    // Complexity: O(1) for get and put operations
    // Space: O(n) where n is the capacity of the cache
    private final int capacity;
    private final HashMap<K, Node<V>> lookup;
    private final HashMap<Node<V>, K> reverseLookup;
    private int length;
    private Node<V> head;
    private Node<V> tail;


    public LRUCache(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be a positive integer");

        this.capacity = capacity;
        this.length = 0;
        this.head = null;
        this.tail = null;
        this.lookup = new HashMap<>();
        this.reverseLookup = new HashMap<>();

    }

    public synchronized void put(K key, V value) {
        // check if the key already exists
        Node<V> node = lookup.get(key);
        // if it does not exist,
        //    - check capacity
        //    - if capacity is full, remove the least recently used item
        //    - add the new key-value pair to the front of the list
        if (node == null) {
            node = new Node<>(value);
            prepend(node);
            lookup.put(key, node);
            reverseLookup.put(node, key);
            length++;
        } else {
            // if it does exist,
            //    - move the key-value pair to the front of the list
            removeNode(node);
            prepend(node);
            node.data = value;
        }
        removeTail();
    }

    public synchronized V get(K key) {
        // check the cache for the key
        Node<V> node = lookup.get(key);
        if (node == null) return null;
        // if it exists, move it to the front of the list and return the value
        removeNode(node);
        prepend(node);
        // if it doesn't exist, return null
        return node.data;
    }

    private void removeNode(Node<V> node) {
        // remove the node from the list
        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;

        if (node == head) head = node.next;
        if (node == tail) tail = node.prev;

        node.next = null;
        node.prev = null;
    }

    private void prepend(Node<V> node) {
        // add the node to the front of the list
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    private void removeTail() {
        // remove the least recently used item
        if (length <= capacity) return;

        Node<V> node = tail;
        this.removeNode(node);

        K key = reverseLookup.get(node);
        lookup.remove(key);
        reverseLookup.remove(node);
        length--;
    }

    public int size() {
        return length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<V> current = head;
        while (current != null) {
            sb.append(current.data).append(", ");
            current = current.next;
        }
        if (sb.length() > 1) sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }

    private static class Node<T> {
        public T data;
        public Node<T> next;
        public Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

}
