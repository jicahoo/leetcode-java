package com.flash.leetcode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by zhangj52 on 3/9/2017.
 */
public class Q125_ValidPalindrome {

    public static class Solution {
        public boolean isPalindrome(String s) {

            if (s.isEmpty()) {
                return true;
            }
            char[] chars = s.toCharArray();

            int i = 0;
            int j = chars.length - 1;

            while (i < j) {
                //Find next char from left
                while ( i < chars.length && !isAlphanumeric(chars[i]) ) {
                    i++;
                }
                //Find next char from right
                while ( j > -1 && !isAlphanumeric(chars[j])) {
                    j--;
                }

                //In remaining chars, they are all non-alpha. so deem it as true, just like empty string.
                if (i > j) {
                    return true;
                }

                if (Character.toLowerCase(chars[i]) == Character.toLowerCase(chars[j])) {
                    i++;
                    j--;
                } else {
                    return false;
                }

            }
            return true;

        }
        public boolean isAlphanumeric(char myChar) {
            return Character.isAlphabetic(myChar) || Character.isDigit(myChar);
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        assertTrue(s.isPalindrome(""));
        assertTrue(s.isPalindrome("Bab"));
        assertFalse(s.isPalindrome("OP")); //Failed case
        assertFalse(s.isPalindrome("0P"));
        assertTrue(s.isPalindrome("BBB"));
        assertTrue(s.isPalindrome("@#$%^&*()"));
        assertTrue(s.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(s.isPalindrome("race a car"));
        assertTrue(s.isPalindrome(".,"));
    }

}
