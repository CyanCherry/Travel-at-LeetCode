package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func ListFromInt(integer int) *ListNode {
	currentNode := &ListNode{
		Val:  integer % 10,
		Next: nil,
	}
	headNode := currentNode
	for integer > 0 {
		integer /= 10
		newNode := &ListNode{
			Val:  integer % 10,
			Next: nil,
		}
		currentNode.Next = newNode
		currentNode = newNode
	}
	return headNode
}

func ListToInt(node *ListNode) int {
	weight := 1
	integer := 0
	for node != nil {
		integer += node.Val * weight
		weight *= 10
		node = node.Next
	}
	return integer
}
