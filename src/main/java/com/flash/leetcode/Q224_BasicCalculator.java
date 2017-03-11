package com.flash.leetcode;

import java.net.Inet4Address;
import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertEquals;

/**
 * Created by zhangj52 on 3/7/2017.
 */
public class Q224_BasicCalculator {

    public static class SolutionFirst {
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
                    operands.pop(); //Pop '('
                    char nextTopChar = operands.pop();
                    if (Character.isDigit(nextTopChar)) {
                        Character operator = operators.pop();
                        if (operator == '+') {
                            int result = (topChar -'0') + (nextTopChar - '0');
                            //convert to char and push
                            char temp = (char) (result + '0');
                            operands.push(temp);
                        } else if (operator == '-') {
                            int result = (topChar -'0') - (nextTopChar - '0');
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

    /**
     * Use Integer as operands. Use Character as operand is too confused.
     */
    public static class SolutionSecond {
        public int calculate(String s) {

            Deque<Integer> operands = new ArrayDeque<>();
            Deque<Character> operators = new ArrayDeque<>();
            operands.push(0);
            operators.push('+');

            char[] chars = s.toCharArray();
            int i = 0;
            while (i < chars.length) {

                char curChar = chars[i];
                if (curChar == '(') {
                    operands.push(Integer.MAX_VALUE);
                } else if (curChar == ')') {
                    Integer topInt = operands.pop();
                    operands.pop(); //Pop '('
                    Integer nextTopInt = operands.pop();
                    if (nextTopInt < Integer.MAX_VALUE) {
                        Character operator = operators.pop();
                        if (operator == '+') {
                            int result = nextTopInt +  topInt;
                            operands.push(result);
                        } else if (operator == '-') {
                            int result = nextTopInt - topInt;
                            operands.push(result);
                        }
                    } else {
                        operands.push(topInt);
                    }

                } else if (curChar == '+' || curChar == '-') {
                    operators.push(curChar);
                } else if (Character.isDigit(curChar)) {
                    Integer topChar = operands.peek();
                    if (topChar < Integer.MAX_VALUE) {
                        operands.pop();
                        Character operator = operators.pop();
                        if (operator == '+') {
                            int result = topChar + Character.getNumericValue(curChar);
                            //convert to char and push
                            operands.push(result);
                        } else if (operator == '-') {
                            int result = topChar - Character.getNumericValue(curChar);
                            //convert to char and push
                            operands.push(result);
                        }

                    } else if (topChar == Integer.MAX_VALUE) {
                        operands.push(Character.getNumericValue(curChar));
                    }
                }

                i++;
            }

            return operands.pop();

        }
    }

    /**
     * Handle mutiple digits
     */

    public static class SolutionThird {
        public int calculate(String s) {

            Deque<Integer> operands = new ArrayDeque<>();
            Deque<Character> operators = new ArrayDeque<>();
            operands.push(0);
            operators.push('+');

            char[] chars = s.toCharArray();
            int i = 0;
            while (i < chars.length) {

                char curChar = chars[i];
                if (curChar == '(') {
                    operands.push(Integer.MAX_VALUE);
                } else if (curChar == ')') {
                    Integer topInt = operands.pop();
                    operands.pop(); //Pop '('
                    Integer nextTopInt = operands.pop();
                    if (nextTopInt < Integer.MAX_VALUE) {
                        Character operator = operators.pop();
                        if (operator == '+') {
                            int result = nextTopInt +  topInt;
                            operands.push(result);
                        } else if (operator == '-') {
                            int result = nextTopInt - topInt;
                            operands.push(result);
                        }
                    } else {
                        operands.push(topInt);
                    }

                } else if (curChar == '+' || curChar == '-') {
                    operators.push(curChar);
                } else if (Character.isDigit(curChar)) {
                    int j = i;
                    while (j < chars.length && Character.isDigit(chars[j])) {
                        j++;
                    }

                    String x = new String(chars, i, j - i);
                    Integer nextInt = Integer.parseInt(x);
                    Integer topChar = operands.peek();
                    if (topChar < Integer.MAX_VALUE) {
                        operands.pop();
                        Character operator = operators.pop();
                        if (operator == '+') {
                            int result = topChar + nextInt;
                            //convert to char and push
                            operands.push(result);
                        } else if (operator == '-') {
                            int result = topChar - nextInt;
                            //convert to char and push
                            operands.push(result);
                        }
                    } else if (topChar == Integer.MAX_VALUE) {
                        operands.push(nextInt);
                    }
                    i = j;
                    continue;
                }

                i++;
            }

            return operands.pop();

        }
    }



    public static void main(String[] args) {
        //SolutionFirst s = new SolutionFirst();
        // SolutionSecond s = new SolutionSecond();
        SolutionThird s = new SolutionThird();

        System.out.println(s.calculate("1 + 1"));
        System.out.println(s.calculate(" 2-1 + 2 ") );
        System.out.println(s.calculate("1+(4+5+2)-3"));
        System.out.println(s.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(s.calculate("11 + 1"));
        System.out.println(s.calculate("11 + 20"));
        System.out.println(s.calculate("(12+(44+5-24)-88)+(20+87)"));



    }
}
