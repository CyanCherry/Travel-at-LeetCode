package C_LinkedList;

import java.util.HashSet;

public class F_HasCycle {
    static class Solution {
        static boolean hasCycle(ListNode head) {
            HashSet<ListNode> listNodes = new HashSet<>();
            while (head != null) {
                if (listNodes.contains(head))
                    return true;
                listNodes.add(head);
                head = head.next;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        ListNode test1 = ListNode.linkedList(3, 2, 0, -4);
        assert test1 != null;
        test1.next.next.next.next = test1.next;
        assert Solution.hasCycle(test1);
        ListNode test2 = ListNode.linkedList(1, 2);
        assert test2 != null;
        test2.next.next = test2;
        assert Solution.hasCycle(test2);
    }
}
