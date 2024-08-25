package io.codingtest.leetcode.common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode build(Integer[] values) {
        return null; //TODO
    }

    public static void buildChild(TreeNode node, Integer[] values, int pos) {
        if (pos + 1 > values.length) {
            return;
        }
        if (values[pos] != null) {
            node.left = new TreeNode(values[pos]);
            buildChild(node.left, values, 0);
        }
        if (values[pos + 1] != null) {
            node.right = new TreeNode(values[pos + 1]);
            buildChild(node.right, values, 0);
        }
    }


}
