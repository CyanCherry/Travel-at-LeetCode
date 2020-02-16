package D_Tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val &&
                Objects.equals(left, treeNode.left) &&
                Objects.equals(right, treeNode.right);
    }

    static TreeNode Tree(Integer... nodeValues) {
        if (nodeValues.length == 0)
            return null;
        TreeNode treeNode = new TreeNode(nodeValues[0]);
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(treeNode);
        int index = 1;
        for (; index + 1 < nodeValues.length; index += 2) {
            TreeNode current = treeNodes.remove();
            if (current == null) {
                if (nodeValues[index] != null || nodeValues[index + 1] != null)
                    throw new AssertionError("Expect null as placeholder.");
                treeNodes.add(null);
                treeNodes.add(null);
            } else {
                current.left = nodeValues[index] == null ? null : new TreeNode(nodeValues[index]);
                current.right = nodeValues[index + 1] == null ? null : new TreeNode(nodeValues[index + 1]);
                treeNodes.add(current.left);
                treeNodes.add(current.right);
            }
        }
        if (index < nodeValues.length) {
            TreeNode current = treeNodes.remove();
            current.left = nodeValues[index] == null ? null : new TreeNode(nodeValues[index]);
            current.right = null;
        }
        while (!treeNodes.isEmpty()) {
            TreeNode current = treeNodes.remove();
            if (current != null) {
                current.left = null;
                current.right = null;
            }
        }
        return treeNode;
    }
}
