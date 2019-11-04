package C_LinkedList;

public class A_DeleteNode {
    static class Solution {
        static void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    public static void main(String[] args) {
        ListNode list = ListNode.linkedList(4, 5, 1, 9);
        Solution.deleteNode(list.next);
        ListNode.assertList(list, 4, 1, 9);
        list = ListNode.linkedList(4, 5, 1, 9);
        Solution.deleteNode(list.next.next);
        ListNode.assertList(list, 4, 5, 9);
    }
}
