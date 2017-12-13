package com.epam.practicetask;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Task4_3 {

    public static void main(String[] args) {

        Tree<String> tree = new Task4_3().new Tree<>();
        Tree<String>.Node node7 = tree.new Node("Seven", null, null);
        Tree<String>.Node node6 = tree.new Node("Six", null, null);
        Tree<String>.Node node5 = tree.new Node("Five", null, null);
        Tree<String>.Node node4 = tree.new Node("Four", null, null);
        Tree<String>.Node node3 = tree.new Node("Three", node6, node7);
        Tree<String>.Node node2 = tree.new Node("Two", node4, node5);
        Tree<String>.Node node1 = tree.new Node("One", node2, node3);
        tree.root = node1;

        System.out.println("Natural order:");
        tree.forEach(e -> {
            System.out.print(" " + e);
        });
        System.out.print("\n");

        List<List<Tree<String>.Node>> listOfLists = tree.generateList();
        listOfLists.forEach(e -> {
            System.out.println("List:");
            e.forEach(node -> System.out.print(" " + node.value));
            System.out.print("\n");

        });

    }

    private class Tree<T> implements Iterable<T>{

        Node root;

        List<T> createIteratorList(Node root) {
            List<T> list = new LinkedList<>();
            traverce(root, list);
            return list;
        }

        void traverce(Node node, List<T> list) {
            if (node != null) {
                traverce(node.left, list);
                list.add(node.value);
                traverce(node.right, list);
            }
        }

        List<List<Node>> generateList() {
            List<List<Node>> lisOfList = new LinkedList<>();
            gerenateListForLevel(root, 0, lisOfList);
            return lisOfList;
        }

        private void gerenateListForLevel(Node current, int level, List<List<Node>> lisOfList) {
            if (current != null) {
                if (level >= lisOfList.size()) {
                    lisOfList.add(new LinkedList<>());
                }
                lisOfList.get(level).add(current);
                gerenateListForLevel(current.left, level + 1, lisOfList);
                gerenateListForLevel(current.right, level + 1, lisOfList);
            }
        }

        @Override
        public Iterator<T> iterator() {
            List<T> list = createIteratorList(root);
            return list.iterator();
        }

        class Node {
            T value;
            Node left;
            Node right;

            Node(T value, Node left, Node right) {
                this.value = value;
                this.left = left;
                this.right = right;
            }

        }
    }

}
