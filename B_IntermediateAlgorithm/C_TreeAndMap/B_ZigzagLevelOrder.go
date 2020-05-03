package main

import "reflect"

func zigzagLevelOrder(root *TreeNode) [][]int {
	var nums [][]int
	if root == nil {
		return nums
	}
	isReverse := true
	var nodes []*TreeNode
	nodes = append(nodes, root)
	for len(nodes) > 0 {
		var newNodes []*TreeNode
		var numbers []int
		if isReverse {
			for _, node := range nodes {
				numbers = append(numbers, node.Val)
			}
		} else {
			for index := len(nodes) - 1; index > -1; index-- {
				node := nodes[index]
				numbers = append(numbers, node.Val)
			}
		}
		for _, node := range nodes {
			if node.Left != nil {
				newNodes = append(newNodes, node.Left)
			}
			if node.Right != nil {
				newNodes = append(newNodes, node.Right)
			}
		}
		nodes = newNodes
		isReverse = !isReverse
		nums = append(nums, numbers)
	}
	return nums
}

func main() {
	println(reflect.DeepEqual(
		[][]int{{3}, {20, 9}, {15, 7}},
		zigzagLevelOrder(&TreeNode{
			Val: 3,
			Left: &TreeNode{
				Val: 9,
			},
			Right: &TreeNode{
				Val: 20,
				Left: &TreeNode{
					Val: 15,
				},
				Right: &TreeNode{
					Val: 7,
				},
			},
		}),
	))
}
