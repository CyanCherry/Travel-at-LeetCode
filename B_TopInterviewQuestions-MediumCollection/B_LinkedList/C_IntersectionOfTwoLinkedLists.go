package main

func getIntersectionNode(headA, headB *ListNode) *ListNode {
    currentA := headA
    currentB := headB
    listLen := func(node *ListNode) int {
        length := 0
        for node != nil {
            length++
            node = node.Next
        }
        return length
    }
    lenA := listLen(headA)
    lenB := listLen(headB)
    for lenA > lenB {
        currentA = currentA.Next
        lenA--
    }
    for lenB > lenA {
        currentB = currentB.Next
        lenB--
    }
    for currentA != nil {
        if currentA == currentB {
            return currentA
        }
        currentA = currentA.Next
        currentB = currentB.Next
    }
    return nil
}

func main() {
    // test case 1
    suffix1 := ListFromDigits(8, 4, 5)
    A1 := ListFromDigitsWithSuffix(suffix1, 4, 1)
    B1 := ListFromDigitsWithSuffix(suffix1, 5, 0, 1)
    println(getIntersectionNode(A1, B1) == suffix1)

    // test  case 2
    suffix2 := ListFromDigits(2, 4)
    A2 := ListFromDigitsWithSuffix(suffix2, 0, 9, 1)
    B2 := ListFromDigitsWithSuffix(suffix2, 3)
    println(getIntersectionNode(A2, B2) == suffix2)

    // test case 3
    suffix3 := ListFromDigits()
    A3 := ListFromDigitsWithSuffix(suffix3, 2, 6, 4)
    B3 := ListFromDigitsWithSuffix(suffix3, 1, 5)
    println(getIntersectionNode(A3, B3) == suffix3)

    // test case 3
    suffix4 := ListFromDigits(1)
    A4 := ListFromDigitsWithSuffix(suffix4)
    B4 := ListFromDigitsWithSuffix(suffix4)
    println(getIntersectionNode(A4, B4) == suffix4)
}
