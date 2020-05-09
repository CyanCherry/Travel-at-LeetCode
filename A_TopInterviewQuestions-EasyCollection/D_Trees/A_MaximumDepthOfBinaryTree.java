package D_Trees;

import java.util.LinkedList;
import java.util.List;

public class A_MaximumDepthOfBinaryTree {
    static int maxDepth(TreeNode root) {
        List<TreeNode> nodes = new LinkedList<>();
        if (root != null) {
            nodes.add(root);
        }
        int depth = 0;
        while (!nodes.isEmpty()) {
            depth++;
            List<TreeNode> newNodes = new LinkedList<>();
            nodes.forEach(node -> {
                if (node.left != null) {
                    newNodes.add(node.left);
                }
                if (node.right != null) {
                    newNodes.add(node.right);
                }
            });
            nodes = newNodes;
        }
        return depth;
    }

    public static void main(String[] args) {
        System.out.println(3 == maxDepth(TreeNode.Tree(3, 9, 20, null, null, 15, 7)));
        System.out.println(0 == maxDepth(TreeNode.Tree()));
        System.out.println(1 == maxDepth(TreeNode.Tree(1)));
    }
}
