package main

import "strconv"

type ListNode struct {
	Val  int
	Next *ListNode
}

func (node ListNode) String() string {
	if node.Next == nil {
		return strconv.FormatInt(int64(node.Val), 10) + " => NULL"
	} else {
		return strconv.FormatInt(int64(node.Val), 10) + " => " + node.Next.String()
	}
}

func ListFromInt(integer int) *ListNode {
	currentNode := &ListNode{
		Val:  integer % 10,
		Next: nil,
	}
	headNode := currentNode
	integer /= 10
	for integer > 0 {
		newNode := &ListNode{
			Val:  integer % 10,
			Next: nil,
		}
		currentNode.Next = newNode
		currentNode = newNode
		integer /= 10
	}
	return headNode
}

func (node *ListNode) ToInt() int {
	current := node
	weight := 1
	integer := 0
	for current != nil {
		integer += current.Val * weight
		weight *= 10
		current = current.Next
	}
	return integer
}
