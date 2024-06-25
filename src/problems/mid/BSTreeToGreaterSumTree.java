package problems.mid;

import data_structures.BinaryTreeNode;

public class BSTreeToGreaterSumTree {
    int prev=0;
    public BinaryTreeNode<Integer> bstToGst(BinaryTreeNode<Integer> root) {
        // similar to inOrder traversal but in reverse (i.e. right and then left)
        if (root == null)
            return null;
        if (root.right != null)
            bstToGst(root.right);
        root.data = root.data + prev;
        prev = root.data;
        if (root.left!= null)
            bstToGst(root.left);
        return root;
    }

    public static void main(String[] args) {
        // root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(4);
        root.left = new BinaryTreeNode<>(1);
        root.right = new BinaryTreeNode<>(6);
        root.left.left = new BinaryTreeNode<>(0);
        root.left.right = new BinaryTreeNode<>(2);
        root.left.right.right = new BinaryTreeNode<>(3);
        root.right.left = new BinaryTreeNode<>(5);
        root.right.right = new BinaryTreeNode<>(7);
        root.right.right.right = new BinaryTreeNode<>(8);
        System.out.println(root);

        BSTreeToGreaterSumTree bst = new BSTreeToGreaterSumTree();
        System.out.println(bst.bstToGst(root));  // [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
    }
}
