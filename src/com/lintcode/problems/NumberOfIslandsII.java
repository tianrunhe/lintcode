package com.lintcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k). 
 * Originally, the 2D matrix is all 0 which means there is only sea in the matrix. 
 * The list pair has k operator and each operator has two integer A[i].x, A[i].y 
 * means that you can change the grid matrix[A[i].x][A[i].y] from sea to island. 
 * Return how many island are there in the matrix after each operator.
 * 
 * Example 1:

Input: n = 4, m = 5, A = [[1,1],[0,1],[3,3],[3,4]]
Output: [1,1,2,2]
Explanation:
0.  00000
    00000
    00000
    00000
1.  00000
    01000
    00000
    00000
2.  01000
    01000
    00000
    00000
3.  01000
    01000
    00000
    00010
4.  01000
    01000
    00000
    00011

Example 2:

Input: n = 3, m = 3, A = [[0,0],[0,1],[2,2],[2,1]]
Output: [1,1,2,2]

 *
 */
public class NumberOfIslandsII {
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> result = new ArrayList<Integer>();
        if (operators == null) {
            return result;
        }

        EqualPoint[][] grid = new EqualPoint[n][m];
        Set<EqualPoint> islands = new HashSet<EqualPoint>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                EqualPoint p = new EqualPoint(i, j);
                grid[i][j] = p;
            }
        }
        UnionFind<EqualPoint> uf = new UnionFind<EqualPoint>();

        for (Point p : operators) {
            EqualPoint point = new EqualPoint(p.x, p.y);
            final int i = point.x;
            final int j = point.y;

            uf.connect(point, point);
            islands.add(point);

            EqualPoint left = point.y - 1 >= 0 ? grid[i][j - 1] : null;
            if (left != null && islands.contains(left)) {
                uf.connect(left, point);
            }

            EqualPoint right = point.y + 1 < m ? grid[i][j + 1] : null;
            if (right != null && islands.contains(right)) {
                uf.connect(point, right);
            }

            EqualPoint up = point.x - 1 >= 0 ? grid[i - 1][j] : null;
            if (up != null && islands.contains(up)) {
                uf.connect(up, point);
            }

            EqualPoint down = point.x + 1 < n ? grid[i + 1][j] : null;
            if (down != null && islands.contains(down)) {
                uf.connect(point, down);
            }

            result.add(uf.getNumberOfComponents());
        }
        return result;
    }

    private class UnionFind<T> {

        private Map<T, T> rootMap;
        private Map<T, Set<T>> components;

        public UnionFind() {
            rootMap = new HashMap<T, T>();
            components = new HashMap<T, Set<T>>();
        }

        private T findRoot(T element) {
            T root = rootMap.get(element);
            while (root != rootMap.get(root)) {
                root = rootMap.get(root);
            }
            return root;
        }

        public void connect(T a, T b) {
            rootMap.putIfAbsent(a, a);
            rootMap.putIfAbsent(b, b);
            
            Set<T> aSet = new HashSet<T>();
            aSet.add(a);
            if (!components.containsKey(findRoot(a))) {
                components.put(a, aSet);
            }
            Set<T> bSet = new HashSet<T>();
            bSet.add(b);
            if (!components.containsKey(findRoot(b))) {
                components.putIfAbsent(b, bSet);
            }

            T aRoot = findRoot(a);
            T bRoot = findRoot(b);
            if (aRoot != bRoot) {
                Set<T> aMembers = components.get(aRoot);
                Set<T> bMembers = components.get(bRoot);
                if (aMembers.size() < bMembers.size()) {
                    rootMap.put(aRoot, bRoot);
                    bMembers.addAll(aMembers);
                    components.remove(aRoot);
                    components.put(bRoot, bMembers);
                } else {
                    rootMap.put(bRoot, aRoot);
                    aMembers.addAll(bMembers);
                    components.remove(bRoot);
                    components.put(aRoot, aMembers);
                }
            }
        }

        public int getNumberOfComponents() {
            return components.size();
        }
    }

    /**
     * Definition for a point.
     */
    static final class EqualPoint {
        int x;
        int y;
        EqualPoint() { x = 0; y = 0; }
        EqualPoint(int a, int b) { x = a; y = b; }

        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
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
            EqualPoint other = (EqualPoint) obj;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }
    }

    /**
     * Definition for a point.
     */
    static final class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }
}
