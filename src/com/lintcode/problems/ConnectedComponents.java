package com.lintcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Find connected component in undirected graph.
 * Each node in the graph contains a label and a list of its neighbors.
 * 
 * (A connected component of an undirected graph is a subgraph in which
 * any two vertices are connected to each other by paths, 
 * and which is connected to no additional vertices in the supergraph.)
 * 
 * You need return a list of label set.
 *
 */
public class ConnectedComponents {

    /*
     * @param nodes: a array of Undirected graph node
     * @return: a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        List<List<Integer>> components = new ArrayList<>();

        ConnectingGraph uf = new ConnectingGraph(nodes);
        for (UndirectedGraphNode node : nodes) {
            for (UndirectedGraphNode neighbor : node.neighbors) {
                uf.connect(node.label, neighbor.label);
            }
        }

        for (SortedSet<Integer> component : uf.components.values()) {
            List<Integer> numbers = new ArrayList<>(component);
            components.add(numbers);
        }

        return components;
    }


    // Definition for Undirected graph.
    public static class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public class ConnectingGraph {
        private Map<Integer, Integer> nodes_;
        private Map<Integer, SortedSet<Integer>> components = new HashMap<>(); 

        public ConnectingGraph(List<UndirectedGraphNode> nodes) {
            nodes_ = new HashMap<>(nodes.size());
            for (UndirectedGraphNode node : nodes) {
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

                if (aMembers.size() < bMembers.size()) {
                    nodes_.put(aRootIndex, bRootIndex);
                    bMembers.addAll(aMembers);
                    components.remove(aRootIndex);
                    components.put(bRootIndex, bMembers);
                } else {
                    nodes_.put(bRootIndex, aRootIndex);
                    aMembers.addAll(bMembers);
                    components.remove(bRootIndex);
                    components.put(aRootIndex, aMembers);
                }

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
