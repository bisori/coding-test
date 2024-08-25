package io.codingtest.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

import io.codingtest.leetcode.common.ListNode;

public class P160_Intersection_of_Two_Linked_Lists {

	public static void main(String[] args) {
		P160_Intersection_of_Two_Linked_Lists solution = new P160_Intersection_of_Two_Linked_Lists();
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		Set<ListNode> visited = new HashSet<>();

		ListNode currentA = headA;
		while (currentA != null) {
			visited.add(currentA);
			currentA = currentA.next;
		}

		ListNode currentB = headB;
		while (currentB != null) {
			if (visited.contains(currentB)) {
				return currentB;
			}
			currentB = currentB.next;
		}
		return null;
	}
}
