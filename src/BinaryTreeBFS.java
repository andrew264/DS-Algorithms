public class BinaryTreeBFS {
    // Breadth-first search
    // Given a binary tree, return true if the tree contains the given value.
    // tree structure is not preserved while traversing the tree.
    static <T> boolean breathFirstSearch(BinaryTreeNode<T> root, T value) {
        Queue<BinaryTreeNode<T>> queue = new Queue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> node = queue.dequeue();
            if (node == null)
                continue;

            if (node.data == value)
                return true;

            queue.enqueue(node.left);
            queue.enqueue(node.right);

        }
        return false;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(7);
        root.left = new BinaryTreeNode<>(13);
        root.right = new BinaryTreeNode<>(5);
        root.left.left = new BinaryTreeNode<>(11);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(17);
        root.right.right = new BinaryTreeNode<>(7);
        System.out.println("Tree:" + "\n" + root);
        System.out.println("Depth-first search for 17: " + breathFirstSearch(root, 17));  // true
        System.out.println("Depth-first search for 1: " + breathFirstSearch(root, 1));  // false

    }
}
