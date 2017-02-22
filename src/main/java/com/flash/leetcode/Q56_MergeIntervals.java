package com.flash.leetcode;

import java.net.Inet4Address;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangj52 on 2/21/2017.
 */
public class Q56_MergeIntervals {

    // Definition for an interval.
    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static class Solution {
        public List<Interval> merge(List<Interval> intervals) {
            if (intervals.size() < 1) {
                return intervals;
            }

            intervals.sort((o1, o2) -> Integer.compare(o1.start, o2.start));

            List<Interval> result = new LinkedList<>();

            int start = intervals.get(0).start;
            int end = intervals.get(0).end;

            for (Interval interval : intervals) {
                if (interval.start <= end) {
                    end = Math.max(interval.end, end);
                } else {
                    result.add(new Interval(start, end));
                    start = interval.start;
                    end = interval.end;
                }
            }

            result.add(new Interval(start, end));

            return result;

        }
    }
}
