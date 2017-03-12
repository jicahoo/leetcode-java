package com.flash.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by zhangj52 on 3/12/2017.
 */
public class Q315_CountOfSmallerNumbersAfterSelf {

    public static class SolutionFirst {
        public List<Integer> countSmaller(int[] nums) {
            if (nums == null || nums.length == 0) {
                return Collections.emptyList();
            }

            // List<Integer> rets = new ArrayList<>(nums.length); //wrong, because the in parameter means capacity.
            List<Integer> rets = Arrays.asList(new Integer[nums.length]);
            SortedSet<Integer> set = new TreeSet<>();
            for (int i = nums.length - 1; i >= 0; i--) {
                int num = nums[i];
                SortedSet<Integer> temp = set.headSet(num);
                rets.set(i, temp.size());
                set.add(num);
            }
            return rets;
        }
    }

    public static class SolutionSecond {

        /**
         * Result: SortedMap not found; Time limit exceeded.
         * Time complexity: O(n*max(logn+ number of possible deduped nums)). Nearly O(n*n).
         * Can we O(nlgn)?
         * Space complexity: O(n).
         * @param nums
         * @return
         */
        public List<Integer> countSmaller(int[] nums) {
            if (nums == null || nums.length == 0) {
                return Collections.emptyList();
            }

            // List<Integer> rets = new ArrayList<>(nums.length); //wrong, because the in parameter means capacity.
            List<Integer> rets = Arrays.asList(new Integer[nums.length]);
            //SortedSet<Integer> set = new TreeSet<>();


            SortedMap<Integer, Integer> mapForMetNums = new TreeMap<>();
            for (int i = nums.length - 1; i >= 0; i--) {
                int num = nums[i];
                //SortedMap<Integer, Integer> temp = map.headMap(num); //wrong. use temp name, cause error in following coding, should use above map. So DON'T use temp any where.
                SortedMap<Integer, Integer> subMapSmallerThanNum = mapForMetNums.headMap(num); //wrong. use temp name, cause error in following coding, should use above map. So DON'T use temp any where.

                Integer count = subMapSmallerThanNum.entrySet().stream().map(e -> e.getValue()).reduce(0, (a, b) -> a + b);
                rets.set(i, count);
                if (mapForMetNums.containsKey(num)) {
                    Integer value = mapForMetNums.get(num);
                    mapForMetNums.put(num, value + 1);
                } else {
                    //First, I use temp var name and cause range out error. Try google it but don't find proper answer, when you cannot find good answer in goodle. You should make a stupid mistake.
                    mapForMetNums.put(num, 1);
                }
            }
            return rets;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 6, 1};
        SolutionFirst s = new SolutionFirst();
        System.out.println(s.countSmaller(nums));
        int[] case2 = new int[]{5, 2, 6, 2, 1};
        System.out.println(s.countSmaller(case2));//wrong

        SolutionSecond ss = new SolutionSecond();
        System.out.println(ss.countSmaller(nums));
        System.out.println(ss.countSmaller(case2));
        int[] case3 = new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        System.out.println(ss.countSmaller(case3));


        //Wrong result for case:
        // [26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41]
        // reason: forgot the duplicate nums. Use Set wrongly.
    }

}
