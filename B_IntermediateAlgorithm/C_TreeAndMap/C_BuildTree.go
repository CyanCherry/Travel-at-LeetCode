package main

import "reflect"

func buildTree(preorder []int, inorder []int) *TreeNode {
	if len(preorder) == 0 || len(inorder) == 0 {
		return nil
	}
	divider := -1
	for index, value := range inorder {
		if value == preorder[0] {
			divider = index
			break
		}
	}
	return &TreeNode{
		Val:   preorder[0],
		Left:  buildTree(preorder[1:divider+1], inorder[:divider]),
		Right: buildTree(preorder[divider+1:], inorder[divider+1:]),
	}
}

func main() {
	println(reflect.DeepEqual(
		buildTree([]int{3, 9, 20, 15, 7}, []int{9, 3, 15, 20, 7}),
		&TreeNode{
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
		},
	))
}
