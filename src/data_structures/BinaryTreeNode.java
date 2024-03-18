package data_structures;

public class BinaryTreeNode<T> {
    public final T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public boolean equals(BinaryTreeNode<T> other) {
        return data.equals(other.data);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringHelper(this, sb, "", ""); // Call the helper for a visually structured output
        return sb.toString();
    }

    private void toStringHelper(BinaryTreeNode<T> node, StringBuilder sb, String prefix, String childPrefix) {
        if (node == null) {
//            sb.append("null\n");
            return;
        }

        sb.append(prefix).append(node.data).append("\n");
        toStringHelper(node.left, sb, childPrefix + "├── ", childPrefix + "│   "); // Left child with connecting line
        toStringHelper(node.right, sb, childPrefix + "└── ", childPrefix + "    "); // Right child indented
    }
}
