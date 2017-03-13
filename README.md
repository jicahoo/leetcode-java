# leetcode-java
As title. There is also Python version, see repo: pythonalgr.

## Q5: Longest palindromic sub string.
* Result: beat 32%. Time Complexity: O(n*n), Space Complexity: O(1)
* Better solution?

## Q22: TODO
* My way is too ugly. There is more concise and efficient way.

## Q75: TODO
* Only beats 6% with Time Complexity: O(2n), Space Complexity: O(1)

## Q94: TODO
* My way is OK.

## Q148: TODO.
* Linked List basic operation: split it to two halves in place.
* Sentinel element: use a fake head to avoid null check when you want to append element to list. Make program more clear.

## Q136: I tried about 3 times to finish it.
* Use the pen to write done every loop. Loop check condition, Loop initial var status, Loop Action, Loop Update.

```text
Loop: <Condition for continue>
    <Vars values in this timpe loop>
    <Checks and Action>
    <Update which data (loop vars, related data structes) after this iteration>

Loop 0: XXX
Loop 1: XXX
Loop 2: Complete(condition is not satisfied)
```

## Q208. Implement trie tree (a.k.a prefix tree)
* Result: beats 79%. Complexity Analysis: Time Complexity: insert/search O(len(word)), startsWith: O(len(prefix)). Space complexity: O(number of unique chars in input).
* I feel that it is easy to implement and should be a Easy question. However, it is marked as Medium.
* TODO: application of trie tree, suffix tree: http://blog.csdn.net/v_july_v/article/details/6897097 

## Q224. Basic calculator
* Use two stacks to simulate the way human's brain how to compute the expression.
* One stack is for operand, another stack is for operators. It is binary operation.

## Q315. TODO: Count of smallest numbers after itself.
*First try failed: Time Limit Exceeded.
* TODO.

## Q451: Use bucket sort.
* More details check source code. 
```java
        /**
         * Follow the Solutions. Use bucket sort.
         * Time Complexity: O(n)
         * Space Complexity: O(n).
         *
         * The bucket sort in this solution have two important attributes:
         * 1. It is like a map.
         * 2. It is also have order.
         * With these two attributes, it bring us the performance.
         * Comparing with map, the key is not in order, unless use TreeHashMap,
         * even use TreeMap, you have to build the tree with O(nlgn) time compexity. Still slower.
         *
         * Reference: https://www.byvoid.com/zhs/blog/sort-radix
         *
         * @param s
         * @return
         */
        public String frequencySort(String s) {
```
* Refernce https://www.byvoid.com/zhs/blog/sort-radix 

