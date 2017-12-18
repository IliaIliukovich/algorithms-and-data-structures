package com.epam.quizz;

public class Task1 {

    public static void main(String[] args) {

        System.out.println(isInFibonachi("0"));
        System.out.println(isInFibonachi("1"));
        System.out.println(isInFibonachi("2"));
        System.out.println(isInFibonachi("3"));
        System.out.println(isInFibonachi("5"));
        System.out.println(isInFibonachi("8"));

        System.out.println(isInFibonachi("6"));
        System.out.println(isInFibonachi("13213455"));

    }

    public static boolean isInFibonachi(String str) {
        int testNumber = Integer.parseInt(str);
        if (testNumber == 0) return true;

        int currentNumber = 1;
        int previousNumber = 0;
        int tmp;
        do {
            tmp = currentNumber;
            currentNumber = currentNumber + previousNumber;
            previousNumber = tmp;

        } while (currentNumber < testNumber);
        return testNumber == currentNumber;
    }

}
