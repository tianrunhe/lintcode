package com.lintcode.problems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class MinimumSpanningTree {
    /**
     * @param connections given a list of connections include two cities and cost
     * @return a list of connections from results
     */
    public List<Connection> lowestCost(List<Connection> connections) {
        Collections.sort(connections, new Comparator<Connection>() {
            @Override
            public int compare(Connection c1, Connection c2) {
                int costDiff = c1.cost - c2.cost;
                if (costDiff != 0) {
                    return costDiff;
                } else {
                    int city1Diff = c1.city1.compareTo(c2.city1);
                    if (city1Diff != 0) {
                        return city1Diff;
                    } else {
                        return c1.city2.compareTo(c2.city2);
                    }
                }
            }
        });

        Set<String> cities = new HashSet<>();
        for (Connection c : connections) {
            cities.add(c.city1);
            cities.add(c.city2);
        }
        UnionFind<String> uf = new UnionFind<String>(cities);
        UnionFind<String> uf2 = new UnionFind<String>(cities);

        List<Connection> result = new ArrayList<>();
        for (Connection connection : connections) {
            if (!uf.query(connection.city1, connection.city2) &&
                    (!cities.isEmpty() || uf2.getNumberOfComponents() != 1)) {
                uf.connect(connection.city1, connection.city2);
                result.add(connection);
                cities.remove(connection.city1);
                cities.remove(connection.city2);
            }
            uf2.connect(connection.city1, connection.city2);
        }

        if (uf2.getNumberOfComponents() != 1) {
            return new ArrayList<>();
        }

        if (cities.isEmpty()) {
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    private class UnionFind<T> {

        private Map<T, T> rootMap;
        private Map<T, SortedSet<T>> components;

        public UnionFind(Collection<T> elements) {
            rootMap = new HashMap<T, T>(elements.size());
            components = new HashMap<T, SortedSet<T>>();
            for (T element : elements) {
                rootMap.put(element, element);

                SortedSet<T> members = new TreeSet<T>();
                members.add(element);
                components.put(element, members);
            }
        }

        private T findRoot(T element) {
            T root = rootMap.get(element);
            while (root != rootMap.get(root)) {
                    root = rootMap.get(root);
            }
            return root;
        }

        public void connect(T a, T b) {
            T aRoot = findRoot(a);
            T bRoot = findRoot(b);
            if (aRoot != bRoot) {
                SortedSet<T> aMembers = components.get(aRoot);
                SortedSet<T> bMembers = components.get(bRoot);
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

        public boolean query(T a, T b) {
            return findRoot(a) == findRoot(b);
        }
        
        public int getNumberOfComponents() {
            return components.size();
        }
    }
}
