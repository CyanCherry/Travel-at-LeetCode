package main

import "strconv"

type ListNode struct {
	Val  int
	Next *ListNode
}

func ListFromDigits(digits ...int) *ListNode {
	if len(digits) == 0 {
		return nil
	}
	head := &ListNode{
		Val: digits[0],
	}
	current := head
	for _, digit := range digits[1:] {
		current.Next = &ListNode{
			Val: digit,
		}
		current = current.Next
	}
	return head
}

func (node ListNode) String() string {
	if node.Next == nil {
		return strconv.FormatInt(int64(node.Val), 10) + " => NULL"
	} else {
		return strconv.FormatInt(int64(node.Val), 10) + " => " + node.Next.String()
	}
}

func ListFromInt(integer int) *ListNode {
	head := &ListNode{
		Val:  integer % 10,
		Next: nil,
	}
	current := head
	for integer /= 10; integer > 0; integer /= 10 {
		current.Next = &ListNode{
			Val:  integer % 10,
			Next: nil,
		}
		current = current.Next
	}
	return head
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
