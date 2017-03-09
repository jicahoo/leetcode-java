package com.flash.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by zhangj52 on 3/7/2017.
 */
public class Q224_BasicCalculator {

    public static class Solution {
        public int calculate(String s) {

            Deque<Character> operands = new ArrayDeque<>();
            Deque<Character> operators = new ArrayDeque<>();
            operands.push('0');
            operators.push('+');

            char[] chars = s.toCharArray();
            int i = 0;
            while (i < chars.length) {
                char curChar = chars[i];
                if (curChar == '(') {
                    operands.push(curChar);
                } else if (curChar == ')') {
                    char topChar = operands.pop();
                    operands.pop();
                    char nextTopChar = operands.pop();
                    if (Character.isDigit(nextTopChar)) {
                        Character operator = operators.pop();
                        if (operator == '+') {
                            int result = (topChar -'0') + (curChar - '0');
                            //convert to char and push
                            char temp = (char) (result + '0');
                            operands.push(temp);
                        } else if (operator == '-') {
                            int result = (topChar -'0') - (curChar - '0');
                            //convert to char and push
                            char temp = (char) (result + '0');
                            operands.push(temp);
                        }
                    } else {
                        operands.push(topChar);
                    }

                } else if (curChar == '+' || curChar == '-') {
                    operators.push(curChar);
                } else if (Character.isDigit(curChar)) {
                    Character topChar = operands.peek();
                    if (Character.isDigit(topChar)) {
                        operands.pop();
                        Character operator = operators.pop();
                        if (operator == '+') {
                            int result = (topChar -'0') + (curChar - '0');
                            //convert to char and push
                            char temp = (char) (result + '0');
                            operands.push(temp);
                        } else if (operator == '-') {
                            int result = (topChar -'0') - (curChar - '0');
                            //convert to char and push
                            char temp = (char) (result + '0');
                            operands.push(temp);
                        }

                    } else if (topChar == '(') {
                        operands.push(curChar);
                    }
                }
                i++;
            }

            return (operands.pop()-'0');

        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.calculate("1 + 1"));
        System.out.println(s.calculate(" 2-1 + 2 ") );
       // System.out.println(s.calculate("(1+(4+5+2)-3)+(6+8)") == 23);
    }
}
