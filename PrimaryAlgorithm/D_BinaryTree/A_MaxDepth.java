package D_BinaryTree;

public class A_MaxDepth {
    static class Solution {
        static int maxDepth(TreeNode root) {
            return maxDepth(root, 0);
        }

        static int maxDepth(TreeNode node, int depth) {
            if (node == null)
                return depth;
            int leftDepth = maxDepth(node.left, depth + 1);
            int rightDepth = maxDepth(node.right, depth + 1);
            return Math.max(leftDepth, rightDepth);
        }
    }

    public static void main(String[] args) {
        if (3 != Solution.maxDepth(TreeNode.Tree(3, 9, 20, null, null, 15, 7)))
            throw new AssertionError();
        if (0 != Solution.maxDepth(TreeNode.Tree()))
            throw new AssertionError();
        if (1 != Solution.maxDepth(TreeNode.Tree(1)))
            throw new AssertionError();
    }
}
