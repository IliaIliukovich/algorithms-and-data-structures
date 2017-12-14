package com.epam.practicetask;

import java.util.Arrays;
import java.util.HashMap;

public class Task1_4 {

    public static void main(String[] args) {

        System.out.println("Sorting approach:");
        System.out.println(isSwapToPalidrom("abc"));
        System.out.println(isSwapToPalidrom("abcba"));
        System.out.println(isSwapToPalidrom("abcdcba"));
        System.out.println(isSwapToPalidrom("dcbabca"));
        System.out.println(isSwapToPalidrom("abcddcba"));
        System.out.println(isSwapToPalidrom("dcbabcda"));
        System.out.println(isSwapToPalidrom("abccbd"));
        System.out.println(isSwapToPalidrom("aaabb"));

        System.out.println("HashMap approach:");
        System.out.println(isSwapToPalidromHashMap("abc"));
        System.out.println(isSwapToPalidromHashMap("abcba"));
        System.out.println(isSwapToPalidromHashMap("abcdcba"));
        System.out.println(isSwapToPalidromHashMap("dcbabca"));
        System.out.println(isSwapToPalidromHashMap("abcddcba"));
        System.out.println(isSwapToPalidromHashMap("dcbabcda"));
        System.out.println(isSwapToPalidromHashMap("abccbd"));
        System.out.println(isSwapToPalidromHashMap("aaabb"));

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

    public static boolean isSwapToPalidromHashMap(String string) {
        char[] chars = string.toCharArray();
        HashMap<Character, Boolean> map = new HashMap<>();
        int singleCharCount = 0;
        for (char c : chars) {
            singleCharCount++;
            Boolean old = map.put(c, true);
            if (old != null) {
                singleCharCount = singleCharCount - 2;
                map.put(c, null);
            }
        }
        return singleCharCount <= 1;
    }


}
