package com.lintcode.problems;

import java.util.HashMap;
import java.util.Map;

public class ConnectingGraph3 {
    /*
    * @param n: An integer
    */
    private int[] nodes;
    private Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
    private int number;
    
    public ConnectingGraph3(int n) {
        // do intialization if necessary
        nodes = new int[n + 1];
        for (int i = 0; i < n + 1; ++i) {
            nodes[i] = i;
            counts.put(i, 1);
        }
        number = n;
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
            counts.put(bRootIndex, counts.get(bRootIndex) + counts.get(aRootIndex));
            number -= 1;
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
    public int query() {
        return number;
    }

}
