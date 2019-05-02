package com.lintcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Find the number Weak Connected Component in the directed graph.
 * Each node in the graph contains a label and a list of its neighbors.
 * (a weak connected component of a directed graph is a maximum subgraph
 * in which any two vertices are connected by direct edge path.)
 * 
 * Example 1:

Input: {1,2,4#2,4#3,5#4#5#6,5}
Output: [[1,2,4],[3,5,6]]
Explanation:
  1----->2    3-->5
   \     |        ^
    \    |        |
     \   |        6
      \  v
       ->4
 *
 * Example 2:

Input: {1,2#2,3#3,1}
Output: [[1,2,3]]
 */
public class WeakConnectedComponents {

    /*
     * @param nodes: a array of Directed graph node
     * @return: a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        List<List<Integer>> components = new ArrayList<>();

        ConnectingGraph uf = new ConnectingGraph(nodes);
        for (DirectedGraphNode node : nodes) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                uf.connect(node.label, neighbor.label);
            }
        }

        for (SortedSet<Integer> component : uf.components.values()) {
            List<Integer> numbers = new ArrayList<>(component);
            components.add(numbers);
        }

        return components;
    }

    // Definition for DirectedGraphNode graph.
    public static class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;
        DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    }

    public class ConnectingGraph {
        private Map<Integer, Integer> nodes_;
        private Map<Integer, SortedSet<Integer>> components = new HashMap<>(); 

        public ConnectingGraph(List<DirectedGraphNode> nodes) {
            nodes_ = new HashMap<>(nodes.size());
            for (DirectedGraphNode node : nodes) {
                nodes_.put(node.label, node.label);
                SortedSet<Integer> members = new TreeSet<Integer>();
                members.add(node.label);
                components.put(node.label, members);
            }
        }

        public void connect(int a, int b) {
            int aRootIndex = findRoot(a);
            int bRootIndex = findRoot(b);
            if (aRootIndex != bRootIndex) {
                SortedSet<Integer> aMembers = components.get(aRootIndex);
                SortedSet<Integer> bMembers = components.get(bRootIndex);

                nodes_.put(bRootIndex, aRootIndex);
                aMembers.addAll(bMembers);
                components.remove(bRootIndex);
                components.put(aRootIndex, aMembers);

            }
        }

        private int findRoot(int a) {
            int rootIndex = nodes_.get(a);
            while (rootIndex != nodes_.get(rootIndex)) {
                rootIndex = nodes_.get(rootIndex);
            }
            return rootIndex;
        }

        public boolean query(int a, int b) {
            return findRoot(a) == findRoot(b);
        }
    }
}
