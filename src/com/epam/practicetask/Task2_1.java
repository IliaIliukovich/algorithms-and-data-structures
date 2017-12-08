package com.epam.practicetask;

import java.util.*;

public class Task2_1 {

    public static void main(String[] args) {

        LinkedList<Integer> testList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 4, 3, 5, 1, 6, 2));
        System.out.println(testList);
        removeDublicatesWithSet(testList);
        System.out.println(testList);

    }

    private static void removeDublicatesWithSet(LinkedList<Integer> testList) {
        Set<Integer> set = new HashSet<>();
        Iterator<Integer> iterator = testList.iterator();
        while (iterator.hasNext()) {
            Integer cur = iterator.next();
            if (set.contains(cur)) {
                iterator.remove();
            } else {
                set.add(cur);
            }
        }
    }

}
