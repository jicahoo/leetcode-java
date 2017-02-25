package com.flash.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangj52 on 2/19/2017.
 */
public class Q148_SortList {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * One time pass. But only beat 3%. It seems that this is not nlog(n), since the partition is O(n).
     */
    public static class Solution {

        public ListNode sortList(ListNode head) {
            //Merge sort
            if (head == null || head.next == null) {
                return head;
            }

            List<ListNode> list = partition(head);
            ListNode left = list.get(0);
            ListNode right = list.get(1);
            left = sortList(left);
            right = sortList(right);
            ListNode sortedHead = merge(left, right);
            return sortedHead;
        }

        public ListNode merge(ListNode left, ListNode right) {
            ListNode sortedHead = null;
            ListNode tail = null;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    if (tail != null) {
                        tail.next = left;
                        left = left.next;
                        tail.next.next = null;
                        tail = tail.next;
                    } else {
                        sortedHead = left;
                        tail = left;
                        left = left.next;
                        tail.next = null;
                    }
                } else {
                    if (tail != null) {
                        tail.next = right;
                        right = right.next;
                        tail.next.next = null;
                        tail = tail.next;
                    } else {
                        sortedHead = right;
                        tail = right;
                        right = right.next;
                        tail.next = null;
                    }
                }
            }

            while (left != null) {
                tail.next = left;
                left = left.next;
                tail.next.next = null;
                tail = tail.next;
            }

            while (right != null) {
                tail.next = right;
                right = right.next;
                tail.next.next = null;
                tail = tail.next;
            }
            return sortedHead;
        }

        public List<ListNode> partition(ListNode head) {
            List<ListNode> list = new ArrayList<>();
            ListNode left = null;
            ListNode right = null;

            ListNode p = head;
            boolean tag = true;
            ListNode leftLastNode = null;
            ListNode rightLastNode = null;

            while (p != null) {
                ListNode next = p.next;
                if (tag) {
                    if (left == null) {
                        left = p;
                        leftLastNode = p;
                    } else {
                        p.next = left;
                        left = p;
                    }
                    tag = false;
                } else {
                    if (right == null) {
                        right = p;
                        rightLastNode = p;
                    } else {
                        p.next = right;
                        right = p;

                    }
                    tag = true;
                }
                p = next;
            }

            if (leftLastNode != null) {
                leftLastNode.next = null;
            }

            if (rightLastNode != null) {
                rightLastNode.next = null;
            }

            list.add(left);
            list.add(right);
            return list;
        }
    }


    public static class SolutionSecond {

        public ListNode sortList(ListNode head) {
            //Merge sort
            if (head == null || head.next == null) {
                return head;
            }
            List<ListNode> list = new ArrayList<>();
            ListNode p = head;
            while (p != null) {
                list.add(p);
                p = p.next;
            }

            List<ListNode> sortedList = sortList(list, 0, list.size() - 1);

            ListNode sortedHead = sortedList.get(0);
            ListNode tail = sortedHead;
            for (int i = 1; i < sortedList.size(); i++) {
                tail.next = sortedList.get(i);
                tail = tail.next;
            }

            sortedList.get(sortedList.size()-1).next = null;
            return sortedHead;
        }

        public List<ListNode> sortList(List<ListNode> list, int start, int end) {
            //Ending condition: some .
            // Before this function: start < end. So start,mid; mid+1, end. will end with start = end.
            // There won't be start > end.
            if (start == end) {

                List<ListNode> result = new ArrayList<>();
                result.add(list.get(start));
                return result;
            }

            int mid = (start + end) / 2;
            List<ListNode> left = sortList(list, start, mid);
            List<ListNode> right = sortList(list, mid + 1, end);
            return merge(left, right);
        }

        public List<ListNode> merge(List<ListNode> left, List<ListNode> right) {

            List<ListNode> result = new ArrayList<>();

            int i = 0;
            int j = 0;
            while (i < left.size() && j < right.size()) {
                ListNode leftNode = left.get(i);
                ListNode rightNode = right.get(j);
                if (leftNode.val < rightNode.val) {
                    result.add(leftNode);
                    i++;
                } else {
                    result.add(rightNode);
                    j++;
                }
            }
            for (; i < left.size(); i++) {
                result.add(left.get(i));
            }
            for (; j < right.size(); j++) {
                result.add(right.get(j));
            }

            return result;
        }
    }

    public static class SolutionThird {

        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            //Partition
            ListNode first = head;
            ListNode second = head.next;
            ListNode p = head;
            ListNode q = head.next;

            while(true) {
                /*First kind ending.
                if (p == null || q == null) {
                    break;
                }*/
                //Second kind ending. Just like head check.
                if (p == null || p.next == null) {
                    break;
                }

                //Odd ones
                if(p.next != null) {
                    p.next = p.next.next;
                    p = p.next;
                }

                //Even ones
                if(q.next != null) {
                    q.next = q.next.next;
                    q = q.next;
                }
            }


            ListNode sortedFirst = sortList(first);
            ListNode sortedSecond = sortList(second);

            ListNode mergedHead = merge(sortedFirst, sortedSecond);
            return mergedHead;
        }

        public ListNode merge(ListNode first, ListNode second) {

            //Sentinel element, doesn't need null check, then make program more clear.
            ListNode head = new ListNode(0);
            ListNode tail = head;

            ListNode p = first;
            ListNode q = second;
            while (p != null && q != null) {
                if (p.val < q.val) {
                    tail.next = p;
                    tail = tail.next;
                    p = p.next;
                    tail.next = null;
                } else {
                    tail.next = q;
                    tail = tail.next;
                    q = q.next;
                    tail.next = null;
                }
            }
            while (p != null) {
                tail.next = p;
                tail = tail.next;
                p = p.next;
                tail.next = null;
            }

            while (q != null) {
                tail.next = q;
                tail = tail.next;
                q = q.next;
                tail.next = null;
            }
            return head.next;
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(3);
        ListNode next = new ListNode(2);
        root.next = next;
        next.next = new ListNode(1);
        SolutionThird s = new SolutionThird();
        ListNode sorted = s.sortList(root);
        while (sorted != null) {
            System.out.println(sorted.val);
            sorted = sorted.next;
        }
    }
}
