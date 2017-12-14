package com.epam.practicetask;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Task4_1 {

    public static void main(String[] args) {

        MyGraph graph = new Task4_1().new MyGraph();

        System.out.println(graph.canIgetBFS(0, 0));
        System.out.println(graph.canIgetBFS(0, 1));
        System.out.println(graph.canIgetBFS(0, 2));
        System.out.println(graph.canIgetBFS(0, 3));
        System.out.println(graph.canIgetBFS(0, 4));
        System.out.println(graph.canIgetBFS(0, 5));
        System.out.println(graph.canIgetBFS(0, 6));
        System.out.println(graph.canIgetBFS(0, 7));
        System.out.println(graph.canIgetBFS(0, 8));
        System.out.println(graph.canIgetBFS(0, 9));
        System.out.println(graph.canIgetBFS(0, 10));
    }

    class MyGraph {

        List<List<Integer>> graph;

        public MyGraph() {
            graph = new ArrayList<>();
            graph.add(new LinkedList<>());
            graph.add(new LinkedList<>());
            graph.add(new LinkedList<>());
            graph.add(new LinkedList<>());
            graph.add(new LinkedList<>());
            graph.add(new LinkedList<>());
            graph.add(new LinkedList<>());
            graph.add(new LinkedList<>());
            graph.add(new LinkedList<>());
            graph.add(new LinkedList<>());
            graph.add(new LinkedList<>());
            graph.get(0).add(1);
            graph.get(0).add(2);
            graph.get(2).add(3);
            graph.get(3).add(4);
            graph.get(3).add(5);
            graph.get(6).add(7);
            graph.get(2).add(8);
            graph.get(2).add(9);
            graph.get(8).add(10);
            graph.get(9).add(10);
        }

        //DFS implementation
        public boolean canIgetDFS(int from, int to) {
            if (from == to) return true;
            CanIget canIget = new CanIget();
            check(from, to, canIget);
            return canIget.can;
        }

        //BFS implementation
       public boolean canIgetBFS(int from, int to) {
            if (from == to) return true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(from);
            while (!queue.isEmpty()) {
                Integer current = queue.poll();
                if (graph.get(current).contains(to)) {
                    return true;
                }
                queue.addAll(graph.get(current));
            }
            return false;
        }

        private void check(int from, int to, CanIget canIget) {
            if (!canIget.can) {
                if (graph.get(from).contains(to)) {
                    canIget.can = true;
                } else {
                    for (Integer node : graph.get(from)) {
                        check(node, to, canIget);
                    }
                }
            }
        }

        private class CanIget {
            boolean can  = false;
        }
    }
}
