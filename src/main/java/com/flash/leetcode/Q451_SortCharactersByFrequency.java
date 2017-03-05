package com.flash.leetcode;

import java.util.*;

/**
 * Created by zhangj52 on 3/5/2017.
 */
public class Q451_SortCharactersByFrequency {

    public static  class Solution {
        /**
         * Follow the Solutions. Use bucket sort.
         * Time Complexity: O(n)
         * Space Complexity: O(n).
         *
         * The bucket sort in this solution have two important attributes:
         * 1. It is like a map.
         * 2. It is also have order.
         * With these two attributes, it bring us the performance.
         * Comparing with map, the key is not in order, unless use TreeHashMap, you have to build the tree logn. Still slower.
         *
         * Reference: https://www.byvoid.com/zhs/blog/sort-radix
         *
         * @param s
         * @return
         */
        public String frequencySort(String s) {
            if (s == null || s.isEmpty()) {
                return s;
            }
            Map<Character, Integer> charToFreq = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char curChar = s.charAt(i);
                if (charToFreq.containsKey(curChar)) {
                    Integer freq = charToFreq.get(curChar);
                    charToFreq.put(curChar, freq + 1);
                } else {
                    charToFreq.put(curChar, 1);
                }
            }

            //O(n)
            Integer maxFreq = Collections.max(charToFreq.values());

            CharNode[] charNodeArray = new CharNode[maxFreq+1];
            for (Map.Entry<Character, Integer> entry : charToFreq.entrySet()) {
                char curChar = entry.getKey();
                int freq = entry.getValue();
                CharNode nodeTargetPlace = charNodeArray[freq];
                if (nodeTargetPlace != null) {
                    CharNode newNode = new CharNode(curChar);
                    newNode.next = nodeTargetPlace;
                    charNodeArray[freq] = newNode;
                } else {
                    charNodeArray[freq] = new CharNode(curChar);
                }
            }
            StringBuilder ret = new StringBuilder();
            for(int i = charNodeArray.length-1; i > 0; i--) {
                CharNode curCharNode = charNodeArray[i];
                while (curCharNode != null) {
                    for(int j = 0; j < i ; j++) {
                        ret.append(curCharNode.myChar);
                    }
                    curCharNode = curCharNode.next;
                }
            }
            return ret.toString();

        }

        public static class CharNode {
            private char myChar;
            private CharNode next;

            public CharNode(char myChar) {
                this.myChar = myChar;
                this.next = null;
            }

            public void append(CharNode charNode) {
                this.next = charNode;
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.frequencySort("tree"));
        System.out.println(solution.frequencySort("cccaaa"));
        System.out.println(solution.frequencySort("Aabb"));
        System.out.println(solution.frequencySort(""));

    }


}
