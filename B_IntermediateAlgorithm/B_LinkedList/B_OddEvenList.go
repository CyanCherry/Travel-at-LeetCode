package main

import "fmt"

func oddEvenList(head *ListNode) *ListNode {
	// avoid unnecessary processing
	if head == nil || head.Next == nil || head.Next.Next == nil {
		return head
	}
	// deal with the first pair of nodes
	evenHead := head.Next
	evenCurrent := evenHead
	current := head.Next.Next
	head.Next = current
	// deal with nodes in pairs
	for current.Next != nil && current.Next.Next != nil {
		// append even node to even list
		evenCurrent.Next = current.Next
		evenCurrent = evenCurrent.Next
		// remove even node from origin list, and make current point to next odd node
		current.Next = current.Next.Next
		current = current.Next
	}
	// append the tailing node to even list
	if current.Next != nil {
		evenCurrent.Next = current.Next
		evenCurrent = evenCurrent.Next
	}
	// end even list and append it to origin list
	evenCurrent.Next = nil
	current.Next = evenHead
	return head
}

func main() {
	fmt.Println(ListFromDigits(1, 2, 3, 4, 5))
	println(oddEvenList(ListFromDigits(1, 2, 3, 4, 5)).String() == "1 => 3 => 5 => 2 => 4 => NULL")
	println(oddEvenList(ListFromDigits(2, 1, 3, 5, 6, 4, 7)).String() == "2 => 3 => 6 => 7 => 1 => 5 => 4 => NULL")
	println(oddEvenList(ListFromDigits(1, 2, 3, 4)).String() == "1 => 3 => 2 => 4 => NULL")
}
