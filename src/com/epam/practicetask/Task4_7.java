package com.epam.practicetask;

import java.util.*;

public class Task4_7 {

    public static void main(String[] args) {

        List<String> projectList = Arrays.asList("a", "b", "c", "d", "e", "f");
        List<String[]> dependencies = new LinkedList<>();
        dependencies.add(new String[]{"d", "a"});
        dependencies.add(new String[]{"b", "f"});
        dependencies.add(new String[]{"d", "b"});
        dependencies.add(new String[]{"a", "f"});
        dependencies.add(new String[]{"c", "d"});

        Queue<Node> projectOrder = new Task4_7().buildProjectOrder(projectList, dependencies);
        System.out.println("Result:");
        System.out.println(projectOrder);
    }

    private Queue<Node> buildProjectOrder(List<String> projectList, List<String[]> dependencies) {
        MyGraph graph = generateProjectGraph(projectList, dependencies);
        printGraph(graph);
        checkIsBuildable(graph);
        Deque<Node> projectOrder = new LinkedList<>();
        int i = 0;
        while (projectOrder.size() != projectList.size()) {
            i = (i + 1) % projectList.size();
            if (!projectOrder.contains(graph.nodes[i]) && projectOrder.containsAll(graph.nodes[i].children)) {
                projectOrder.addFirst(graph.nodes[i]);
            }
        }
        return projectOrder;
    }

    //DFS implementation
    public void checkIsBuildable(MyGraph graph) {
        for (int i = 0; i < graph.nodes.length; i++) {
            Arrays.stream(graph.nodes).forEach(node -> node.marked = false);
            check(graph.nodes[i], graph.nodes[i]);
        }
    }

    private void check(Node start, Node end) {
        start.marked = true;
        if (start.children.contains(end)) {
            throw new RuntimeException("Error! Cyclic dependencies found: " + start + " --> " + end);
        }
        for (Node node : start.children) {
            if (!node.marked) {
                check(node, end);
            }
        }
    }


    private MyGraph generateProjectGraph(List<String> projectList, List<String[]> dependencies) {
        Node[] nodes = new Node[projectList.size()];
        for (int i = 0; i < projectList.size(); i++) {
            nodes[i] = new Node(projectList.get(i));
        }
        for (String[] dependency : dependencies) {
            nodes[projectList.indexOf(dependency[1])].children.add(nodes[projectList.indexOf(dependency[0])]);
        }
        return new MyGraph(nodes);
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
        Node[] nodes;

        public MyGraph(Node[] nodes) {
            this.nodes = nodes;
        }
    }

    private class Node {
        String name;
        List<Node> children;
        boolean marked;

        public Node(String name) {
            this.name = name;
            this.children = new LinkedList<>();
        }

        @Override
        public String toString() {
            return "{" + name + " marked = " + marked + "}";
        }
    }

}
