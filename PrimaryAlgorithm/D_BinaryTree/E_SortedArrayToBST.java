package D_BinaryTree;

import java.util.Objects;

public class E_SortedArrayToBST {
    static class Solution {
        static TreeNode sortedArrayToBST(int[] nums) {
            if (nums.length == 0)
                return null;
            int currentNodeValIndex = nums.length / 2;
            TreeNode result = new TreeNode(nums[currentNodeValIndex]);
            sortedArrayToSubtree(result, nums, 0, currentNodeValIndex, nums.length);
            return result;
        }

        static void sortedArrayToSubtree(TreeNode parentNode, int[] array, int startIndex, int parentNodeValIndex, int endIndex) {
            if (startIndex != parentNodeValIndex) {
                int leftNodeValIndex = (startIndex + parentNodeValIndex) / 2;
                parentNode.left = new TreeNode(array[leftNodeValIndex]);
                sortedArrayToSubtree(parentNode.left, array, startIndex, leftNodeValIndex, parentNodeValIndex);
            } else {
                parentNode.left = null;
            }
            if (parentNodeValIndex + 1 != endIndex) {
                int rightNodeValIndex = (parentNodeValIndex + 1 + endIndex) / 2;
                parentNode.right = new TreeNode(array[rightNodeValIndex]);
                sortedArrayToSubtree(parentNode.right, array, parentNodeValIndex + 1, rightNodeValIndex, endIndex);
            } else {
                parentNode.right = null;
            }
        }
    }

    public static void main(String[] args) {
        assert Objects.equals(TreeNode.Tree(0, -3, 9, -10, null, 5), Solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
        assert Objects.equals(TreeNode.Tree(), Solution.sortedArrayToBST(new int[]{}));
    }
}
