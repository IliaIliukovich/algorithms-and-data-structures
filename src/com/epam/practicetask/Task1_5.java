package com.epam.practicetask;

public class Task1_5 {

    public static void main(String[] args) {

        // true
        System.out.println(isOneModificationDistance("abcde", "abcde"));
        System.out.println(isOneModificationDistance("abcde", "abde"));
        System.out.println(isOneModificationDistance("abcde", "abccde"));
        System.out.println(isOneModificationDistance("abcde", "abdde"));
        System.out.println(isOneModificationDistance("a", "ab"));
        System.out.println(isOneModificationDistance("a", "ba"));
        System.out.println(isOneModificationDistance("a", "b"));

        // false
        System.out.println(isOneModificationDistance("a", "abd"));
        System.out.println(isOneModificationDistance("a", "bd"));
        System.out.println(isOneModificationDistance("abccd", "acccde"));
        System.out.println(isOneModificationDistance("abcde", "abchdf"));
    }



    public static boolean isOneModificationDistance(String string, String original) {
        char[] chars1 = string.length() < original.length() ? string.toCharArray() : original.toCharArray();
        char[] chars2 = string.length() < original.length() ? original.toCharArray() : string.toCharArray();
        if (chars1.length < chars2.length - 1) {
            return false;
        }

        int modificationCount = 0;

        if (chars1.length == chars2.length) {
            for (int i = 0; i < chars1.length; i++) {
                if (chars1[i] != chars2[i]) {
                        modificationCount++;
                }
            }
            return modificationCount <= 1;
        } else {
            for (int i = 0, j = 0; i < chars1.length; i++, j++) {
                if (chars1[i] != chars2[j]) {
                    if (modificationCount == 0) {
                        modificationCount++;
                        i--;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }


}
