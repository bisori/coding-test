package io.codingtest.leetcode.medium;

import java.util.Arrays;

public class P443_StringCompression {

    public static void main(String[] args) {
        char[] input = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(Arrays.toString(input));
        int output = new P443_StringCompression().compress(input);
        System.out.println(Arrays.toString(Arrays.copyOf(input, output)));
    }

    public int compress(char[] chars) {
        int pos = 0;
        char current = chars[0];
        int count = 0;
        for (char ch : chars) {
            if (current == ch) {
                count++;
            } else {
                pos = putNumber(chars, pos, current, count);
                current = ch;
                count = 1;
            }
        }
        pos = putNumber(chars, pos, current, count);
        return pos;
    }

    private int putNumber(char[] chars, int pos, char ch, int count) {
        chars[pos++] = ch;
        if (count > 1) {
            for (char c : String.valueOf(count).toCharArray()) {
                chars[pos++] = c;
            }
        }
        return pos;
    }

}
