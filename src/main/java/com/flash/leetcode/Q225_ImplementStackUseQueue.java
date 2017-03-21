package com.flash.leetcode;

import java.util.Deque;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

/**
 * Created by zhangj52 on 3/21/2017.
 */
public class Q225_ImplementStackUseQueue {

    /**
     * Only beats 49%.
     */
    public static class MyStack {

        private Deque<Integer> queue;

        /** Initialize your data structure here. */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.addLast(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            Integer ret = 0;
            int size = queue.size();
            for(int i =0; i < size; i++) {
                Integer val = queue.poll();
                if (i == size - 1) {
                    ret = val;
                    break;
                }
                queue.addLast(val);
            }
            return ret;
        }

        /** Get the top element. */
        public int top() {
            Integer ret = 0;
            int size = queue.size();
            for(int i =0; i < size; i++) {
                Integer val = queue.poll();
                if (i == size - 1) {
                    ret = val;
                }
                queue.addLast(val);
            }
            return ret;

        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    /**
     * Beats 30%. Should be better than above one. Why?
     * Leetcode is not stable the second submit beats 90%.
     */
    public static class MyStackTwo {

        private Deque<Integer> queue;
        private int topElement;

        /** Initialize your data structure here. */
        public MyStackTwo() {
            queue = new LinkedList<>();
            topElement = 0;
        }

        /** Push element x onto stack. */
        public void push(int x) {
            topElement = x;
            queue.addLast(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            Integer ret = 0;
            int size = queue.size();
            int lastPushValue = 0;
            for(int i =0; i < size; i++) {
                Integer val = queue.poll();
                if (i == size - 1) {
                    ret = val;
                    break;
                }
                queue.addLast(val);
                lastPushValue = val;
            }
            topElement = lastPushValue;
            return ret;
        }

        /** Get the top element. */
        public int top() {
            return topElement;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStackTwo s = new MyStackTwo();
        s.push(1);
        s.push(2);
        s.push(3);
        assertEquals(3, s.top());
        s.pop();
        assertEquals(2, s.top());
        assertEquals(false, s.empty());

    }
}
