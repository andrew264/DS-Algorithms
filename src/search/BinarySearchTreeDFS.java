package search;

import data_structures.BinaryTreeNode;

public class BinarySearchTreeDFS {
    // Binary Search Tree Depth First Search
    // Nodes in the left subtree are less than or equal the root node
    // Nodes in the right subtree are greater than the root node
    // Complexity: O(log(n)) if the tree is balanced
    // Complexity can be said as O(h), where h is the height of the tree
    static boolean dfs(BinaryTreeNode<Integer> root, int value) {
        if (root == null)
            return false;

        if (root.data.equals(value))  // we found the value
            return true;

        if (value > root.data)  // if the value is greater than the root, search the right subtree
            return dfs(root.right, value);

        return dfs(root.left, value);  // the value is less than the root, search the left subtree
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);
        root.left = new BinaryTreeNode<>(3);
        root.right = new BinaryTreeNode<>(7);
        root.left.left = new BinaryTreeNode<>(2);
        root.left.right = new BinaryTreeNode<>(4);
        root.right.left = new BinaryTreeNode<>(6);
        root.right.right = new BinaryTreeNode<>(8);
        System.out.println("Tree:" + "\n" + root);

        System.out.println("dfs(root, 5): " + dfs(root, 5));
        System.out.println("dfs(root, 3): " + dfs(root, 3));
        System.out.println("dfs(root, 11): " + dfs(root, 11));

    }
}
