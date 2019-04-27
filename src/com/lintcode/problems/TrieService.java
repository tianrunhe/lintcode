package com.lintcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Description
Build tries from a list of <word, freq> pairs. Save top 10 for each node.

Example1
Input:  
 <"abc", 2>
 <"ac", 4>
 <"ab", 9>
Output:<a[9,4,2]<b[9,2]<c[2]<>>c[4]<>>> 
Explanation:
            Root
             / 
           a(9,4,2)
          /    \
        b(9,2) c(4)
       /
     c(2)

Example2
Input:  
<"a", 10>
<"c", 41>
<"b", 50>
<"abc", 5>
Output: <a[10,5]<b[5]<c[5]<>>>b[50]<>c[41]<>>
 *
 */
public class TrieService {

    private TrieNode root = null;

    public TrieService() {
        root = new TrieNode();
    }

    public TrieNode getRoot() {
        // Return root of trie root, and 
        // lintcode will print the tree struct.
        return root;
    }

    // @param word a string
    // @param frequency an integer
    public void insert(String word, int frequency) {
        char[] characters = word.toCharArray();
        TrieNode traversal = root;
        for (char c : characters) {
            NavigableMap<Character, TrieNode> children = traversal.children;
            traversal = children.getOrDefault(c, new TrieNode());
            
            List<Integer> top10 = traversal.top10;
            top10.add(frequency);
            Collections.sort(top10, Collections.reverseOrder());
            if (top10.size() > 10) {
                traversal.top10 = top10.subList(0, 10);
            }
            
            children.put(c, traversal);
        }
    }

    public class TrieNode {
        public NavigableMap<Character, TrieNode> children;
        public List<Integer> top10;
        public TrieNode() {
            children = new TreeMap<Character, TrieNode>();
            top10 = new ArrayList<Integer>();
        }
    }

}
