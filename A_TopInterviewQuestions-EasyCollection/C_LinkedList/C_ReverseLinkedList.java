package C_LinkedList;

public class C_ReverseLinkedList {
    static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode current = head;
            head = head.next;
            current.next = newHead;
            newHead = current;
        }
        return newHead;
    }

    static ListNode reverseListRecursive(ListNode head) {
        return reverseListRecursive(head, null);
    }

    static ListNode reverseListRecursive(ListNode node, ListNode next) {
        if (node == null) {
            return next;
        } else {
            ListNode nodeNext = node.next;
            node.next = next;
            return reverseListRecursive(nodeNext, node);
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseList(ListNode.linkedList(1, 2, 3, 4, 5)).equals(ListNode.linkedList(5, 4, 3, 2, 1)));
        System.out.println(reverseListRecursive(ListNode.linkedList(1, 2, 3, 4, 5)).equals(ListNode.linkedList(5, 4, 3, 2, 1)));
    }
}
