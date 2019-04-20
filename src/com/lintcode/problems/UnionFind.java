package com.lintcode.problems;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class UnionFind<T> {

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
        // write your code here
        return findRoot(a) == findRoot(b);
    }
}
