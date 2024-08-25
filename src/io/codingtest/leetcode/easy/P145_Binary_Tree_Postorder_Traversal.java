package io.codingtest.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import io.codingtest.leetcode.common.TreeNode;

public class P145_Binary_Tree_Postorder_Traversal {

	public static void main(String[] args) {
		P145_Binary_Tree_Postorder_Traversal solution = new P145_Binary_Tree_Postorder_Traversal();
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		visit(root, result);
		return result;
	}

	private void visit(TreeNode current, List<Integer> visited) {
		if (current == null)
			return;
		visit(current.left, visited);
		visit(current.right, visited);
		visited.add(current.val);
	}
}
