package com.epam.practicetask;

public class Task3_2 {

    public static void main(String[] args) {

        MyStack<Integer> myStack = new Task3_2().new MyStack<>();
        myStack.push(1);
        myStack.push(7);
        myStack.push(3);
        myStack.push(-2);
        myStack.push(3);
        myStack.push(15);
        myStack.push(0);

        System.out.println("Min = " + myStack.min());

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }


    private class MyStack<T extends Comparable<T>>{

        Node first;

        void push(T t) {
            Node node = new Node();
            node.value = t;
            node.next = first;
            node.curMin = (first == null || t.compareTo(first.curMin.value) < 0) ? node : first.curMin;
            first = node;
        }

        T pop() {
            if (first == null) throw new RuntimeException("No elements");
            T value = first.value;
            first = first.next;
            return value;
        }

        T min() {
            if (first == null) throw new RuntimeException("No elements");
            return first.curMin.value;
        }

        class Node {
            T value;
            Node curMin;
            Node next;
        }

    }
}
