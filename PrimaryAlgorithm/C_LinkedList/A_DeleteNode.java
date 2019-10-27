package C_LinkedList;

public class A_DeleteNode {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        static void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node1 = new ListNode(1);
        ListNode node9 = new ListNode(9);
        node4.next = node5;
        node5.next = node1;
        node1.next = node9;
        node9.next = null;
        Solution.deleteNode(node5);
        assert node4.next.val == 1;
        node4.next = node5;
        node5.next = node1;
        node1.next = node9;
        node9.next = null;
        Solution.deleteNode(node1);
        assert node5.next.val == 9;
    }
}
