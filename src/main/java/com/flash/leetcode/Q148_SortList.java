package com.flash.leetcode;

/**
 * Created by zhangj52 on 2/19/2017.
 */
public class Q148_SortList {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static class Solution {

        public ListNode sortList(ListNode head) {
            //Merge sort
            //TODO
            return null;

        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(3);
        ListNode next = new ListNode(2);
        root.next = next;
        next.next = new ListNode(1);
        Solution s = new Solution();
        ListNode sorted = s.sortList(root);
        System.out.println(sorted);

    }
}
