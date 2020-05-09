package G_Design;

import java.util.EmptyStackException;

public class B_MinStack {
    private static class StackNode {
        int value;
        int currentMin;
        StackNode next;

        StackNode(int value) {
            this.value = value;
            this.currentMin = value;
            this.next = null;
        }
    }

    private StackNode topNode;

    public B_MinStack() {
        this.topNode = null;
    }

    public void push(int x) {
        StackNode newNode = new StackNode(x);
        if (topNode != null && topNode.currentMin < x) {
            newNode.currentMin = topNode.currentMin;
        }
        newNode.next = topNode;
        topNode = newNode;
    }

    public void pop() {
        if (topNode == null) {
            throw new EmptyStackException();
        }
        topNode = topNode.next;
    }

    public int top() {
        if (topNode == null) {
            throw new EmptyStackException();
        }
        return topNode.value;
    }

    public int getMin() {
        if (topNode == null) {
            throw new EmptyStackException();
        }
        return topNode.currentMin;
    }

    public static void main(String[] args) {
        B_MinStack minStack = new B_MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin() == -3);
        minStack.pop();
        System.out.println(minStack.top() == 0);
        System.out.println(minStack.getMin() == -2);

        minStack = new B_MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin() == -2);
        System.out.println(minStack.top() == -1);
        minStack.pop();
        System.out.println(minStack.getMin() == -2);
    }
}
