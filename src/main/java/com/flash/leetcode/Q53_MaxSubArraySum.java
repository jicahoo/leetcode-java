package com.flash.leetcode;

public class Q53_MaxSubArraySum {

    public int maxSubArray(int[] nums) {
        int maxSum = 0;
        int maxSumSoFar = 0;

        for (int i = 0; i < nums.length; i++) {
            int tempMaxSumSoFar = maxSumSoFar + nums[i];

            if (tempMaxSumSoFar > nums[i]) {
                maxSumSoFar = tempMaxSumSoFar;
            } else {
                maxSumSoFar = nums[i];
            }

            if (maxSumSoFar > maxSum) {
                maxSum = maxSumSoFar;
            }
        }

        return maxSum;

    }

    public static void main(String[] args) {
        Q53_MaxSubArraySum solution = new Q53_MaxSubArraySum();

        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(nums)); // 6

        nums = new int[]{6, -1, 9, 3, -2, 0, -8, 4, 7, 1};
        System.out.println(solution.maxSubArray(nums)); // 19
    }

}
