package com.flash.leetcode;

/**
 * Created by zhangj52 on 3/12/2017.
 */
public class Q208_ImplementTrieTree {


    public static class Trie {
        public static class TrieNode {
            public Object value;
            public TrieNode[] children;

            public TrieNode(Object value) {
                this.value = value;
                children = new TrieNode[26];
            }

            public TrieNode() {
                this.value = null;
                children = new TrieNode[26];
            }
        }


        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            this.root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         * Time complexity: O(len(word).
         * Trie tree space complexity: O(number of unique chars in inputs)
         */
        public void insert(String word) {
            TrieNode curNode = this.root;
            int n = word.length();
            for (int i=0; i < n; i++) {
                int idx = word.charAt(i) - 'a';
                if (curNode.children[idx] == null) {
                    TrieNode trieNode = new TrieNode();
                    curNode.children[idx] = trieNode;
                    curNode = trieNode;
                } else {
                    curNode = curNode.children[idx];
                }
            }
            curNode.value = word;
        }

        /**
         * Returns if the word is in the trie.
         * Time complexity: O(len(word))
         */
        public boolean search(String word) {
            TrieNode curNode = this.root;
            int n = word.length();

            for(int i=0; i < n; i++) {
                char curChar = word.charAt(i);
                int idx = curChar - 'a';
                if (curNode.children[idx] == null) {
                    return false;
                } else {
                    curNode = curNode.children[idx];
                }
            }

            return curNode.value != null;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         * Time Complexity: O(len(prefix)).
         */
        public boolean startsWith(String prefix) {
            TrieNode curNode = this.root;
            int n = prefix.length();

            for(int i=0; i < n; i++) {
                char curChar = prefix.charAt(i);
                int idx = curChar - 'a';
                if (curNode.children[idx] == null) {
                    return false;
                } else {
                    curNode = curNode.children[idx];
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abcde");

        System.out.println("Search--------------------");
        System.out.println(trie.search("a"));
        System.out.println(trie.search("b"));
        System.out.println(trie.search("abc"));
        System.out.println(trie.search("abcde"));

        System.out.println("Started With ----------------");
        System.out.println(trie.startsWith("a"));
        System.out.println(trie.startsWith("b"));
        System.out.println(trie.startsWith("ab"));
        System.out.println(trie.startsWith("abc"));
        System.out.println(trie.startsWith("abcde"));
        System.out.println(trie.startsWith("abcdef"));
    }
}
