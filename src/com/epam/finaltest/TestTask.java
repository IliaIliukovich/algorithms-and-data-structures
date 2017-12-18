package com.epam.finaltest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestTask {


    public static void main(String[] args) {

        TestTask testTask = new TestTask();
        Node nodeA = testTask.new Node("A");
        Node nodeB = testTask.new Node("B");
        Node nodeC = testTask.new Node("C");
        Node nodeD = testTask.new Node("D");
        Node nodeE = testTask.new Node("E");
        Node nodeF = testTask.new Node("F");
        Node nodeG = testTask.new Node("G");
        Node nodeH = testTask.new Node("H");
        Node nodeI = testTask.new Node("I");
        Node nodeK = testTask.new Node("K");
        nodeA.children.add(nodeB);
        nodeA.children.add(nodeC);
        nodeB.children.add(nodeD);
        nodeB.children.add(nodeE);
        nodeB.children.add(nodeF);
        nodeC.children.add(nodeG);
        nodeG.children.add(nodeI);
        nodeC.children.add(nodeH);
        nodeH.children.add(nodeK);
        MyGraph graph = testTask.new MyGraph(Arrays.asList(nodeA, nodeB, nodeC, nodeD, nodeE, nodeF, nodeG, nodeH, nodeI, nodeK));

        System.out.println("Graph:");
        printGraph(graph);
        remove(graph);
        System.out.println("Result:");
        printGraph(graph);
    }

    // Algorithm efficiency ~ N*M, where N - number of vertexes, M - number of vertexes with degree = 2
    private static void remove(MyGraph graph) {
        List<Integer> indsToRemove = new ArrayList<>();
        for (int i = 0; i < graph.nodes.size(); i++) {
            if (!indsToRemove.contains(i)) {
                checkAndRemove(graph.nodes, indsToRemove, i);
            }
        }

        List<Node> newNodes = new ArrayList<>(graph.nodes.size() - indsToRemove.size());
        for (int i = 0; i < graph.nodes.size(); i++) {
            if (!indsToRemove.contains(i)) {
                newNodes.add(graph.nodes.get(i));
            }
        }
        graph.nodes = newNodes;
    }

    private static void checkAndRemove(List<Node> nodes, List<Integer> indsToRemove, int currentInd) {
        Node node = nodes.get(currentInd);
        if (node.getGegree() == 2) {
            Node one = node.children.get(0);
            Node two = node.children.get(1);
            one.children.add(two);
            node.name = one.name;
            node.children = one.children;
            indsToRemove.add(nodes.indexOf(one));
            checkAndRemove(nodes, indsToRemove, currentInd);
        }
    }

    private static void printGraph(MyGraph graph) {
        int i = 0;
        for (Node node : graph.nodes) {
            System.out.print(i++ + " ");
            System.out.print(node + " --> ");
            node.children.forEach(System.out::print);
            System.out.print("\n");
        }
    }

    private class MyGraph {
        List<Node> nodes;
        public MyGraph(List<Node> nodes) {
            this.nodes = nodes;
        }
    }

    private class Node {
        String name;
        List<Node> children;

        public Node(String name) {
            this.name = name;
            this.children = new LinkedList<>();
        }

        int getGegree() {
            return children.size();
        }


        @Override
        public String toString() {
            return "{" + name + "}";
        }
    }

}
