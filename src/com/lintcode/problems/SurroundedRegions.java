package com.lintcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O''s into 'X''s in that surrounded region.
 * 
 * Example 1:

Input:
  X X X X
  X O O X
  X X O X
  X O X X
Output:
  X X X X
  X X X X
  X X X X
  X O X X
  
 * Example 2:

Input:
  X X X X
  X O O X
  X O O X
  X O X X
Output:
  X X X X
  X O O X
  X O O X
  X O X X
 */
public class SurroundedRegions {
    /*
     * @param board: board a 2D board containing 'X' and 'O'
     * @return: nothing
     */
    public void surroundedRegions(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        final int n = board.length;
        final int m = board[0].length;
        UnionFind<Point> uf = new UnionFind<Point>();

        Point[][] grid = new Point[n][m];
        Set<Point> islands = new HashSet<Point>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                Point point = new Point(i, j);
                grid[i][j] = point;

                uf.connect(point, point);
                islands.add(point);

                char c = board[i][j];

                Point left = point.y - 1 >= 0 ? grid[i][j - 1] : null;
                if (left != null && islands.contains(left) && c == board[i][j-1]) {
                    uf.connect(left, point);
                }

                Point right = point.y + 1 < m ? grid[i][j + 1] : null;
                if (right != null && islands.contains(right) && c == board[i][j+1]) {
                    uf.connect(point, right);
                }

                Point up = point.x - 1 >= 0 ? grid[i - 1][j] : null;
                if (up != null && islands.contains(up) && c == board[i-1][j]) {
                    uf.connect(up, point);
                }

                Point down = point.x + 1 < n ? grid[i + 1][j] : null;
                if (down != null && islands.contains(down) && c == board[i+1][j]) {
                    uf.connect(point, down);
                }
            }
        }

        for (Set<Point> connectedRegion : uf.getConnectedComponents().values()) {
            boolean surrounded = true;
            for (Point p : connectedRegion) {
                if (p.x == 0 || p.x == n - 1 || p.y == 0 || p.y == m - 1) {
                    surrounded = false;
                    break;
                }
            }
            if (surrounded) {
                for (Point p : connectedRegion) {
                    board[p.x][p.y] = 'X';
                }
            }
        }
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

        public Map<T, Set<T>> getConnectedComponents() {
            return components;
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
            Point other = (Point) obj;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }
    }

}
