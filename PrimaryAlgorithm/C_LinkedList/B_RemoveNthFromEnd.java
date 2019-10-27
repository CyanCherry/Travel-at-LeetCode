package C_LinkedList;

import java.util.Objects;

public class B_RemoveNthFromEnd {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        static ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode currentNode = head;
            if (n == 1) {
                if (currentNode.next == null)
                    return null;
                while (currentNode.next.next != null) {
                    currentNode = currentNode.next;
                }
                currentNode.next = null;
                return head;
            } else {
                while (n > 1) {
                    n--;
                    if (currentNode.next == null)
                        return head;
                    else
                        currentNode = currentNode.next;
                }
                ListNode nodeToBeDeleted;
                nodeToBeDeleted = head;
                while (currentNode.next != null) {
                    nodeToBeDeleted = nodeToBeDeleted.next;
                    currentNode = currentNode.next;
                }
                nodeToBeDeleted.val = Objects.requireNonNull(nodeToBeDeleted.next).val;
                nodeToBeDeleted.next = nodeToBeDeleted.next.next;
                return head;
            }
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode head = Solution.removeNthFromEnd(node1, 2);
        assert head != null;
        assert head.next.next.val == 3;
        head = Solution.removeNthFromEnd(node1, 1);
        assert head != null;
        assert head.next.next.val == 3;
        assert head.next.next.next == null;
        ListNode singleNode = new ListNode(1);
        singleNode.next = null;
        head = Solution.removeNthFromEnd(singleNode, 1);
        assert head == null;
    }
}
