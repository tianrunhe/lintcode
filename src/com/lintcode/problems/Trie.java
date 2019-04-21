package com.lintcode.problems;

public class Trie {
    private TrieNode root;
    
    public Trie() {
        // do intialization if necessary
        root = new TrieNode();
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        char[] characters = word.toCharArray();
        TrieNode traversal = root;
        for (char c : characters) {
            TrieNode[] children = traversal.getChildren();
            final int index = c - 'a';
            if (children[index] == null) {
                children[index] = new TrieNode();
            }
            traversal = children[index];
        }
        traversal.markWordStop();
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
        char[] characters = word.toCharArray();
        TrieNode traversal = root;
        for (char c : characters) {
            TrieNode[] children = traversal.getChildren();
            final int index = c - 'a';
            if (children[index] == null) {
                return false;
            }
            traversal = children[index];
        }
        return traversal.isWordStop();
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] characters = prefix.toCharArray();
        TrieNode traversal = root;
        for (char c : characters) {
            TrieNode[] children = traversal.getChildren();
            final int index = c - 'a';
            if (children[index] == null) {
                return false;
            }
            traversal = children[index];
        }
        return true;
    }
    
    private class TrieNode {
        private TrieNode[] children;
        private boolean wordStop;
        
        public TrieNode() {
            this.children = new TrieNode[26];
            this.wordStop = false;
        }
        
        public TrieNode[] getChildren() {
            return this.children;
        }
        
        public boolean isWordStop() {
            return this.wordStop;
        }
        
        public void markWordStop() {
            this.wordStop = true;
        }
    }
}
