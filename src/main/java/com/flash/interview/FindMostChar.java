package com.flash.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangj52 on 2/12/2017.
 */
public class FindMostChar {


    public Character findMostChar(String str) {

        int maxFreq = 0;
        Character mostChar = null;

        Map<Character, Integer> charCount = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);
            if (charCount.containsKey(curChar)) {
                Integer freq = charCount.get(curChar);
                charCount.put(curChar, ++freq);
            } else {
                charCount.put(curChar, 1);
            }
        }

        for (Map.Entry<Character, Integer> curEntry : charCount.entrySet()) {

            Integer freq = curEntry.getValue();
            Character charVal = curEntry.getKey();
            if (maxFreq < freq) {
                maxFreq = freq;
                mostChar = charVal;
            }

        }

        return mostChar;
    }

    public static void main(String[] args) {
        FindMostChar solution = new FindMostChar();

        System.out.println(solution.findMostChar("abc"));
        System.out.println(solution.findMostChar("abcb"));

        System.out.println(solution.findMostChar("kkkkkk"));



    }
}
