package D_Trees;

import java.util.*;

public class D_BinaryTreeLevelOrderTraversal {
    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        List<TreeNode> nodes = new LinkedList<>();
        if (root != null) {
            nodes.add(root);
        }
        while (!nodes.isEmpty()) {
            List<TreeNode> newNodes = new LinkedList<>();
            List<Integer> levelResult = new LinkedList<>();
            nodes.forEach(node -> {
                levelResult.add(node.val);
                if (node.left != null) {
                    newNodes.add(node.left);
                }
                if (node.right != null) {
                    newNodes.add(node.right);
                }
            });
            result.add(levelResult);
            nodes = newNodes;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(
            levelOrder(TreeNode.Tree(3, 9, 20, null, null, 15, 7))
                .equals(
                    new ArrayList<>(Arrays.asList(
                        new ArrayList<>(Collections.singletonList(3)),
                        new ArrayList<>(Arrays.asList(9, 20)),
                        new ArrayList<>(Arrays.asList(15, 7))
                    ))
                )
        );

        System.out.println(levelOrder(TreeNode.Tree()).equals(new ArrayList<>()));
    }
}
