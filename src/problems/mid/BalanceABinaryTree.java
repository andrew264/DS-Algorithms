package problems.mid;

import data_structures.BinaryTreeNode;

import java.util.ArrayList;

public class BalanceABinaryTree {
    // Given a binary search tree, return a balanced binary search tree with the same node values.
    // Step 1: Convert the BST to a sorted array using inOrder traversal.
    // Step 2: Convert the sorted array to a balanced BST using a recursive helper function.
    // Complexity: O(n) - n is the number of nodes in the tree
    static <T> void inOrder(BinaryTreeNode<T> root, ArrayList<T> path) {
        if (root == null) return;

        inOrder(root.left, path);
        path.add(root.data);
        inOrder(root.right, path);
    }

    static <T> BinaryTreeNode<T> balancedTree(ArrayList<T> path, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) >>> 1;  // same as divide by 2
        BinaryTreeNode<T> node = new BinaryTreeNode<>(path.get(mid));
        node.left = balancedTree(path, start, mid - 1);
        node.right = balancedTree(path, mid + 1, end);

        return node;
    }

    static <T> BinaryTreeNode<T> balanceBST(BinaryTreeNode<T> root) {
        ArrayList<T> sorted = new ArrayList<>();
        inOrder(root, sorted);
        return balancedTree(sorted, 0, sorted.size() - 1);
    }

    public static void main(String[] args) {
        // root = [1,null,2,null,3,null,4,null,null]
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.right = new BinaryTreeNode<>(2);
        root.right.right = new BinaryTreeNode<>(3);
        root.right.right.right = new BinaryTreeNode<>(4);
        System.out.println(root);

        System.out.println(balanceBST(root));  // [2,1,3,null,null,null,4]
    }
}
