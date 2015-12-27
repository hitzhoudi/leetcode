package problems;

import java.util.Random;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

public class MergeSortLinkList {
	public ListNode mergeSortLinkList(ListNode head) {
		ListNode[] part = partition(head);
		if (part[1] == null)
			return part[0];
		ListNode left = mergeSortLinkList(part[0]);
		ListNode right = mergeSortLinkList(part[1]);
		return merge(left, right);
	}

	public ListNode merge(ListNode left, ListNode right) {
		ListNode head = new ListNode(-1);
		ListNode cur = head;
		while (left != null && right != null) {
			if (left.val < right.val) {
				cur.next = left;
				left = left.next;
			} else {
				cur.next = right;
				right = right.next;
			}
			cur = cur.next;
			cur.next = null;
		}
		if (left != null) {
			cur.next = left;
		} else if (right != null) {
			cur.next = right;
		}
		return head.next;
	}

	public ListNode[] partition(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode[] result = new ListNode[2];
		result[0] = head;
		result[1] = slow.next;
		slow.next = null;
		return result;
	}

	public final static void main(String[] args) {
		Random randomGenerator = new Random();
		ListNode head = new ListNode(randomGenerator.nextInt(100));
		ListNode cur = head;
		int c = 0;
		while (c < 100) {
			cur.next = new ListNode(randomGenerator.nextInt(100));
			cur = cur.next;
			++c;
		}
		cur = head;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		System.out.println("");
		MergeSortLinkList solution = new MergeSortLinkList();
		ListNode sorted_head = solution.mergeSortLinkList(head);
		while (sorted_head != null) {
			System.out.print(sorted_head.val + " ");
			sorted_head = sorted_head.next;
		}
/*		ListNode[] res = solution.partition(head);
		System.out.println(res[0]);
		System.out.println(res[1]);
		ListNode left = res[0], right = res[1];
		while (left != null) {
			System.out.print(left.val + " ");
			left = left.next;
		}
		System.out.println("");
		while (right != null) {
			System.out.print(right.val + " ");
			right = right.next;
		}*/
	}
	
}
