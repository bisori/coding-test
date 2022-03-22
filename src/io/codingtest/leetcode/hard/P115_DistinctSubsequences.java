package io.codingtest.leetcode.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P115_DistinctSubsequences {

    public static void main(String[] args) {
        new P115_DistinctSubsequences().numDistinct("azebakwgba", "bag");
    }

    public int bestPractice(String S, String T) {
        int[][] mem = new int[T.length() + 1][S.length() + 1];

        for (int j = 0; j <= S.length(); j++) {
            mem[0][j] = 1;
        }

        for (int i = 0; i < T.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (T.charAt(i) == S.charAt(j)) {
                    mem[i + 1][j + 1] = mem[i][j] + mem[i + 1][j];
                } else {
                    mem[i + 1][j + 1] = mem[i + 1][j];
                }
            }
        }

        return mem[T.length()][S.length()];
    }

    public int numDistinct(String s, String t) {
        int count = 0;
        Node root = new Node();
        for (int i = 0; i < s.length(); i++) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            for (int j = 0; j < t.length(); j++) {
                List<Node> children = new ArrayList<>();
                while (!q.isEmpty()) {
                    Node node = q.poll();
                    children.addAll(node.getChildren());
                    if (s.charAt(i) == t.charAt(j)) {
                        int level = node.addChild(s.charAt(i));
                        if (level == t.length()) {
                            count++;
                        }
                    }
                }
                if (children.isEmpty()) {
                    break;
                }
                q.addAll(children);
            }
        }
        return count;
    }

    class Node {

        int level;
        char val;
        List<Node> children = new ArrayList<>();

        public Node() {
            this.level = 0;
            this.val = ' ';
        }

        public Node(int level, char val) {
            this.level = level;
            this.val = val;
        }

        public int addChild(char val) {
            Node child = new Node(this.level + 1, val);
            this.children.add(child);
            return child.level;
        }

        public List<Node> getChildren() {
            return this.children;
        }
    }
}
