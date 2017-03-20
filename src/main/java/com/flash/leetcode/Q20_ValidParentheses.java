package com.flash.leetcode;

import java.io.CharConversionException;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by zhangj52 on 3/20/2017.
 */
public class Q20_ValidParentheses {
    public static class Solution {
        public boolean isValid(String s) {
            if (s == null || s.isEmpty()) {
                return true;
            }
            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                Character curChar = s.charAt(i);
                if (curChar.equals('(') || curChar.equals('[') || curChar.equals('{')) {
                    stack.push(curChar);
                } else {
                    Character topChar = stack.peek();
                    if (topChar == null) {
                        return false;
                    }

                    if (curChar.equals(')')) {
                        if ('(' != topChar) {
                            return false;
                        }
                    } else if (curChar.equals(']')) {
                        if ('[' != topChar) {
                            return false;
                        }

                    } else if (curChar.equals('}')) {
                        if ('{' != topChar) {
                            return false;
                        }
                    }

                    stack.pop();
                }
            }

            return stack.isEmpty();

        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //Error case will throw Null PointerExecption when I didn't add check topChar == null.
        //in line 32: '[' != topChar will cause NullPointer. You know char <-> Character. Why? Need to know.
        s.isValid("]");
    }
}
