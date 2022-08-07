package medium.designAStackWithIncrementOperation;

import java.util.Stack;

public class CustomStack {
    Stack<Integer> stack;
    int sizeOfStack;

    public CustomStack(int maxSize) {
        this.stack = new Stack<>();
        this.sizeOfStack = maxSize;
    }

    public void push(int x) {
        if (this.stack.size() < sizeOfStack) {
            this.stack.push(x);
        }
    }

    public int pop() {
        return this.stack.isEmpty() ? -1 : this.stack.pop();
    }

    public void increment(int k, int val) {
        Stack<Integer> temp = new Stack<>();

        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }

        while (!temp.isEmpty()) {
            int curr = temp.pop();

            if (k > 0) {
                curr += val;
                k--;
            }

            this.stack.push(curr);
        }
    }
}