package com.epam.quizz;

/* 1.	Последовательность Фибоначчи выглядит следующим образом 0 1 1 2 3 5 8 13 21 34 55 ..., то есть каждый последующий
член последовательности равен сумме двух предыдущих. На ввод поступает строка например вида «13213455».
Напишите программу, проверяющую является ли строка частью последовательности Фибоначчи. */
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
