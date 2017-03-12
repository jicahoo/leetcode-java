package com.flash.leetcode;

/**
 * Created by zhangj52 on 3/12/2017.
 */
public class Q5_LongestPalindromicSubstring {

    public static class Solution {
        /**
         * Beats 32%. The time complexity: O(n*n), the space complexity: O(1).
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            int max = 0;
            int startIdx = -1;
            int endIdx = -1;
            for (int i = 0; i < s.length(); i++) {
                int[] rets = find(s, i);
                int len = rets[0];
                if (len > max) {
                    max = len;
                    startIdx = rets[1];
                    endIdx = rets[2];
                }
            }
            return s.substring(startIdx, endIdx + 1);
        }

        public int[] find(String s, int i) {
            int retLen = 0;
            int retStartIdx = -1;
            int retEndIdx = -1;

            //Try case one.  i|
            int left = i;
            int right = i + 1;
            int counter = 0;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    counter++;
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            if (counter > 0) {
                retLen = counter * 2;

                // When loop ending, The status of left and right.
                // s[left] != s[right]. But s[left+1] == s[right-1]
                // left = -1
                // right = s.length().
                // In any case, the left+1, right-1, is the inclusive bound [left+1, right-1] for target sub string.
                // Firstly,
                // I wrote retStartIdx = left == -1 ? 0: left;
                //         retEndIdx = right == s.length() ? len(s) -1 : right;
                // Be sure and exact on the var status when loop ending.
                retStartIdx = ++left;
                retEndIdx = --right;
            }


            //Try case two  <-i->
            left = i - 1;
            right = i + 1;
            counter = 0;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    counter++;
                    left--;
                    right++;
                } else {
                    break;
                }
            }

            //Special case: forgot to add 1 in my first try.
            if ((counter * 2 + 1) > retLen) {
                retLen = counter * 2 + 1;
                retStartIdx = ++left;
                retEndIdx = --right;
            }
            //Try case three |i

            left = i - 1;
            right = i;
            counter = 0;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    counter++;
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            if (counter > 0) {
                if (counter * 2 > retLen) {
                    retLen = counter * 2;
                    retStartIdx = --left;
                    retEndIdx = ++right;
                }
            }

            return new int[]{retLen, retStartIdx, retEndIdx};
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("a"));
        System.out.println(s.longestPalindrome("babad"));
        System.out.println(s.longestPalindrome("cbbd"));
    }
}
