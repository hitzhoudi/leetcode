package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> queue = new PriorityQueue<>(1,
			new Comparator<ListNode>(){
				public int compare(ListNode a, ListNode b) {
					return a.val - b.val;
				}
			});
		for (ListNode elem : lists)
			if (elem != null)
				queue.offer(elem);
		ListNode head = new ListNode(-1);
		ListNode cur = head;
		while (queue.size() != 0) {
			ListNode tmp = queue.poll();
			if (tmp.next != null)
				queue.offer(tmp.next);
			tmp.next = null;
			cur.next = tmp;
			cur = cur.next;
		}
		return head.next;
	}
}
