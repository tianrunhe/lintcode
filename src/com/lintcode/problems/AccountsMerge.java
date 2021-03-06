package com.lintcode.problems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class AccountsMerge {


    public List<List<String>> accountsMerge(List<List<String>> accounts) {
    	Map<String, String> emailToName = new HashMap<String, String>();
    	
    	for(List<String> account : accounts) {
    		String name = account.get(0);
    		for(int i = 1; i < account.size(); ++i) {
    			String email = account.get(i);
    			emailToName.put(email, name);
    		}
    	}
    	
    	UnionFind cg2 = new UnionFind(emailToName.keySet());
    	for(List<String> account : accounts) {
    		for(int i = 1; i < account.size(); ++i) {
    			if (i + 1 < account.size()) {
    				cg2.connect(account.get(i), account.get(i + 1));
    			}
    		}
    	}
    	
    	
    	Map<String, SortedSet<String>> mergedAccounts = cg2.getComponents();
    	List<List<String>> result = new ArrayList<List<String>>(mergedAccounts.size());
    	for(String email : mergedAccounts.keySet()) {
    		String name = emailToName.get(email);
    		List<String> account = new ArrayList<String>();
    		account.add(name);
    		account.addAll(mergedAccounts.get(email));
    		result.add(account);
    	}
    	
    	return result;
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
    		
            while (rootMap.get(element) != root)
    		{
    			T parent = rootMap.get(element);
    			rootMap.put(element, root);
    			element = parent;
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
        
        public Map<T, SortedSet<T>> getComponents() {
        	return components;
        }
    }
}
