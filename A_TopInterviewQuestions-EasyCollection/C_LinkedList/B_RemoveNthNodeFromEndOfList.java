package C_LinkedList;

public class B_RemoveNthNodeFromEndOfList {
    static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        ListNode pioneer = head;
        ListNode operator = head;
        while (n-- > 0 && pioneer != null) {
            pioneer = pioneer.next;
        }
        if (pioneer == null) {
            return n > 0 ? head : head.next;
        }
        while (pioneer.next != null) {
            pioneer = pioneer.next;
            operator = operator.next;
        }
        operator.next = operator.next.next;
        return head;
    }

    public static void main(String[] args) {
        System.out.println(removeNthFromEnd(ListNode.linkedList(1, 2, 3, 4, 5), 2).equals(ListNode.linkedList(1, 2, 3, 5)));
        System.out.println(removeNthFromEnd(ListNode.linkedList(1, 2, 3, 4, 5), 1).equals(ListNode.linkedList(1, 2, 3, 4)));
        System.out.println(removeNthFromEnd(ListNode.linkedList(1), 1) == null);
        System.out.println(removeNthFromEnd(ListNode.linkedList(1, 2), 1).equals(ListNode.linkedList(1)));
        System.out.println(removeNthFromEnd(ListNode.linkedList(1, 2), 2).equals(ListNode.linkedList(2)));
    }
}
