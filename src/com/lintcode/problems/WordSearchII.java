package com.lintcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a matrix of lower alphabets and a dictionary. 
 * Find all words in the dictionary that can be found in the matrix. 
 * A word can start from any position in the matrix and 
 * go left/right/up/down to the adjacent position. 
 * One character only be used once in one word. 
 * No same word in dictionary
  
Example

Example 1:

Input：["doaf","agai","dcan"]，["dog","dad","dgdg","can","again"]
Output：["again","can","dad","dog"]
Explanation：
  d o a f
  a g a i
  d c a n
search in Matrix，so return ["again","can","dad","dog"].

Example 2:

Input：["a"]，["b"]
Output：[]
Explanation：
 a
search in Matrix，return [].
 *
 */
public class WordSearchII {

    public List<String> wordSearchII(char[][] board, List<String> words) {
        List<String> result = new ArrayList<String>();
        if (board == null || board.length == 0 || board[0].length == 0) {
            return result;
        }

        TrieNode[][] mapping = new TrieNode[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                TrieNode node = new TrieNode(board[i][j], i , j);
                mapping[i][j] = node;
            }
        }

        Map<Character, Set<TrieNode>> characterTrieNodes = new HashMap<>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                TrieNode node = mapping[i][j];

                TrieNode down = i + 1 < board.length ? mapping[i + 1][j] : null;
                if (down != null) {
                    node.addChild(board[i + 1][j], mapping[i + 1][j]);
                }
                TrieNode right = j + 1 < board[0].length ? mapping[i][j + 1] : null;
                if (right != null) {
                    node.addChild(board[i][j + 1], mapping[i][j + 1]);
                }
                TrieNode up = i - 1 >= 0 ? mapping[i - 1][j] : null;
                if (up != null) {
                    node.addChild(board[i - 1][j], mapping[i - 1][j]);
                }
                TrieNode left = j - 1 >= 0 ? mapping[i][j - 1] : null;
                if (left != null) {
                    node.addChild(board[i][j - 1], mapping[i][j - 1]);
                }

                Set<TrieNode> nodes = characterTrieNodes.getOrDefault(board[i][j], new HashSet<>());
                nodes.add(node);
                characterTrieNodes.put(board[i][j], nodes);
            }
        }

        for (String word : words) {
            if (!word.isEmpty()) {
                char[] characters = word.toCharArray();
                Set<TrieNode> nodes = characterTrieNodes.getOrDefault(characters[0], new HashSet<>());
                boolean found = false;
                for(TrieNode node : nodes) {
                    found = found | node.search(word);
                    if (found) {
                        break;
                    }
                }
                if (found) {
                    result.add(word);
                }
            }
        }

        return result;
    }

    private class TrieNode {
        Map<Character, Set<TrieNode>> children;
        private char c;
        private int x;
        private int y;

        public TrieNode(char c, int x, int y) {
            this.children = new HashMap<>();
            this.c = c;
            this.x = x;
            this.y = y;
        }

        public void addChild(char c, TrieNode child) {
            Set<TrieNode> nodes = children.getOrDefault(c, new HashSet<>());
            nodes.add(child);
            children.put(c, nodes);
        }

        public boolean search(String word) {
            return search(word, new HashSet<>());
        }

        private boolean search(String word, Set<TrieNode> visited) {
            // base case
            if (word.isEmpty()) {
                return true;
            }
            if (word.length() == 1) {
                return !visited.contains(this) && this.c == word.charAt(0);
            }
            // recursive relationship
            boolean found = false;
            for (TrieNode node : this.children.getOrDefault(word.charAt(1), new HashSet<>())) {
                visited.add(this);
                if (!visited.contains(node)) {
                    found = found | node.search(word.substring(1), visited);
                }
                visited.remove(this);
            }
            return found;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + "): " + c;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + c;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            TrieNode other = (TrieNode) obj;
            if (c != other.c)
                return false;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }

    }

}
