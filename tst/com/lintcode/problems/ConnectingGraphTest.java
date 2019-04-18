package com.lintcode.problems;
import org.junit.Test;

public class ConnectingGraphTest {
	
	@Test
	public void test() {
		ConnectingGraph cg = new ConnectingGraph(5);
		cg.query(1, 2);
		cg.connect(1, 2);
		cg.query(1, 3);
		cg.connect(2, 4);
		cg.query(1, 4);
	}
}
