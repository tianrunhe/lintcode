package com.lintcode.problems;

public class WordDictionary {
    private TrieNode root = new TrieNode();

    public void addWord(String word) {
        // write your code here
        insert(this.root, word);
    }

    private void insert(TrieNode root, String word) {
        if (word == null || word.length() == 0) {
            root.markWordStop();
            return;
        }
        
        char c = word.charAt(0);
        TrieNode[] children = root.getChildren();
        final int index = c - 'a';
        if (children[index] == null) {
            children[index] = new TrieNode();
        }
        insert(children[index], word.substring(1));
    }

    public boolean search(String word) {
        return search(this.root, word);
    }

    private boolean search(TrieNode root, String word) {
        if (word == null || word.length() == 0) {
            return root.isWordStop();
        }
        
        char c = word.charAt(0);
        if (c == '.') {
            boolean found = false;
            for (TrieNode next : root.getChildren()) {
                if (next != null && !found) {
                    found = found | search(next, word.substring(1));
                }
            }
            return found;
        } else {
            int index = c - 'a';
            TrieNode[] children = root.getChildren();
            if (children[index] == null) {
                return false;
            }
            return search(children[index], word.substring(1));
        }
    }

    private class TrieNode {
        private TrieNode[] children;
        private boolean wordStop;
        
        public TrieNode() {
            this.children = new TrieNode[27];
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