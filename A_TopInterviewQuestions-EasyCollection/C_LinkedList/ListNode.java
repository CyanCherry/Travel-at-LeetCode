package C_LinkedList;

import java.util.Objects;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    static ListNode linkedList(int... array) {
        if (array.length == 0)
            throw new IllegalArgumentException("0 numbers as parameter.");
        ListNode head = new ListNode(array[0]);
        ListNode current = head;
        for (int index = 1; index < array.length; index++) {
            current.next = new ListNode(array[index]);
            current = current.next;
        }
        current.next = null;
        return head;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ListNode)) {
            return false;
        }
        ListNode listNode = (ListNode) object;
        return val == listNode.val &&
            Objects.equals(next, listNode.next);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(this.val);
        ListNode current = this.next;
        while (current != null) {
            string.append("->");
            string.append(current.val);
            current = current.next;
        }
        return string.toString();
    }
}
