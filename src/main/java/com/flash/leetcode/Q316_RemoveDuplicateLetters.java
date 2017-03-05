package com.flash.leetcode;

import java.net.Inet4Address;
import java.util.*;

/**
 * Created by zhangj52 on 2/26/2017.
 */
public class Q316_RemoveDuplicateLetters {


    /**
     * Just remove dups and order the remaining ones. Not answer to this question.
     */
    public static class SolutionOne {
        public String removeDuplicateLetters(String s) {
            boolean[] map = new boolean['z'];
            for (int i = 0; i < map.length; i++) {
                map[i] = false;
            }

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                map[ch] = true;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < map.length; i++) {
                if (map[i]) {
                    sb.append((char)i);
                }
            }
            return sb.toString();
        }
    }

    public static class SolutionTwo {
        /**
         * Time Complexity: O(n)
         * Space Complexity:O(n)
         * @param s
         * @return
         */
        public String removeDuplicateLetters(String s) {
            Set<Character> selectedCharsSet = new HashSet<>();
            List<Character> selectedChars = new LinkedList<>();
            LastIndexStruct lastIndexStruct = getLastIndexConstruct(s);

            int startIdx = 0;
            while (!lastIndexStruct.isEmpty()) {
                int curIdx = lastIndexStruct.nextIdx();
                int minAndUnselectedCharIdx = findMinAndUnselectedChar(s, startIdx, curIdx, selectedCharsSet);

                //Found target char and add to target data structure.
                char charSelected = s.charAt(minAndUnselectedCharIdx);
                selectedChars.add(charSelected);
                selectedCharsSet.add(charSelected);

                //Update var for next loop.
                startIdx = minAndUnselectedCharIdx + 1;
                if(lastIndexStruct.contain(charSelected)) {
                    lastIndexStruct.remove(charSelected);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (Character character : selectedChars) {
                sb.append(character);
            }
            return sb.toString();
        }

        /**
         *
         * Try to pick the right most elements.
         * Time Complexity: O(endIdx - startidx)
         * @param s
         * @param startIdx inclusive
         * @param endIdx inclusive
         * @return
         */
        public int findMinAndUnselectedChar(String s, int startIdx, int endIdx, Set<Character> selectedCharsSet) {

            char minChar = 0x1111;
            int idx = -1;
            for(int i = startIdx; i <=endIdx; i++) {
                char curChar = s.charAt(i);
                if (!selectedCharsSet.contains(curChar)) {
                    //Firstly, I used <=. It is wrong. We have to select left most, or we will miss some chars.
                    //The failed case is abacb when use <=. You can try it.
                    if (curChar < minChar) {
                        minChar = curChar;
                        idx = i;
                    }
                }
            }

            return idx;
        }

        /**
         * Time Complexity: O(n)
         * @param s
         * @return
         */
        public static LastIndexStruct getLastIndexConstruct(String s) {
            LastIndexStruct lastIndexStruct = new LastIndexStruct();
            Set<Character> charsDeduped = new HashSet<>();
            for(int i = 0; i < s.length(); i ++) {
                charsDeduped.add(s.charAt(i));
            }
            char[] chars = s.toCharArray();
            for(int i = chars.length-1; i >=0; i--) {
                char curChar = chars[i];
                if (charsDeduped.contains(curChar)) {
                    lastIndexStruct.add(i, curChar);
                    charsDeduped.remove(curChar);
                }
            }
            /*
            for (Character character : charsDeduped) {
                int lastIdx = s.lastIndexOf(character);
                lastIndexStruct.add(lastIdx, character);
            }
            */
            return lastIndexStruct;
        }

        public static class LastIndexStruct {
            Map<Character, Integer>  charToIdx ;

            public LastIndexStruct() {
                charToIdx = new HashMap<>();
            }


            public void add(int idx, Character character) {
                charToIdx.put(character, idx);
            }

            public boolean contain(Character character) {
                return charToIdx.containsKey(character);
            }

            public void remove(Character character) {
                charToIdx.remove(character);
            }

            public boolean isEmpty() {
                return charToIdx.isEmpty();
            }

            public int nextIdx(){
                //To use more efficient way.
                return Collections.min(charToIdx.values());
            }
        }

    }



    public static void main(String[] args) {
        SolutionTwo solutionTwo = new SolutionTwo();
        System.out.println(solutionTwo.removeDuplicateLetters("cbacdcbc"));
        System.out.println(solutionTwo.removeDuplicateLetters("bcabc"));
        System.out.println(solutionTwo.removeDuplicateLetters("baab"));
        System.out.println(solutionTwo.removeDuplicateLetters("ccacbaba"));
        System.out.println(solutionTwo.removeDuplicateLetters("abacb"));
    }
}
