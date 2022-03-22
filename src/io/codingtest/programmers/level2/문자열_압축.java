package io.codingtest.programmers.level2;

import java.util.Iterator;
import java.util.function.BinaryOperator;
import java.util.stream.StreamSupport;

public class 문자열_압축 {

    public static void main(String[] args) {
        new 문자열_압축().solution("abcabcdede");
    }

    public int solution(String s) {
        int min = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            min = Math.min(min, encode(s, i));
        }
        return min;
    }

    private int encode(String s, int length) {
        Compressor compressor = new Compressor();
        StreamSupport.stream(new SubStringIterable(s, length).spliterator(), false)
          .reduce("", compressor);
        return compressor.getCompressed().length();
    }

    static class Compressor implements BinaryOperator<String> {

        StringBuilder stringBuilder = new StringBuilder();
        private int count = 0;
        private String last = "";

        @Override
        public String apply(String s, String s2) {
            if (s.equals(s2)) {
                count++;
            } else {
                if (count > 1) {
                    stringBuilder.append(count);
                }
                stringBuilder.append(s);
                count = 1;
            }
            last = s2;
            return s2;
        }

        public String getCompressed() {
            if (count > 1) {
                stringBuilder.append(count);
            }
            stringBuilder.append(last);
            return stringBuilder.toString();
        }
    }

    static class SubStringIterable implements Iterable<String> {

        private final String string;
        private final int length;
        private int pos = 0;

        public SubStringIterable(String string, int length) {
            this.string = string;
            this.length = length;
        }

        @Override
        public Iterator<String> iterator() {
            return new Iterator<String>() {
                @Override
                public boolean hasNext() {
                    return pos < string.length();
                }

                @Override
                public String next() {
                    String sub = (pos + length < string.length()) ? string.substring(pos, pos + length)
                      : string.substring(pos);
                    pos += sub.length();
                    return sub;
                }
            };
        }
    }
}
