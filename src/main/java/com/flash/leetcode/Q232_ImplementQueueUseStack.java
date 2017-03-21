package com.flash.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

/**
 * Created by zhangj52 on 3/21/2017.
 */
public class Q232_ImplementQueueUseStack {
    public static class MyQueue {

        private Deque<Integer> stack;
        private int headVal;

        /** Initialize your data structure here. */
        public MyQueue() {
            stack = new LinkedList<>();
            headVal = 0;
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if (empty()) {
                headVal = x;
            }

            stack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            Deque<Integer> secondaryStack = new LinkedList<>();
            int ret = 0 ;
            int size = stack.size();
            for(int i = 0; i < size; i++) {
                Integer val = stack.pop();
                if (i == size - 1) {
                    ret = val;
                    break;
                }
                secondaryStack.push(val);

            }
            boolean isFirst = true;
            while (!secondaryStack.isEmpty()) {

                Integer topVal = secondaryStack.pop();
                if (isFirst) {
                    headVal = topVal;
                    isFirst = false;
                }
                stack.push(topVal);
            }
            return ret;
        }

        /** Get the front element. */
        public int peek() {
            return headVal;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack.isEmpty();
        }
    }


    //Just try the solutions provided in leetcode. Cooler, better and concise than mine.
    public static class MyQueueTwo {

        private Deque<Integer> inputs;
        private Deque<Integer> outputs;

        /** Initialize your data structure here. */
        public MyQueueTwo() {
            inputs = new ArrayDeque<>(); //LinkedList and ArrayDeque which is better for this case.
            outputs = new ArrayDeque<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            inputs.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            peek();
            return outputs.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (outputs.isEmpty()) {
                while (!inputs.isEmpty()) {
                    outputs.push(inputs.pop());
                }
            }
            return outputs.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return inputs.isEmpty() && outputs.isEmpty();
        }
    }



    public static void main(String[] args) {

        MyQueueTwo myQueue = new MyQueueTwo();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        assertEquals(1, myQueue.peek());
        assertEquals(1, myQueue.pop());
        assertEquals(2, myQueue.peek());
        assertEquals(2, myQueue.pop());
        assertEquals(3, myQueue.pop());
    }

}
