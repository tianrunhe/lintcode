package com.lintcode.problems;

public class ConnectingGraph {
    /*
    * @param n: An integer
    */
    private int[] nodes;
    
    public ConnectingGraph(int n) {
        // do intialization if necessary
        nodes = new int[n + 1];
        for (int i = 0; i < n + 1; ++i) {
            nodes[i] = i;
        } 
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
        int aRootIndex = findRoot(a);
        int bRootIndex = findRoot(b);
        if (aRootIndex != bRootIndex) {
            nodes[aRootIndex] = bRootIndex;
        }
    }
    
    private int findRoot(int a) {
        int rootIndex = nodes[a];
        while (rootIndex != nodes[rootIndex]) {
            rootIndex = nodes[rootIndex];
        }
        return rootIndex;
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: A boolean
     */
    public boolean query(int a, int b) {
        // write your code here
        return findRoot(a) == findRoot(b);
    }
}