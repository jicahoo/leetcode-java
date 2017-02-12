package com.flash.leetcode;

/**
 * Created on 2/12/2017.
 */
public class Q206_ReverseLinkedList {

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /* Iteratively version.
    public ListNode reverseList(ListNode head) {
        ListNode newList = null;
        ListNode oldList = head;
        while (oldList != null) {

            //Step 2 of thought: Found newList was overwritten, need a temp var to keep it, since we still need the
            // info of already formed newList.
            ListNode tempNewList = newList;

            //Step 1 of thought: Goal is to update newList.
            newList = oldList;

            //Step 3 of thought: move the first node of oldList off the head by moving head pointer.
            oldList = oldList.next;

            //Step 4 of thought: Let the newList(new head) point to already formed newList.
            newList.next = tempNewList;
        }
        return newList;

    }
    */

    // Recursive version. I cannot give the solution. And just reference the answer in leetcode.
    // In leetcode, this version (beats 33%)  is faster than iterative version (beats 3%).
    // Why? The assign operations are less?
    public ListNode reverseList(ListNode head) {
        return reverseListInt(head, null);
    }

    /**
     *
     * @param head current head in source List.
     * @param newHead current head in destination List.
     * @return
     */
    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null) {
            // We complete the work.
            return newHead;
        }


        ListNode next = head.next;
        head.next = newHead;

        return reverseListInt(next, head);

    }

}
