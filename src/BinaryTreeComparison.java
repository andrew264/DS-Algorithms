public class BinaryTreeComparison {
    // Given two binary trees, return true if they are structurally identical.
    // Complexity: O(n) - n is the number of nodes in the tree

    static <T> boolean compare(BinaryTreeNode<T> root1, BinaryTreeNode<T> root2) {
        if (root1 == null && root2 == null)  // base case - structurally identical
            return true;

        if (root1 == null || root2 == null)  // base case  - not structurally identical
            return false;

        if (!root1.equals(root2))  // if the data is not equal, return false
            return false;

        // recurse
        boolean left = compare(root1.left, root2.left);
        boolean right = compare(root1.right, root2.right);

        return left && right;  // return true if both left and right are true
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root1 = new BinaryTreeNode<>(1);
        root1.left = new BinaryTreeNode<>(2);
        root1.right = new BinaryTreeNode<>(3);
        root1.left.left = new BinaryTreeNode<>(4);
        root1.left.right = new BinaryTreeNode<>(5);
        root1.right.left = new BinaryTreeNode<>(6);
        root1.right.right = new BinaryTreeNode<>(7);

        BinaryTreeNode<Integer> root2 = new BinaryTreeNode<>(1);
        root2.left = new BinaryTreeNode<>(2);
        root2.right = new BinaryTreeNode<>(3);
        root2.left.left = new BinaryTreeNode<>(4);
        root2.left.right = new BinaryTreeNode<>(5);
        root2.right.left = new BinaryTreeNode<>(6);
        root2.right.right = new BinaryTreeNode<>(7);

        System.out.println("Tree 1:" + "\n" + root1);
        System.out.println("Tree 2:" + "\n" + root2);
        System.out.println("Compare: " + compare(root1, root2) + "\n");  // true

        root2.left.left.left = new BinaryTreeNode<>(11);
        root2.left.left.right = new BinaryTreeNode<>(8);
        System.out.println("Tree 1:" + "\n" + root1);
        System.out.println("Tree 2:" + "\n" + root2);
        System.out.println("Compare: " + compare(root1, root2));  // false

    }
}
