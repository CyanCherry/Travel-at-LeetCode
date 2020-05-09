package C_LinkedList;

public class F_LinkedListCycle {
    static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode test1 = ListNode.linkedList(3, 2, 0, -4);
        test1.next.next.next.next = test1.next;
        System.out.println(Boolean.TRUE.equals(hasCycle(test1)));
        ListNode test2 = ListNode.linkedList(1, 2);
        test2.next.next = test2;
        System.out.println(Boolean.TRUE.equals(hasCycle(test2)));
    }
}
