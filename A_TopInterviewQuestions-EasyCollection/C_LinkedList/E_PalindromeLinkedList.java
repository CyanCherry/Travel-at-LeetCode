package C_LinkedList;

public class E_PalindromeLinkedList {
    static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowLast = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode slowNext = slow.next;
            slow.next = slowLast;
            slowLast = slow;
            slow = slowNext;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null && slowLast != null) {
            if (slow.val != slowLast.val) {
                return false;
            }
            slow = slow.next;
            slowLast = slowLast.next;
        }
        return slow == null && slowLast == null;
    }

    public static void main(String[] args) {
        System.out.println(Boolean.FALSE.equals(isPalindrome(ListNode.linkedList(1, 2))));
        System.out.println(Boolean.TRUE.equals(isPalindrome(ListNode.linkedList(1, 2, 2, 1))));
        System.out.println(Boolean.TRUE.equals(isPalindrome(ListNode.linkedList())));
    }
}
