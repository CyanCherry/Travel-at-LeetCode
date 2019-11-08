package D_BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    private TreeNode(int x) {
        val = x;
    }

    static TreeNode Tree(Integer... nodeValues) {
        if (nodeValues.length == 0)
            return null;
        TreeNode treeNode = new TreeNode(nodeValues[0]);
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(treeNode);
        for (int index = 1; index < nodeValues.length; index += 2) {
            TreeNode current = treeNodes.remove();
            if (current == null) {
                if (nodeValues[index] != null || nodeValues[index + 1] != null)
                    throw new AssertionError("Expect null.");
                treeNodes.add(null);
                treeNodes.add(null);
            } else {
                current.left = nodeValues[index] == null ? null : new TreeNode(nodeValues[index]);
                current.right = index + 1 < nodeValues.length ?
                        nodeValues[index + 1] == null ? null : new TreeNode(nodeValues[index + 1])
                        : null;
                treeNodes.add(current.left);
                treeNodes.add(current.right);
            }
        }
        while (!treeNodes.isEmpty()) {
            TreeNode current = treeNodes.remove();
            if(current!=null){
                current.left = null;
                current.right = null;
            }
        }
        return treeNode;
    }
}
