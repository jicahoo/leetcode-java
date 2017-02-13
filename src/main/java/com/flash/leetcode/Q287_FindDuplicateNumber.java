package com.flash.leetcode;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * https://leetcode.com/problems/find-the-duplicate-number/?tab=Solutions
 * http://keithschwarz.com/interesting/code/?dir=find-duplicate
 *
 * It still has more clear way with O(n*log(n)). Check the Solutions part of leetcode.
 * Created on 2/13/2017.
 */
public class Q287_FindDuplicateNumber {
    /**
     * Key point, think the value in array it the pointer. So the nums[nums[i]], just like a pointer operation.
     * So it
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        if (nums.length < 1) {
            return -1;
        }
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;

    }
}
