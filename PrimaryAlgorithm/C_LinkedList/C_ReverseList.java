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
        ListNode node1 = ListNode.get12345List();
        ListNode head = Solution.reverseList(node1);
        assert54321(head);

        node1 = ListNode.get12345List();
        head = Solution.reverseListRecursive(node1);
        assert54321(head);
    }

    private static void assert54321(ListNode head) {
        assert head.val == 5;
        assert head.next.val == 4;
        assert head.next.next.val == 3;
        assert head.next.next.next.val == 2;
        assert head.next.next.next.next.val == 1;
        assert head.next.next.next.next.next == null;
    }
}
