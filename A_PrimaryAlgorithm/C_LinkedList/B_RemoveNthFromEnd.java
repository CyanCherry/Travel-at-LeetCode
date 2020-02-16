package C_LinkedList;

import java.util.Objects;

public class B_RemoveNthFromEnd {
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
        ListNode list = ListNode.linkedList(1, 2, 3, 4, 5);
        ListNode.assertList(Solution.removeNthFromEnd(list, 2), 1, 2, 3, 5);
        list = ListNode.linkedList(1);
        ListNode.assertList(Solution.removeNthFromEnd(list, 1));
    }
}
