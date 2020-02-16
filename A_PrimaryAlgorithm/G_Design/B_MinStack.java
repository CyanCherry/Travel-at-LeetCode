package G_Design;

public class B_MinStack {
    static class MinStack {
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

        public MinStack() {
            this.topNode = null;
        }

        public void push(int x) {
            StackNode newNode = new StackNode(x);
            if (topNode != null && topNode.currentMin < x)
                newNode.currentMin = topNode.currentMin;
            newNode.next = topNode;
            topNode = newNode;
        }

        public void pop() {
            if (topNode != null)
                topNode = topNode.next;
        }

        public int top() {
            return topNode.value;
        }

        public int getMin() {
            return topNode.currentMin;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin() == -3);
        minStack.pop();
        System.out.println(minStack.top() == 0);
        System.out.println(minStack.getMin() == -2);

        minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin() == -2);
        System.out.println(minStack.top() == -1);
        minStack.pop();
        System.out.println(minStack.getMin() == -2);
    }
}
