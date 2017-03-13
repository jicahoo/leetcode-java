package com.flash.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zhangj52 on 3/13/2017.
 */
public class Q75_SortColors {

    /**
     * Only beats 6%.
     * Time Complexity: O(2n), 2 shouldn't be ignored for this one. Space Complexity: O(1)
     * TODO: More efficient way?
     */
    public static class Solution {
        public void sortColors(int[] nums) {
            int[] map = new int[]{0, 0, 0};

            for(int i = 0; i < nums.length; i++) {
                map[nums[i]]++;
            }

            int i = 0;
            for(int j = 0; j < map[0]; j++) {
                nums[i++] = 0;
            }

            for(int j = 0; j < map[1]; j++) {
                nums[i++] = 1;
            }

            for(int j = 0; j < map[2]; j++) {
                nums[i++] = 2;
            }
        }
    }

    public static class SolutionSecond {
        public void sortColors(int[] nums) {
            //TODO

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 1, 1, 2, 0, 1, 0, 1, 2, 2, 0, 0};
        Solution s = new Solution();
        s.sortColors(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();


    }
}
