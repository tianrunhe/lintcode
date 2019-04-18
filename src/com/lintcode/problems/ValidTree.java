package com.lintcode.problems;

public class ValidTree {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
    	if (edges == null || edges.length == 0 || edges[0].length != 2) {
    		return n == 1;
    	}
    	ConnectingGraph cg = new ConnectingGraph(n);
    	for(int i = 0; i < edges.length; ++i) {
    		int[] pair = edges[i];
    		if (cg.connect(pair[0], pair[1]) == false) {
    			return false;
    		}
    	}
    	return cg.query() == 1;
    }
    
    private class ConnectingGraph {
        /*
        * @param n: An integer
        */
        private int[] nodes;
        private int number;

        
        public ConnectingGraph(int n) {
            // do intialization if necessary
            nodes = new int[n + 1];
            for (int i = 0; i < n + 1; ++i) {
                nodes[i] = i;
            } 
            number = n;
        }

        /*
         * @param a: An integer
         * @param b: An integer
         * @return: nothing
         */
        public boolean connect(int a, int b) {
            // write your code here
            int aRootIndex = findRoot(a);
            int bRootIndex = findRoot(b);
            if (aRootIndex != bRootIndex) {
                nodes[aRootIndex] = bRootIndex;
                number -= 1;
                return true;
            }
            return false;
        }
        
        private int findRoot(int a) {
            int rootIndex = nodes[a];
            while (rootIndex != nodes[rootIndex]) {
                rootIndex = nodes[rootIndex];
            }
            return rootIndex;
        }
        
        public int query() {
            return number;
        }

    }
}
