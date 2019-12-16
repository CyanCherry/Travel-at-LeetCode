package D_Trees;

import java.util.*;

public class D_LevelOrder {
    static class Solution {
        static List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new LinkedList<>();
            Solution.levelTraversal(result, root, 0);
            return result;
        }

        static void levelTraversal(List<List<Integer>> result, TreeNode treeNode, int level) {
            if (treeNode == null)
                return;
            if (result.size() <= level)
                result.add(new LinkedList<>());
            result.get(level).add(treeNode.val);
            levelTraversal(result, treeNode.left, level + 1);
            levelTraversal(result, treeNode.right, level + 1);
        }
    }

    public static void main(String[] args) {
        if (!Solution.levelOrder(TreeNode.Tree(3, 9, 20, null, null, 15, 7)).equals(
                new ArrayList<>(Arrays.asList(
                        new ArrayList<>(Collections.singletonList(3)),
                        new ArrayList<>(Arrays.asList(9, 20)),
                        new ArrayList<>(Arrays.asList(15, 7))
                ))
        )) throw new AssertionError();

        if (!Solution.levelOrder(TreeNode.Tree()).equals(new ArrayList<>())) throw new AssertionError();
    }
}
