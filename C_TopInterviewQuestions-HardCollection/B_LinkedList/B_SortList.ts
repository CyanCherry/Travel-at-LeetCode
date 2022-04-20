import { ListNode } from "./ListNode.ts"

function sortList(head: ListNode | null): ListNode | null {
    if (head === null) {
        return null
    }
    let length = 0
    let current: ListNode | null = head
    while (current != null) {
        length++
        current = current.next
    }

    function sort(head: ListNode, length: number): ListNode {
        if (length === 1) {
            return head
        }

        // count length
        const halfLen = ~~(length / 2)
        let current: ListNode | null = head
        let index = 1
        let needSort = false
        while (index < halfLen) {
            if (!needSort && current!.val > current!.next!.val) {
                needSort = true
            }
            index++
            current = current!.next
        }

        // divide the list into two halves and sort each half
        let halfHead = current!.next
        current!.next = null
        if (needSort) {
            head = sort(head, halfLen)
        }
        halfHead = sort(halfHead!, length - halfLen)

        // merge the two sorted halves
        let halfCurrent: ListNode | null = halfHead
        current = head
        let result
        if (halfCurrent!.val < head.val) {
            result = halfCurrent
            halfCurrent = halfCurrent!.next
        } else {
            result = head
            current = current.next
        }
        let resultCurrent = result
        while (current != null && halfCurrent != null) {
            if (halfCurrent.val < current.val) {
                resultCurrent.next = halfCurrent
                halfCurrent = halfCurrent.next
            } else {
                resultCurrent.next = current
                current = current.next
            }
            resultCurrent = resultCurrent.next
        }
        if (current != null) {
            resultCurrent.next = current
        } else if (halfCurrent != null) {
            resultCurrent.next = halfCurrent
        }
        return result
    }

    return sort(head, length)
}

console.log(ListNode.listFrom(1, 2, 3, 4).listEquals(sortList(ListNode.listFrom(4, 2, 1, 3))))
console.log(ListNode.listFrom(-1, 0, 3, 4, 5).listEquals(sortList(ListNode.listFrom(-1, 0, 3, 4, 5))))
console.log(null == sortList(null))
