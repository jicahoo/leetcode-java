package com.flash.basic_algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by zhangj52 on 3/9/2017.
 */
public class Tree {

    public static class BinaryTreeNode {
        public Object value;
        public BinaryTreeNode left=null;
        public BinaryTreeNode right=null;
    }

    // TODO: Not find a way to track the depth of tree. Is it possible? Or should use other proper way.
    public void dfs(BinaryTreeNode root){
        BinaryTreeNode node = root;
        Deque<BinaryTreeNode> stack = new ArrayDeque<>();
        int depth = 1;
        while (node != null) {
            stack.push(node);
            System.out.println(indent(depth)+node.value);
            node = node.left;
        }

        while (!stack.isEmpty()) {

            BinaryTreeNode peekNode = stack.pop();

            //Check right node
            if (peekNode.right != null) {
                BinaryTreeNode oneNode = peekNode.right;
                while(oneNode != null) {
                    stack.push(oneNode);
                    depth++;
                    String indentStr = indent(depth);
                    System.out.println(indentStr + oneNode.value);
                    oneNode = oneNode.left;
                }
            }
        }

    }

    public void recursiveTreeDisplay(BinaryTreeNode root) {
        String treeStr = recursiveTreeDisplay(root, 1);
        System.out.println(treeStr);
    }

    //TODO: Iterative way?
    public String recursiveTreeDisplay(BinaryTreeNode root, int depth) {
        StringBuilder sb = new StringBuilder();
        sb.append(root.value).append("\n"); //Only need new line when print value, neither otherwise.
        if (root.left != null) {
            sb.append(indent(depth));
            sb.append((recursiveTreeDisplay(root.left, depth + 1)));
            //sb.append("\n");
        }
        if (root.right != null) {
            sb.append(indent(depth));
            sb.append((recursiveTreeDisplay(root.right, depth + 1)));
            //sb.append("\n");
        }
        return sb.toString();
    }

    public BinaryTreeNode simpleTree() {
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = "A";

        BinaryTreeNode bNode = new BinaryTreeNode();
        bNode.value = "B";

        BinaryTreeNode cNode = new BinaryTreeNode();
        cNode.value = "C";

        root.left = bNode;
        root.right = cNode;



        return root;
    }

    public BinaryTreeNode oneTree() {
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = "A";

        BinaryTreeNode bNode = new BinaryTreeNode();
        bNode.value = "B";

        BinaryTreeNode cNode = new BinaryTreeNode();
        cNode.value = "C";

        BinaryTreeNode dNode = new BinaryTreeNode();
        dNode.value = "D";

        BinaryTreeNode eNode = new BinaryTreeNode();
        eNode.value = "E";

        BinaryTreeNode fNode = new BinaryTreeNode();
        fNode.value = "F";

        BinaryTreeNode gNode = new BinaryTreeNode();
        gNode.value = "G";


        BinaryTreeNode hNode = new BinaryTreeNode();
        hNode.value = "H";

        BinaryTreeNode iNode = new BinaryTreeNode();
        iNode.value = "I";


        root.left = bNode;
        root.right = cNode;

        bNode.left = dNode;
        bNode.right = eNode;

        dNode.right = fNode;
        eNode.left = gNode;

        cNode.left = hNode;
        cNode.right = iNode;

        return root;

    }

    public String indent(int width) {
        return new String(new char[width]).replace("\0", "-");
    }

    public static void main(String[] args) {
        Tree t = new Tree();
        //t.dfs(t.simpleTree());
        //t.dfs(t.oneTree());
        t.recursiveTreeDisplay(t.simpleTree());
        t.recursiveTreeDisplay(t.oneTree());


    }
}
