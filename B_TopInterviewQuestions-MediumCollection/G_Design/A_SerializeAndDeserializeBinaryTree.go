package main

import (
	"fmt"
	"strconv"
	"strings"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func (i *TreeNode) Equals(node *TreeNode) bool {
	if i == nil || node == nil {
		return i == node
	}
	if i.Val != node.Val {
		return false
	}
	return i.Left.Equals(node.Left) && i.Right.Equals(node.Right)
}

type Codec struct {
}

func Constructor() Codec {
	return Codec{}
}

//     1
//    / \
//   2   3
//	    / \
//     4   5
// 1,2,3,,,4,5

func (i *Codec) serialize(root *TreeNode) string {
	result := strings.Builder{}
	nodes := []*TreeNode{root}
	placeholder := 0
	for len(nodes) > 0 {
		node := nodes[0]
		nodes = nodes[1:]
		if node != nil {
			if placeholder > 0 {
				for i := 0; i < placeholder; i++ {
					result.WriteByte(',')
				}
				placeholder = 0
			}
			result.WriteString(strconv.Itoa(node.Val))
			result.WriteByte(',')
			nodes = append(nodes, node.Left, node.Right)
		} else {
			placeholder++
		}
	}
	return result.String()
}

func isDigit(char byte) bool {
	const START = '0' - 1
	const END = '9' + 1
	return START < char && char < END
}

func (i *Codec) deserialize(data string) *TreeNode {
	if len(data) == 0 {
		return nil
	}
	index := 0
	getVal := func() *int {
		if index >= len(data) {
			return nil
		}
		if data[index] == ',' {
			index++
			return nil
		}
		start := index
		if data[index] == '+' || data[index] == '-' {
			index++
		}
		for isDigit(data[index]) {
			index++
		}
		val, _ := strconv.Atoi(data[start:index])
		index++
		return &val
	}

	val := getVal()
	if val == nil {
		return nil
	}
	root := &TreeNode{Val: *val}

	nodes := make([]*TreeNode, 0, len(data)/2)
	nodes = append(nodes, root)
	for len(nodes) > 0 {
		node := nodes[0]
		nodes = nodes[1:]
		val := getVal()
		if val != nil {
			node.Left = &TreeNode{Val: *val}
			nodes = append(nodes, node.Left)
		}
		val = getVal()
		if val != nil {
			node.Right = &TreeNode{Val: *val}
			nodes = append(nodes, node.Right)
		}
	}
	return root
}

func main() {
	codec := Constructor()
	var root *TreeNode

	root = &TreeNode{
		Val:  1,
		Left: &TreeNode{Val: 2},
		Right: &TreeNode{
			Val:   3,
			Left:  &TreeNode{Val: 4},
			Right: &TreeNode{Val: 5},
		},
	}
	fmt.Println(root.Equals(codec.deserialize(codec.serialize(root))))

	root = &TreeNode{
		Val:  -1,
		Left: &TreeNode{Val: 2},
		Right: &TreeNode{
			Val:   3,
			Left:  &TreeNode{Val: -4},
			Right: &TreeNode{Val: 5},
		},
	}
	fmt.Println(root.Equals(codec.deserialize(codec.serialize(root))))

	root = &TreeNode{Val: 1}
	fmt.Println(root.Equals(codec.deserialize(codec.serialize(root))))

	root = &TreeNode{
		Val:  1,
		Left: &TreeNode{Val: 2},
	}
	fmt.Println(root.Equals(codec.deserialize(codec.serialize(root))))
}
