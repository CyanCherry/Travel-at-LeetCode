package C_LinkedList;

public class C_ReverseList {
    static class Solution {
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
            if (head == null)
                return null;
            else {
                return reverseListRecursive(null, head);
            }
        }

        static ListNode reverseListRecursive(ListNode head, ListNode next) {
            if (next == null) {
                return head;
            } else {
                ListNode nextNext = next.next;
                next.next = head;
                return reverseListRecursive(next, nextNext);
            }
        }
    }

    public static void main(String[] args) {
        ListNode list = ListNode.linkedList(1, 2, 3, 4, 5);
        ListNode.assertList(Solution.reverseList(list), 5, 4, 3, 2, 1);

        list = ListNode.linkedList(1, 2, 3, 4, 5);
        ListNode.assertList(Solution.reverseList(list), 5, 4, 3, 2, 1);
    }
}
