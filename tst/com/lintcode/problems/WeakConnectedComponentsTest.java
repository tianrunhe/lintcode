package com.lintcode.problems;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lintcode.problems.WeakConnectedComponents.DirectedGraphNode;

public class WeakConnectedComponentsTest {

    private WeakConnectedComponents wcc = new WeakConnectedComponents();

    /**
     * Input: {1,2,4#2,1,4#3,5#4,1,2#5,3}
     * Output: [[1,2,4],[3,5]]
     */
    @Test
    public void test1() {
        DirectedGraphNode node1 = new DirectedGraphNode(1);
        DirectedGraphNode node2 = new DirectedGraphNode(2);
        DirectedGraphNode node3 = new DirectedGraphNode(3);
        DirectedGraphNode node4 = new DirectedGraphNode(4);
        DirectedGraphNode node5 = new DirectedGraphNode(5);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node4);
        node3.neighbors.add(node5);
        node4.neighbors.add(node1);
        node4.neighbors.add(node2);
        node5.neighbors.add(node3);

        ArrayList<DirectedGraphNode> nodes = new ArrayList<>();
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

        assertEquals(expected, wcc.connectedSet2(nodes));
    }
}
