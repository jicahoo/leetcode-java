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

    /**
     * Beats 64%. Better than above one. Why better than above one?
     * Time Complexity: O(n). Space Complexity: O(n)
     */
    public static class SolutionSecond {
        public void sortColors(int[] nums) {
            if (nums == null || nums.length == 0) {
                return ;
            }
            int[] b = new int[nums.length];
            int i =0;
            int j = nums.length - 1;
            for(int k=0; k < nums.length; k++) {
                if (nums[k] == 0) {
                    b[i++] = nums[k];
                } else if (nums[k] == 2) {
                    b[j--] = nums[k];
                }
            }
            for(int k = i; k <=j; k++) {
                b[k] = 1;
            }
            System.arraycopy(b, 0, nums,0, nums.length);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 1, 1, 2, 0, 1, 0, 1, 2, 2, 0, 0};
        SolutionSecond s = new SolutionSecond();
        s.sortColors(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();


    }
}
