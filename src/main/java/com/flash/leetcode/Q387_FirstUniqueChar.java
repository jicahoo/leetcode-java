package com.flash.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangj52 on 2/11/2017.
 */
public class Q387_FirstUniqueChar {
    public int firstUniqChar(String s) {

        /* What if s is very long. toCharArray will consume more memory. So I decided not to use such way to loop chars
        in String
        for (char x : s.toCharArray()) {

        }
        */
        /* Wrong.
        Map<Character, Integer> charCount = new HashMap<>();
        for(int i =0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (charCount.containsKey(currentChar)) {
                //Wrong here: I want to provide better solution. But forgot it will break the context.
                //since you remove the old data which will impact global predicate. aaab Then 1 will 2 which be the
                //answer wrongly.
                //wrong idea also has value for direction of correct ones. Don't fear.
                charCount.remove(currentChar);
            } else {
                charCount.put(currentChar, i);
            }
        }

        int smallestIdx = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            Integer curIdx = entry.getValue();
            if (smallestIdx > curIdx) {
                smallestIdx = curIdx;
            }
        }

        return smallestIdx == Integer.MAX_VALUE ? -1 : smallestIdx;
        */

        Map<Character, Integer> charCount = new HashMap<>();
        for(int i =0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (charCount.containsKey(currentChar)) {
                charCount.put(currentChar, -1);
            } else {
                charCount.put(currentChar, i);
            }
        }

        int smallestIdx = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            Integer curIdx = entry.getValue();
            if (curIdx != -1) {
                if (smallestIdx > curIdx) {
                    smallestIdx = curIdx;
                }
            }
        }

        return smallestIdx == Integer.MAX_VALUE ? -1 : smallestIdx;

    }
}
