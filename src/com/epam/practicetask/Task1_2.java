package com.epam.practicetask;

import java.util.Arrays;

public class Task1_2 {

    public static void main(String[] args) {

        System.out.println(isSwap("qwwwwwwww", "hdfhh"));
        System.out.println(isSwap("qwe", "ewq"));
        System.out.println(isSwap("qwe", "eqq"));
        System.out.println(isSwap("abcdefg", "agbcdef"));
        System.out.println(isSwap("abcdefg", "abcdeeg"));

    }

    public static boolean isSwap(String string, String original) {
        if (string.length() != original.length())
            return false;

        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        char[] originalChars = original.toCharArray();
        Arrays.sort(originalChars);

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != originalChars[i])
                return false;
        }
        return true;
    }


}
