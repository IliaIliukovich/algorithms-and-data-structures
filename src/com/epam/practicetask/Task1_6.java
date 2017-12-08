package com.epam.practicetask;

public class Task1_6 {


    public static void main(String[] args) {
        System.out.println(zipString("abcdef"));
        System.out.println(zipString("abbcddddeff"));
        System.out.println(zipString("goooooooooogleeeeeeee"));
    }

    public static String zipString(String string) {
        String encodedString = encode(string);
        System.out.println(string + " --> " + encodedString);
        return encodedString.length() < string.length() ? encodedString : string;
    }

    private static String encode(String string) {
        char[] chars = string.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int repeatedCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (repeatedCount == 0) {
                if (i == chars.length - 1 || chars[i] != chars[i + 1]) {
                    stringBuilder.append(new CharCode(1, chars[i]));
                } else {
                    repeatedCount++;
                }
            } else {
                repeatedCount++;
                if (i == chars.length - 1 || chars[i] != chars[i + 1]) {
                    stringBuilder.append(new CharCode(repeatedCount, chars[i]));
                    repeatedCount = 0;
                }
            }
        }
        return stringBuilder.toString();
    }

    private static class CharCode {

        int numberOfRepeats;
        char value;

        public CharCode(int numberOfRepeats, char value) {
            this.numberOfRepeats = numberOfRepeats;
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(numberOfRepeats) + value;
        }
    }
}
