export class TreeNode {
    val: number
    left: TreeNode | null
    right: TreeNode | null

    constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.left = (left === undefined ? null : left)
        this.right = (right === undefined ? null : right)
    }

    static invalidErr = new Error("invalid tree data")

    // number to build a tree branch, node to control the branch manually
    static treeFrom(...nodes: (number | TreeNode | null)[]): TreeNode {
        if (nodes.length == 0) {
            throw new Error("no nodes")
        }
        if (nodes[0] instanceof TreeNode) {
            if (nodes.length !== 1) {
                throw TreeNode.invalidErr
            }
            return nodes[0]
        } else if (nodes[0] == null) {
            throw TreeNode.invalidErr
        }
        const queue: TreeNode[] = []
        const head = new TreeNode(nodes[0])
        queue.push(head)
        let index = 1

        while (index < nodes.length && queue.length) {
            const currentNode = queue.shift()!
            const left = nodes[index++]
            if (typeof left === "number") {
                const leftNode = new TreeNode(left)
                currentNode.left = leftNode
                queue.push(leftNode)
            } else {
                currentNode.left = left
            }
            if (index < nodes.length) {
                const right = nodes[index++]
                if (typeof right === "number") {
                    const rightNode = new TreeNode(right)
                    currentNode.right = rightNode
                    queue.push(rightNode)
                } else {
                    currentNode.right = right
                }
            }
        }
        if (index != nodes.length) {
            throw TreeNode.invalidErr
        }
        return head
    }
}
