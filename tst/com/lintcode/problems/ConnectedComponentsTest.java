package com.lintcode.problems;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lintcode.problems.ConnectedComponents.UndirectedGraphNode;

public class ConnectedComponentsTest {

    private ConnectedComponents cc = new ConnectedComponents();

    /**
     * Input: {1,2,4#2,1,4#3,5#4,1,2#5,3}
     * Output: [[1,2,4],[3,5]]
     */
    @Test
    public void test1() {
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        UndirectedGraphNode node3 = new UndirectedGraphNode(3);
        UndirectedGraphNode node4 = new UndirectedGraphNode(4);
        UndirectedGraphNode node5 = new UndirectedGraphNode(5);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node4);
        node3.neighbors.add(node5);
        node4.neighbors.add(node1);
        node4.neighbors.add(node2);
        node5.neighbors.add(node3);

        List<UndirectedGraphNode> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);

        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> component1 = new ArrayList<Integer>();
        component1.add(1);
        component1.add(2);
        component1.add(4);
        List<Integer> component2 = new ArrayList<Integer>();
        component2.add(3);
        component2.add(5);
        expected.add(component1);
        expected.add(component2);

        assertEquals(expected, cc.connectedSet(nodes));
    }
}
