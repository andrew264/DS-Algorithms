import java.util.ArrayList;

public class BinaryTreeTraversal {
    // Binary Tree Traversal (Depth-first search)
    // Given a binary tree, return the values of its nodes in pre-order, in-order, and post-order traversal.
    // It preserves tree structure while traversing the tree.
    // Complexity: O(n) - n is the number of nodes in the tree

    static <T> ArrayList<T> preOrder(BinaryTreeNode<T> root, ArrayList<T> path) {
        if (root == null)  // base case
            return path;

        // recursion
        // pre
        path.add(root.data);  // preOrder so we do at the beginning before left and right

        // recurse
        preOrder(root.left, path);
        preOrder(root.right, path);

        // post
        // nothing to do here

        return path;
    }

    static <T> ArrayList<T> inOrder(BinaryTreeNode<T> root, ArrayList<T> path) {
        if (root == null)  // base case
            return path;

        // recursion
        // pre
        // noting to do here

        // recurse
        inOrder(root.left, path);
        path.add(root.data);  // inOrder so we do in the middle after left and before right
        inOrder(root.right, path);

        // post
        // nothing to do here

        return path;

    }

    static <T> ArrayList<T> postOrder(BinaryTreeNode<T> root, ArrayList<T> path) {
        if (root == null)  // base case
            return path;

        // recursion
        // pre
        // noting to do here

        // recurse
        postOrder(root.left, path);
        postOrder(root.right, path);

        // post
        path.add(root.data);  // postOrder so we do at the end after left and right

        return path;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(6);
        root.right.right = new BinaryTreeNode<>(7);

        System.out.println("Tree:" + "\n" + root);

        System.out.println("Pre-order traversal: " + preOrder(root, new ArrayList<>())); // [1, 2, 4, 5, 3, 6, 7]
        System.out.println("In-order traversal: " + inOrder(root, new ArrayList<>()));  // [4, 2, 5, 1, 6, 3, 7]
        System.out.println("Post-order traversal: " + postOrder(root, new ArrayList<>()));  // [4, 5, 2, 6, 7, 3, 1]
    }


}
