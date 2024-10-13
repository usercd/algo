import java.util.Stack;

/**
 * @author CD
 * @date 10/13/2024
 * @description
 */
public class Code155_MinStack {


    // 法一：使用一个栈和一个变量来维护最小值
    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;

    // 初始化两个栈
    public Code155_MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // 将元素推入栈，并维护最小栈
    public void push(int val) {
        stack.push(val);
        // 如果最小栈为空，或者当前值小于等于最小栈的栈顶，则将该值压入最小栈
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    // 弹出栈顶元素，同时维护最小栈
    public void pop() {
        // 如果栈顶元素等于最小栈的栈顶，则同时弹出最小栈
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    // 获取栈顶元素
    public int top() {
        return stack.peek();
    }

    // 获取最小元素
    public int getMin() {
        return minStack.peek();
    }

    // 法二单链表实现栈
    public static class StackNode {
        private int val;
        private int min;
        private StackNode next;
        StackNode() {
        }
        StackNode(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    private StackNode head;

    //public MinStack() {
    //}

    public void push2(int val) {
        if (null == head) {
            head = new StackNode(val, val);
        } else {
            StackNode node = new StackNode(val, Math.min(val, head.min));
            node.next = head;
            head = node;
        }
    }

    public void pop2() {
        if (null == head) {
            return;
        }
        head = head.next;
    }

    public int top2() {
        return head.val;
    }

    public int getMin2() {
        return head.min;
    }

}
