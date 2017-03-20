package com.flash.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.Vector;

import static org.junit.Assert.assertEquals;

/**
 * Created by zhangj52 on 3/20/2017.
 */
public class Q155_MinStack {

    /**
     * Beats 80%. Time Complexity O(1). Space Complexity O(n).
     */
    public static class MinStack {
        public static class StackNode {
            public int getVal() {
                return val;
            }

            public void setVal(int val) {
                this.val = val;
            }

            public int getMinVal() {
                return minVal;
            }

            public void setMinVal(int minVal) {
                this.minVal = minVal;
            }

            public StackNode(int val, int minVal) {
                this.val = val;
                this.minVal = minVal;
            }

            private int val;
            private int minVal;
        }

        private Deque<StackNode> stack ;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new ArrayDeque<>();
        }

        public void push(int x) {
            StackNode topNode = stack.peek();
            if (topNode == null) {
                StackNode node = new StackNode(x, x);
                stack.push(node);
            } else {
                int minVal = topNode.getMinVal();
                int newMinValue = minVal;
                if (x < minVal) {
                    newMinValue = x;
                }
                StackNode node = new StackNode(x, newMinValue);
                stack.push(node);
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            if (stack.isEmpty()) {
                return 0;//?
            }else {
                return stack.peek().getVal();
            }
        }

        public int getMin() {
            if (stack.isEmpty()) {
                return 0; // ?
            } else {
                return stack.peek().getMinVal();
            }
        }
    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(2);
        minStack.push(4);
        minStack.push(5);
        minStack.push(0);
        assertEquals(0, minStack.getMin());
        minStack.pop();
        assertEquals(2, minStack.getMin());
        minStack.push(0);
        assertEquals(0, minStack.getMin());
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        assertEquals(3, minStack.getMin());


    }

}
