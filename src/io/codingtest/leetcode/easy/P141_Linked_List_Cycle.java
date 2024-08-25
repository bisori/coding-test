package io.codingtest.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

import io.codingtest.leetcode.common.ListNode;

public class P141_Linked_List_Cycle {

	public static void main(String[] args) {
		P141_Linked_List_Cycle solution = new P141_Linked_List_Cycle();
	}

	public boolean hasCycle(ListNode head) {
		Set<ListNode> visited = new HashSet<>();

		ListNode current = head;
		while(current != null){
			if(visited.contains(current)){
				return true;
			}
			visited.add(current);
			current = current.next;
		}
		return false;
	}
}
