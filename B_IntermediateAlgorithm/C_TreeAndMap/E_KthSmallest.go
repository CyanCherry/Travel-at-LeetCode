package main

func kthSmallest(root *TreeNode, k int) int {
	var num, count int
	var middleOrderTraversal func(node *TreeNode)
	middleOrderTraversal = func(node *TreeNode) {
		if node != nil {
			if count < k {
				middleOrderTraversal(node.Left)
			}
			if count < k {
				num = node.Val
				count++
			}
			if count < k {
				middleOrderTraversal(node.Right)
			}
		}
	}
	middleOrderTraversal(root)
	return num
}

func main() {
	println(1 == kthSmallest(
		&TreeNode{
			Val: 3,
			Left: &TreeNode{
				Val:   1,
				Right: &TreeNode{Val: 4},
			},
			Right: &TreeNode{Val: 4},
		},
		1,
	))
	println(3 == kthSmallest(
		&TreeNode{
			Val: 5,
			Left: &TreeNode{
				Val: 3,
				Left: &TreeNode{
					Val:  2,
					Left: &TreeNode{Val: 1},
				},
				Right: &TreeNode{Val: 4},
			},
			Right: &TreeNode{Val: 6},
		},
		3,
	))
}
