import { TreeNode } from "./TreeNode.ts"

function lowestCommonAncestor(root: TreeNode | null, p: TreeNode | null, q: TreeNode | null): TreeNode | null {
    if (root === null) {
        return null
    }
    if (p === null) {
        return q
    }
    if (q === null) {
        return p
    }
    if (p === q) {
        return p
    }

    function search(node: TreeNode): { foundP: boolean, foundQ: boolean, ancestor: TreeNode | null } {
        const result: ReturnType<typeof search> = { foundP: false, foundQ: false, ancestor: null }
        if (node.left !== null) {
            const leftResult = search(node.left)
            if (leftResult.ancestor !== null) {
                return leftResult
            }
            result.foundP ||= leftResult.foundP
            result.foundQ ||= leftResult.foundQ
        }
        if (node.right !== null) {
            const rightResult = search(node.right)
            if (rightResult.ancestor !== null) {
                return rightResult
            }
            result.foundP ||= rightResult.foundP
            result.foundQ ||= rightResult.foundQ
        }
        if (node === p) {
            result.foundP = true
        } else if (node === q) {
            result.foundQ = true
        }

        if (result.foundP && result.foundQ) {
            result.ancestor = node
        }
        return result
    }

    return search(root).ancestor
}

const node4 = new TreeNode(4)
const node5 = TreeNode.treeFrom(5, 6, 2, null, null, 7, node4)
const node1 = TreeNode.treeFrom(1, 0, 8)
const node3 = TreeNode.treeFrom(3, node5, node1)
console.log(node3 == lowestCommonAncestor(node3, node5, node1))
console.log(node5 == lowestCommonAncestor(node3, node5, node4))
