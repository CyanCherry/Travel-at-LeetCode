package main

import "reflect"

func inorderTraversal(root *TreeNode) []int {
    var nums []int
    if root == nil {
        return nums
    }
    nodeStack := []*TreeNode{root}
    for len(nodeStack) > 0 {
        currentNode := *nodeStack[len(nodeStack)-1]
        nodeStack = nodeStack[:len(nodeStack)-1]
        if currentNode.Left != nil {
            nodeStack = append(nodeStack, &TreeNode{
                Val:   currentNode.Val,
                Left:  nil,
                Right: currentNode.Right,
            })
            nodeStack = append(nodeStack, currentNode.Left)
        } else {
            nums = append(nums, currentNode.Val)
            if currentNode.Right != nil {
                nodeStack = append(nodeStack, currentNode.Right)
            }
        }
    }
    return nums
}

func main() {
    println(reflect.DeepEqual(
        []int{1, 3, 2},
        inorderTraversal(&TreeNode{
            Val: 1,
            Right: &TreeNode{
                Val:  2,
                Left: &TreeNode{Val: 3},
            },
        }),
    ))
}
