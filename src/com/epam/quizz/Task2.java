package com.epam.quizz;

import java.util.Arrays;

/* 2.	Напишите программу, которая из всех возможных 9-ти значных чисел, образованных перестановкой цифр из набора
1,2,3,4,5,6,7,8,9 выбирает такие пары чисел, одно из которых является делителем второго. Например 123456789, 987654312. */
public class Task2 {

    public static void main(String[] args) {

//        //Brute force solution
//        for (int i = 123456789; i <= 987654321; i++) {
//            if (isSwap(String.valueOf(i), "123456789")) {
//                for (int j = 987654321; j > i ; j-- ) {
//                    if (j % i == 0 && isSwap(String.valueOf(j), "123456789")) {
//                        System.out.println(j + " " + i + " " + j/i);
//                    }
//                }
//            }
//        }

        //More efficient solution
        for (int swapValue = 123456789; swapValue <= 987654321 / 2; swapValue++) {
            if (isSwap(String.valueOf(swapValue), "123456789")) {
                for (int l = 2; l < 9; l++) {
                    int curNumber = swapValue * l;
                    if (curNumber > 987654321) break;
                    if (isSwap(String.valueOf(curNumber), "123456789")) {
                        System.out.println(curNumber + " " + swapValue + " " + l);
                    }
                }
            }
        }

    }

    public static boolean isSwap(String testString, String sortedSample) {
        char[] chars = testString.toCharArray();
        Arrays.sort(chars);
        char[] originalChars = sortedSample.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != originalChars[i])
                return false;
        }
        return true;
    }

}
