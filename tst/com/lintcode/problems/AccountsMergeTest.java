package com.lintcode.problems;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

public class AccountsMergeTest {

	private AccountsMerge am = new AccountsMerge();
	
	@Test
	public void test1() {
		List<List<String>> accounts = new ArrayList<List<String>>();
		
		List<String> account1 = new ArrayList<String>();
		account1.add("John");
		account1.add("johnsmith@mail.com");
		account1.add("john00@mail.com");
		accounts.add(account1);
		
		List<String> account2 = new ArrayList<String>();
		account2.add("John");
		account2.add("johnnybravo@mail.com");
		accounts.add(account2);
		
		List<String> account3 = new ArrayList<String>();
		account3.add("John");
		account3.add("johnsmith@mail.com");
		account3.add("john_newyork@mail.com");
		accounts.add(account3);
		
		List<String> account4 = new ArrayList<String>();
		account4.add("Mary");
		account4.add("mary@mail.com");
		accounts.add(account4);
		
		
		List<List<String>> expected = new ArrayList<List<String>>();
		
		List<String> expectedAccount1 = new ArrayList<String>();
		expectedAccount1.add("John");
		expectedAccount1.add("john00@mail.com");
		expectedAccount1.add("john_newyork@mail.com");
		expectedAccount1.add("johnsmith@mail.com");
		expected.add(expectedAccount1);
		
		List<String> expectedAccount2 = new ArrayList<String>();
		expectedAccount2.add("John");
		expectedAccount2.add("johnnybravo@mail.com");
		expected.add(expectedAccount2);
		
		List<String> expectedAccount3 = new ArrayList<String>();
		expectedAccount3.add("Mary");
		expectedAccount3.add("mary@mail.com");
		expected.add(expectedAccount3);
		
		assertEquals(new HashSet<List<String>>(expected), new HashSet<List<String>>(am.accountsMerge(accounts)));
	}
}
