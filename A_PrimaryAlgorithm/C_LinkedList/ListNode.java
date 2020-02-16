package C_LinkedList;

class ListNode {
    int val;
    ListNode next;

    private ListNode(int x) {
        val = x;
    }

    static ListNode linkedList(int... array) {
        if (array.length == 0)
            return null;
        ListNode head = new ListNode(array[0]);
        ListNode current = head;
        for (int index = 1; index < array.length; index++) {
            current.next = new ListNode(array[index]);
            current = current.next;
        }
        current.next = null;
        return head;
    }

    static void assertList(ListNode head, int... array) {
        for (int item : array) {
            assert head != null;
            assert head.val == item;
            head = head.next;
        }
        assert head == null;
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
