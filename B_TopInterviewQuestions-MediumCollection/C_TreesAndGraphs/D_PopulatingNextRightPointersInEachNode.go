package main

import "reflect"

type Node struct {
	Val   int
	Left  *Node
	Right *Node
	Next  *Node
}

func connectRecursive(root *Node) *Node {
	if root == nil {
		return root
	}
	var connectSub func(left *Node, right *Node, next *Node)
	connectSub = func(left *Node, right *Node, next *Node) {
		if left != nil {
			left.Next = right
			if right == nil {
				connectSub(left.Left, left.Right, nil)
			} else {
				connectSub(left.Left, left.Right, right.Left)
			}
		}
		if right != nil {
			right.Next = next
			if next == nil {
				connectSub(right.Left, right.Right, nil)
			} else {
				connectSub(right.Left, right.Right, next.Left)
			}
		}
	}
	connectSub(root.Left, root.Right, nil)
	return root
}

func connect(root *Node) *Node {
	if root == nil {
		return root
	}
	current := root
	for current.Left != nil {
		nextLineHeader := current.Left
		for current != nil {
			current.Left.Next = current.Right
			if current.Next != nil {
				current.Right.Next = current.Next.Left
			}
			current = current.Next
		}
		current = nextLineHeader
	}
	return root
}

func main() {
	node7 := &Node{Val: 7}
	node6 := &Node{Val: 6, Next: node7}
	node5 := &Node{Val: 5, Next: node6}
	node4 := &Node{Val: 4, Next: node5}
	node3 := &Node{Val: 3, Left: node6, Right: node7}
	node2 := &Node{Val: 2, Left: node4, Right: node5, Next: node3}
	root := &Node{Val: 1, Left: node2, Right: node3}
	tree := &Node{
		Val: 1,
		Left: &Node{
			Val:   2,
			Left:  &Node{Val: 4},
			Right: &Node{Val: 5},
		},
		Right: &Node{
			Val:   3,
			Left:  &Node{Val: 6},
			Right: &Node{Val: 7},
		},
	}
	println(reflect.DeepEqual(connectRecursive(tree), root))
	tree = &Node{
		Val: 1,
		Left: &Node{
			Val:   2,
			Left:  &Node{Val: 4},
			Right: &Node{Val: 5},
		},
		Right: &Node{
			Val:   3,
			Left:  &Node{Val: 6},
			Right: &Node{Val: 7},
		},
	}
	println(reflect.DeepEqual(connect(tree), root))
}
