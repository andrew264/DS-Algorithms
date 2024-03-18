package data_structures;

import java.util.ArrayList;

public class MinHeap<T extends Comparable<T>> {
    // data_structures.MinHeap is a complete binary tree
    // A binary tree where the value of each node is less than or equal to the value of its children
    // Also known as a priority queue
    // The root node is the minimum value in the tree
    // Insertion and Deletion can be done in O(N) time
    // The tree is stored in an array

    private final ArrayList<T> heap;
    public int length;

    public MinHeap() {
        heap = new ArrayList<>();
        length = 0;

    }

    public static void main(String[] args) {
        MinHeap<Integer> heap = new MinHeap<>();
        heap.insert(5);
        heap.insert(3);
        heap.insert(69);
        heap.insert(420);
        heap.insert(4);
        heap.insert(1);
        heap.insert(8);
        heap.insert(7);

        System.out.println("Length: " + heap.length);  // 8
        System.out.println("Min: " + heap.deleteMin()); // 1
        System.out.println("Min: " + heap.deleteMin()); // 3
        System.out.println("Min: " + heap.deleteMin()); // 4
        System.out.println("Min: " + heap.deleteMin()); // 5
        System.out.println("Length: " + heap.length);  // 4
        System.out.println("Min: " + heap.deleteMin()); // 7
        System.out.println("Min: " + heap.deleteMin()); // 8
        System.out.println("Min: " + heap.deleteMin()); // 69
        System.out.println("Min: " + heap.deleteMin()); // 420
        System.out.println("Length: " + heap.length);  // 0
    }

    public void insert(T value) {
        heap.add(value);  // add value to the end of the array
        heapifyUp(length);  // heapify up the tree from the end of the array
        length++;  // increment length
    }

    public T deleteMin() {
        if (length == 0) {
            return null;  // heap is empty
        }
        T min = heap.get(0);  // get the minimum value
        heap.set(0, heap.get(length - 1));  // set the root value to the last value in the array
        heap.remove(length - 1);  // remove the last value in the array
        length--;  // decrement length
        heapifyDown(0);  // heapify down the tree from the root
        return min;
    }

    private void heapifyUp(int index) {
        // heapify up the tree from the given index
        // if the current value is less than its parent value, swap the two values
        if (index == 0) {
            return;  // root node
        }

        T currValue = heap.get(index);  // get current value
        int parentIndex = parent(index);  // get parent index
        T parentValue = heap.get(parentIndex);  // get parent value
        if (parentValue.compareTo(currValue) > 0) {  // if parent value is greater than current value
            swap(parentIndex, index);  // swap parent and current values
            heapifyUp(parentIndex);  // heapify up the parent
        }
    }

    private void heapifyDown(int index) {
        int leftChildIndex = leftChild(index);  // get left child index
        int rightChildIndex = rightChild(index);  // get right child index

        if (index >= length || leftChildIndex >= length || rightChildIndex >= length) {
            return;  // index is out of bounds
        }
        T leftChildValue = heap.get(leftChildIndex);  // get left child value
        T rightChildValue = heap.get(rightChildIndex);  // get right child value
        T currValue = heap.get(index);  // get current value

        if (leftChildValue.compareTo(rightChildValue) < 0 && leftChildValue.compareTo(currValue) < 0) {
            // if left child value is less than right child value and current value
            swap(leftChildIndex, index);  // swap left child and current values
            heapifyDown(leftChildIndex);  // heapify down the left child
        } else if (rightChildValue.compareTo(leftChildValue) < 0 && rightChildValue.compareTo(currValue) < 0) {
            // if right child value is less than left child value and current value
            swap(rightChildIndex, index);  // swap right child and current values
            heapifyDown(rightChildIndex);  // heapify down the right child
        }

    }

    private void swap(int index1, int index2) {
        // swap the values at the given indices
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    private int parent(int index) {
        // return the parent index of the given index
        // formula: (index - 1) / 2
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        // return the left child index of the given index
        // formula: (2 * index) + 1
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        // return the right child index of the given index
        // formula: (2 * index) + 2
        return 2 * index + 2;
    }
}
