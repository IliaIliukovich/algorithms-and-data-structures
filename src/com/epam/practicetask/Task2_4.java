package com.epam.practicetask;

import java.util.Iterator;

public class Task2_4 {

    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(10);
        myLinkedList.add(5);
        myLinkedList.add(8);
        myLinkedList.add(5);
        myLinkedList.add(3);

        System.out.println("Before: " + myLinkedList);
        myLinkedList.sortBy(5);
        System.out.println("After:  " + myLinkedList);

    }

    public static class MyLinkedList  implements Iterable<Integer>{

        private Node first;
        private Node last;

        private class Node {
            Integer value;
            Node next;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {

                private Node current = first;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public Integer next() {
                    Node tmp = current;
                    current = current.next;
                    return tmp.value;
                }
            };
        }

        public void add (Integer t) {
            Node newNode = new Node();
            newNode.value = t;
            newNode.next = first;
            first = newNode;
            if (last == null) last = first;
        }

        public void sortBy(Integer number) {
            if (first == null) return;

            Node current = first;
            Node prev = null;
            Node tail = last;
            while (current != tail) {
                if (current.value >= number) {
                    addToTail(prev, current);
                    if (first == current) first = current.next;
                } else {
                    prev = current;
                }
                current = current.next;
            }
        }

        private void addToTail(Node prev, Node current) {
            if (prev != null ) prev.next = current.next;
            Node tmp = last;
            last = new Node();
            last.value = current.value;
            tmp.next = last;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator<Integer> iterator = iterator();
            while (iterator.hasNext()) {
                stringBuilder.append(" " + iterator.next());
            }
            return stringBuilder.toString();
        }
    }
}
