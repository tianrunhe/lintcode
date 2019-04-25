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
                TrieNode node = new TrieNode(i, j, board[i][j]);
                mapping[i][j] = node;
            }
        }

        Map<Character, Set<TrieNode>> characterTrieNodes = new HashMap<>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                TrieNode node = mapping[i][j];

                TrieNode down = i + 1 < board.length ? mapping[i + 1][j] : null;
                if (down != null) {
                    node.addChild(down);
                }
                TrieNode right = j + 1 < board[0].length ? mapping[i][j + 1] : null;
                if (right != null) {
                    node.addChild(right);
                }
                TrieNode up = i - 1 >= 0 ? mapping[i - 1][j] : null;
                if (up != null) {
                    node.addChild(up);
                }
                TrieNode left = j - 1 >= 0 ? mapping[i][j - 1] : null;
                if (left != null) {
                    node.addChild(left);
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
                    found = found | node.search(word, new HashSet<>());
                }
                if (found) {
                    result.add(word);
                }
            }
        }

        return result;
    }

    private class TrieNode {
        Set<TrieNode> children;
        private char c;
        private int row;
        private int col;

        public TrieNode(int x, int y, char c) {
            this.children = new HashSet<>();
            this.row = x;
            this.col = y;
            this.c = c;
        }

        public void addChild(TrieNode child) {
            children.add(child);
        }

        public boolean search(String word, Set<TrieNode> visited) {
            if (visited.contains(this)) {
                return false;
            }
            if(word.isEmpty()) {
                return true;
            }
            if (c != word.charAt(0)) {
                return false;
            } else if (children.isEmpty()) {
                return word.length() == 1;
            } else {
                boolean found = false;
                for (TrieNode child : children) {
                    Set<TrieNode> newVisited = new HashSet<TrieNode>(visited);
                    newVisited.add(this);
                    found = found | child.search(word.substring(1), newVisited);
                }
                return found;
            }
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public char getCharacter() {
            return c;
        }
    }

}
