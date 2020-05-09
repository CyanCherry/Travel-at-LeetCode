package D_Trees;

import java.util.LinkedList;
import java.util.Queue;

public class C_SymmetricTree {
    static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> mirrorQueue = new LinkedList<>();
        queue.add(root.left);
        mirrorQueue.add(root.right);
        while (!queue.isEmpty() && !mirrorQueue.isEmpty()) {
            TreeNode node = queue.remove();
            TreeNode mirrorNode = mirrorQueue.remove();
            if (node == null && mirrorNode == null)
                continue;
            if (node == null || mirrorNode == null || node.val != mirrorNode.val)
                return false;
            queue.add(node.left);
            queue.add(node.right);
            mirrorQueue.add(mirrorNode.right);
            mirrorQueue.add(mirrorNode.left);
        }
        return queue.isEmpty() == mirrorQueue.isEmpty();
    }

    static boolean isSymmetricRecursive(TreeNode root) {
        return root == null || checkRecursive(root.left, root.right);
    }

    static boolean checkRecursive(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null || left.val != right.val)
            return false;
        return checkRecursive(left.left, right.right) && checkRecursive(left.right, right.left);
    }

    public static void main(String[] args) {
        System.out.println(Boolean.TRUE.equals(isSymmetric(TreeNode.Tree(1, 2, 2, 3, 4, 4, 3))));
        System.out.println(Boolean.FALSE.equals(isSymmetric(TreeNode.Tree(1, 2, 2, null, 3, null, 3))));
        System.out.println(Boolean.TRUE.equals(isSymmetricRecursive(TreeNode.Tree(1, 2, 2, 3, 4, 4, 3))));
        System.out.println(Boolean.FALSE.equals(isSymmetricRecursive(TreeNode.Tree(1, 2, 2, null, 3, null, 3))));

    }
}
