package com.epam.practicetask;

import javafx.fxml.FXMLLoader;

import java.util.Arrays;

public class Task3_5 {

    public static void main(String[] args) {

        MyStack<Integer> myStack = new Task3_5().new MyStack<>();
        myStack.push(1);
        myStack.push(7);
        myStack.push(3);
        myStack.push(-2);
        myStack.push(3);
        myStack.push(15);
        myStack.push(0);

        System.out.println(myStack);

        myStack.sort();

        System.out.println(myStack);
    }


    private class MyStack<T extends Comparable<T>>{

        Node first;
        int size = 0;

        void push(T t) {
            Node node = new Node();
            node.value = t;
            node.next = first;
            first = node;
            size++;
        }

        T pop() {
            if (first == null) throw new RuntimeException("No elements");
            T value = first.value;
            first = first.next;
            size--;
            return value;
        }

        void sort() {

            Object[] t = new Object[size];
            Node tmp = first;
            for (int i = 0; i < size; i++) {
                t[i] = tmp.value;
                tmp = tmp.next;
            }
            Arrays.sort(t);
            Node prevNode = null;
            for (int i = size - 1; i >= 0; i--) {
                Node node = new Node();
                node.value = (T) t[i];
                node.next = prevNode;
                prevNode = node;
            }
            first = prevNode;
        }

        class Node {
            T value;
            Node next;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            Node tmp = first;
            while (tmp != null){
                stringBuilder.append(tmp.value).append(" ");
                tmp = tmp.next;
            }
            return stringBuilder.toString();
        }
    }
}
