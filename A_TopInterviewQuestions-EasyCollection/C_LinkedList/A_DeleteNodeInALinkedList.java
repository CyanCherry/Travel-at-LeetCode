package C_LinkedList;

public class A_DeleteNodeInALinkedList {
    static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode list = ListNode.linkedList(4, 5, 1, 9);
        deleteNode(list.next);
        System.out.println(list.equals(ListNode.linkedList(4, 1, 9)));

        list = ListNode.linkedList(4, 5, 1, 9);
        deleteNode(list.next.next);
        System.out.println(list.equals(ListNode.linkedList(4, 5, 9)));
    }
}
