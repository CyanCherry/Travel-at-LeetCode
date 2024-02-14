package main

import (
	"fmt"
	"reflect"
	"sort"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

type StatefulNode struct {
	Node *TreeNode
	Row  int
	Col  int
}

type LinkNode struct {
	SNode *StatefulNode
	Next  *LinkNode
}

func verticalTraversal(root *TreeNode) [][]int {
	current := &LinkNode{
		SNode: &StatefulNode{
			Node: root,
			Row:  0,
			Col:  0,
		},
		Next: nil,
	}
	end := current
	pivot := 0
	result := [][]*StatefulNode{}
	for current != nil {
		i := current.SNode.Col + pivot
		if i < 0 {
			result = append(
				make([][]*StatefulNode, -i),
				result...,
			)
			pivot = pivot - i
			i = 0
		}
		if i >= len(result) {
			result = append(
				result,
				make([][]*StatefulNode, i-len(result)+1)...,
			)
		}
		result[i] = append(result[i], current.SNode)
		if current.SNode.Node.Left != nil {
			end.Next = &LinkNode{
				SNode: &StatefulNode{
					Node: current.SNode.Node.Left,
					Row:  current.SNode.Row + 1,
					Col:  current.SNode.Col - 1,
				},
				Next: nil,
			}
			end = end.Next
		}
		if current.SNode.Node.Right != nil {
			end.Next = &LinkNode{
				SNode: &StatefulNode{
					Node: current.SNode.Node.Right,
					Row:  current.SNode.Row + 1,
					Col:  current.SNode.Col + 1,
				},
				Next: nil,
			}
			end = end.Next
		}
		current = current.Next
	}
	for _, nodes := range result {
		sort.Slice(nodes, func(i, j int) bool {
			if nodes[i].Row == nodes[j].Row {
				return nodes[i].Node.Val < nodes[j].Node.Val
			}
			return nodes[i].Row < nodes[j].Row
		})
	}
	r := make([][]int, len(result))
	for i := 0; i < len(result); i++ {
		r[i] = make([]int, len(result[i]))
		for j := 0; j < len(result[i]); j++ {
			r[i][j] = result[i][j].Node.Val
		}
	}
	return r
}

func main() {
	fmt.Println(reflect.DeepEqual([][]int{
		{9}, {3, 15}, {20}, {7},
	}, verticalTraversal(&TreeNode{
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
	fmt.Println(reflect.DeepEqual([][]int{
		{4}, {2}, {1, 5, 6}, {3}, {7},
	}, verticalTraversal(&TreeNode{
		Val: 1,
		Left: &TreeNode{
			Val: 2,
			Left: &TreeNode{
				Val:   4,
				Left:  nil,
				Right: nil,
			},
			Right: &TreeNode{
				Val:   5,
				Left:  nil,
				Right: nil,
			},
		},
		Right: &TreeNode{
			Val: 3,
			Left: &TreeNode{
				Val:   6,
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
	fmt.Println(reflect.DeepEqual([][]int{
		{4}, {2}, {1, 5, 6}, {3}, {7},
	}, verticalTraversal(&TreeNode{
		Val: 1,
		Left: &TreeNode{
			Val: 2,
			Left: &TreeNode{
				Val:   4,
				Left:  nil,
				Right: nil,
			},
			Right: &TreeNode{
				Val:   6,
				Left:  nil,
				Right: nil,
			},
		},
		Right: &TreeNode{
			Val: 3,
			Left: &TreeNode{
				Val:   5,
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
}
