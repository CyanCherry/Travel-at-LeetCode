package D_Trees;

public class B_IsValidBST {
    static class Solution {
        static boolean isValidBST(TreeNode root) {
            return check(Long.MIN_VALUE, root, Long.MAX_VALUE);
        }

        static boolean check(long min, TreeNode node, long max) {
            if (node == null)
                return true;
            int value = node.val;
            if (!(value > min && value < max))
                return false;
            if (!check(min, node.left, value))
                return false;
            return check(value, node.right, max);
        }
    }

    public static void main(String[] args) {
        if (!Solution.isValidBST(TreeNode.Tree(2, 1, 3)))
            throw new AssertionError();
        if (!Solution.isValidBST(TreeNode.Tree()))
            throw new AssertionError();
        if (Solution.isValidBST(TreeNode.Tree(5, 1, 4, null, null, 3, 6)))
            throw new AssertionError();
        if (Solution.isValidBST(TreeNode.Tree(10, 5, 15, null, null, 6, 20)))
            throw new AssertionError();
    }
}
