import { TreeNode } from "./TreeNode.ts"

function maxPathSum(root: TreeNode | null): number {
    let result = -Infinity

    function count(node: TreeNode | null): number {
        if (node === null) {
            return 0
        }
        const leftCount = count(node.left)
        const rightCount = count(node.right)
        const fullCount = leftCount + rightCount + node.val
        const maxBranch = Math.max(leftCount + node.val, rightCount + node.val, node.val)
        result = Math.max(result, maxBranch, fullCount)
        return maxBranch
    }

    count(root)
    return result
}

console.log(6 === maxPathSum(TreeNode.treeFrom(1, 2, 3)))
console.log(42 === maxPathSum(TreeNode.treeFrom(-10, 9, 20, null, null, 15, 7)))
console.log(-3 === maxPathSum(TreeNode.treeFrom(-3)))
console.log(2 === maxPathSum(TreeNode.treeFrom(2, -1)))
