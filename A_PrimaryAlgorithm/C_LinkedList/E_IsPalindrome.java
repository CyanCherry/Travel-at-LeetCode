package C_LinkedList;

import java.util.Stack;

public class E_IsPalindrome {
    static class Solution {
        static boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            Stack<Integer> firstHalfList = new Stack<>();
            while (fast != null && fast.next != null) {
                firstHalfList.push(slow.val);
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode secondHalf = fast == null ? slow : slow.next;
            while (!firstHalfList.empty() && secondHalf != null) {
                if (firstHalfList.pop() != secondHalf.val)
                    return false;
                secondHalf = secondHalf.next;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        if (Solution.isPalindrome(ListNode.linkedList(1, 2)))
            throw new AssertionError();
        if (!Solution.isPalindrome(ListNode.linkedList(1, 2, 2, 1)))
            throw new AssertionError();
        if (!Solution.isPalindrome(ListNode.linkedList(1, 2, 1, 2, 1)))
            throw new AssertionError();
        if (!Solution.isPalindrome(ListNode.linkedList(1, 2, 3, 2, 1)))
            throw new AssertionError();
        if (!Solution.isPalindrome(ListNode.linkedList(1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1)))
            throw new AssertionError();
        if (!Solution.isPalindrome(ListNode.linkedList(1)))
            throw new AssertionError();
        if (!Solution.isPalindrome(ListNode.linkedList()))
            throw new AssertionError();
    }
}
