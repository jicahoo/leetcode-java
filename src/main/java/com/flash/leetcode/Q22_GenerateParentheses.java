package com.flash.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangj52 on 2/19/2017.
 */
public class Q22_GenerateParentheses {

    /**
     * Beat 16%. According to the catalan number idea.
     * let f(n) as the result. T
     * f(n) = { '('f(0)')' f(n-1), '('f(1)')'f(n-2), .... , '('f(n-1)')'f(0)}
     */
    public static class Solution {

        List<List<String>> f = null;

        public List<String> generateParenthesis(int n) {

            if (f == null) {
                f = new ArrayList<>(n);
                f.add(0, Collections.emptyList());
                List<String> first = new LinkedList<>();
                first.add("()");
                f.add(1, first);
            }

            if (f.size() > n ) {
                return f.get(n);
            }

            List<String> result = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                List<String> left = generateParenthesis(i);
                List<String> right = generateParenthesis(n - i - 1);
                result.addAll(concat(left, right));
            }

            f.add(n, result);

            return result;
        }

        private List<String> concat(List<String> left, List<String> right) {
            List<String> result = new LinkedList<>();
            if (left.isEmpty()) {
                for (String str : right) {
                    result.add("()" + str);
                }
            } else {
                for (String leftStr : left) {
                    if (right.isEmpty()) {
                        result.add("(" + leftStr + ")");
                    } else {
                        for (String rightStr : right) {
                            result.add("(" + leftStr + ")" + rightStr);
                        }
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generateParenthesis(3));
    }
}
