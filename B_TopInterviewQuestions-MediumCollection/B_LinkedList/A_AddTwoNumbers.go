package main

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    headNode := &ListNode{}
    currentNode := headNode
    var overflow, sum int
    for l1 != nil || l2 != nil || overflow != 0 {
        sum = overflow
        if l1 != nil {
            sum += l1.Val
            l1 = l1.Next
        }
        if l2 != nil {
            sum += l2.Val
            l2 = l2.Next
        }
        overflow = sum / 10
        newNode := &ListNode{
            Val:  sum % 10,
            Next: nil,
        }
        currentNode.Next = newNode
        currentNode = newNode
    }
    return headNode.Next
}

func main() {
    println(addTwoNumbers(ListFromInt(342), ListFromInt(465)).ToInt() == 807)
    println(addTwoNumbers(ListFromInt(5), ListFromInt(5)).ToInt() == 10)
}
