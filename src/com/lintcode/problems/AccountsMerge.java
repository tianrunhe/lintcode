package com.lintcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class AccountsMerge {


    public List<List<String>> accountsMerge(List<List<String>> accounts) {
    	Map<Integer, String> indexToName = new HashMap<Integer, String>();
    	Map<Integer, String> indexToEmail = new HashMap<Integer, String>();
    	Map<String, Integer> emailToIndex = new HashMap<String, Integer>();
    	
    	for(List<String> account : accounts) {
    		String name = account.get(0);
    		for(int i = 1; i < account.size(); ++i) {
    			String email = account.get(i);
    			if (!emailToIndex.containsKey(email)) {
    				int index = emailToIndex.size() + 1;
    				indexToEmail.put(index, email);
    				emailToIndex.put(email, index);
    				indexToName.put(index, name);
    			}
    		}
    	}
    	
    	ConnectingGraph2 cg2 = new ConnectingGraph2(indexToEmail);
    	for(List<String> account : accounts) {
    		for(int i = 1; i < account.size(); ++i) {
    			if (i + 1 < account.size()) {
    				cg2.connect(emailToIndex.get(account.get(i)), emailToIndex.get(account.get(i + 1)));
    			}
    		}
    	}
    	
    	Map<Integer, SortedSet<String>> mergedAccounts = cg2.getAccounts();
    	List<List<String>> result = new ArrayList<List<String>>(mergedAccounts.size());
    	for(Integer index : mergedAccounts.keySet()) {
    		String name = indexToName.get(index);
    		List<String> account = new ArrayList<String>();
    		account.add(name);
    		account.addAll(mergedAccounts.get(index));
    		result.add(account);
    	}
    	
    	return result;
    }
    
    
    private class ConnectingGraph2 {
        /*
        * @param n: An integer
        */
        private int[] nodes;
        private Map<Integer, SortedSet<String>> accounts = new HashMap<Integer, SortedSet<String>>();
        
        public ConnectingGraph2(Map<Integer, String> emailIndexMapping) {
            // do intialization if necessary
            nodes = new int[emailIndexMapping.size() + 1];
            for (int i = 1; i < emailIndexMapping.size() + 1; ++i) {
                nodes[i] = i;
                
                SortedSet<String> emails = new TreeSet<String>();
                emails.add(emailIndexMapping.get(i));
                accounts.put(i, emails);
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
                
                SortedSet<String> aEmails = accounts.get(aRootIndex);
                SortedSet<String> bEmails = accounts.get(bRootIndex);
                bEmails.addAll(aEmails);
                accounts.remove(aRootIndex);
                accounts.put(bRootIndex, bEmails);
            }
        }
        
        private int findRoot(int a) {
            int rootIndex = nodes[a];
            while (rootIndex != nodes[rootIndex]) {
                rootIndex = nodes[rootIndex];
            }
    		while (nodes[a] != rootIndex)
    		{
    			int parent = nodes[a];
    			nodes[a] = rootIndex;
    			a = parent;
    		}
            return rootIndex;
        }

        public Map<Integer, SortedSet<String>> getAccounts() {
        	return accounts;
        }
    }
}
