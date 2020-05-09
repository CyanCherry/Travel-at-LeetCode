package D_Trees;

public class B_ValidateBinarySearchTree {
    static boolean isValidBST(TreeNode root) {
        return check(Long.MIN_VALUE, root, Long.MAX_VALUE);
    }

    static private boolean check(long min, TreeNode node, long max) {
        if (node == null) {
            return true;
        }
        long value = node.val;
        if (value <= min || value >= max) {
            return false;
        }
        return check(min, node.left, value) && check(value, node.right, max);
    }

    public static void main(String[] args) {
        System.out.println(Boolean.TRUE.equals(isValidBST(TreeNode.Tree(2, 1, 3))));
        System.out.println(Boolean.TRUE.equals(isValidBST(TreeNode.Tree())));
        System.out.println(Boolean.FALSE.equals(isValidBST(TreeNode.Tree(5, 1, 4, null, null, 3, 6))));
        System.out.println(Boolean.FALSE.equals(isValidBST(TreeNode.Tree(10, 5, 15, null, null, 6, 20))));
    }
}
