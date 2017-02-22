package com.flash.leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by zhangj52 on 2/19/2017.
 */
public class Q94_BinaryTreeInOrderTraversal {

     // Definition for a binary tree node.
     public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    /**
     * Only beats 3%.
     */
    public static class RecursiveSolution {
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            List<Integer> rootInorder = new LinkedList<>();
            TreeNode left = root.left;
            List<Integer> leftInorder = inorderTraversal(left);
            rootInorder.addAll(leftInorder);
            rootInorder.add(root.val);

            TreeNode right = root.right;
            List<Integer> rightInorder = inorderTraversal(right);
            rootInorder.addAll(rightInorder);
            return rootInorder;
        }
    }

    /**
     * Only beats 3%. And not concise. There is concise solution.
     * But mine is easy to understand, use one mark variable to remember the traverse direction: down or up.
     */
    public static class IterativeSolution {
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<Integer> rootInorder = new LinkedList<>();

            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.push(root);
            boolean down = true;
            while (!stack.isEmpty()) {
                TreeNode topNode = stack.peek();
                //Check its left
                TreeNode left = topNode.left;
                if (left != null && down) {
                    stack.push(left);
                } else {
                    rootInorder.add(topNode.val);
                    stack.pop();
                    down = false;
                    TreeNode right = topNode.right;
                    if (right != null) {
                        stack.push(topNode.right);
                        down = true;
                    }
                }
            }

            return rootInorder;

        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rightNode = new TreeNode(2);
        root.right = rightNode;
        TreeNode leftNode = new TreeNode(3);
        rightNode.left = leftNode;

        IterativeSolution is = new IterativeSolution();

        System.out.println(is.inorderTraversal(root));
    }

}
