package com.epam.practicetask;

import java.util.Arrays;

public class Task1_4 {

    public static void main(String[] args) {

        System.out.println(isSwapToPalidrom("abc"));
        System.out.println(isSwapToPalidrom("abcba"));
        System.out.println(isSwapToPalidrom("abcdcba"));
        System.out.println(isSwapToPalidrom("dcbabca"));
        System.out.println(isSwapToPalidrom("abcddcba"));
        System.out.println(isSwapToPalidrom("dcbabcda"));
        System.out.println(isSwapToPalidrom("abccbd"));
        System.out.println(isSwapToPalidrom("aaabb"));

    }

    public static boolean isSwapToPalidrom(String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);

        int singleCharCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if ((i == chars.length - 1) || (chars[i] != chars[i + 1])) {
                if (++singleCharCount > 1) {
                    return false;
                }
            } else {
                i++;
            }
        }
        return true;
    }


}
