package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func swapPairs(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	result := head.Next
	current := &ListNode{
		Next: head,
	}
	for current.Next != nil && current.Next.Next != nil {
		c, n := current.Next, current.Next.Next
		current.Next, c.Next, n.Next = n, n.Next, c
		current = current.Next.Next
	}
	return result
}

func main() {
	result := swapPairs(
		&ListNode{
			Val: 1,
			Next: &ListNode{
				Val: 2,
				Next: &ListNode{
					Val: 3,
					Next: &ListNode{
						Val: 4,
					},
				},
			},
		},
	)
	for result != nil {
		fmt.Print(result.Val)
		result = result.Next
	}
}
