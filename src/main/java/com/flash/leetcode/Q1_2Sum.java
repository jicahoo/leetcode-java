package com.flash.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Good material: http://www.sigmainfy.com/blog/summary-of-ksum-problems.html
 * Created by zhangj52 on 2/11/2017.
 */
public class Q1_2Sum {

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length < 2) {
                return null;
            }

            int[] indices = null;

            Map<Integer, Integer> knownInts = new HashMap<>();
            knownInts.put(nums[0], 0);
            for (int i = 1; i < nums.length; i++) {
                int candidateNum = target - nums[i];
                if (knownInts.containsKey(candidateNum)) {
                    indices = new int[]{knownInts.get(candidateNum), i};
                    break;
                } else {
                    // First time, I forgot this else branch. So remember to write else, especially in the core logic.
                    knownInts.put(nums[i], i);
                }
            }

            return indices;
        }
}
