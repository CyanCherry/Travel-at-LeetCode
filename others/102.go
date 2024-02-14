package main

import (
	"fmt"
	"reflect"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

type LinkNode struct {
	Node *TreeNode
	Next *LinkNode
}

func levelOrder(root *TreeNode) [][]int {
	if root == nil {
		return nil
	}
	current := &LinkNode{
		Node: root,
		Next: &LinkNode{
			Node: nil,
			Next: nil,
		},
	}
	end := current.Next
	result := [][]int{}

	row := []int{}
	for current != nil {
		if current.Node == nil {
			result = append(result, row)
			row = []int{}
			if current.Next != nil {
				end.Next = &LinkNode{
					Node: nil,
					Next: nil,
				}
				end = end.Next
			}
		} else {
			row = append(row, current.Node.Val)
			if current.Node.Left != nil {
				end.Next = &LinkNode{
					Node: current.Node.Left,
					Next: nil,
				}
				end = end.Next
			}
			if current.Node.Right != nil {
				end.Next = &LinkNode{
					Node: current.Node.Right,
					Next: nil,
				}
				end = end.Next
			}
		}
		current = current.Next
	}
	return result
}

func main() {
	fmt.Println(reflect.DeepEqual([][]int{
		{3}, {9, 20}, {15, 7},
	}, levelOrder(&TreeNode{
		Val: 3,
		Left: &TreeNode{
			Val:   9,
			Left:  nil,
			Right: nil,
		},
		Right: &TreeNode{
			Val: 20,
			Left: &TreeNode{
				Val:   15,
				Left:  nil,
				Right: nil,
			},
			Right: &TreeNode{
				Val:   7,
				Left:  nil,
				Right: nil,
			},
		},
	})))
	fmt.Println(reflect.DeepEqual([][]int(nil), levelOrder(nil)))
}
