package leetcode;

import java.util.LinkedList;
import java.util.List;

/* class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}*/

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode node, int sum) {
		List<List<Integer>> result = new LinkedList<>();
		if (node == null) return result;
		if (node.left == null && node.right == null) {
			if (node.val == sum) {
				List<Integer> cur_result = new LinkedList<>();
				cur_result.add(node.val);
				result.add(cur_result);
			}
			return result;
		}
		List<List<Integer>> left_result = pathSum(node.left, sum - node.val);
		List<List<Integer>> right_result = pathSum(node.right, sum - node.val);
		for (List<Integer> elem : left_result) {
			elem.add(0, node.val);
			result.add(elem);
		}
		for (List<Integer> elem : right_result) {
			elem.add(0, node.val);
			result.add(elem);
		}
		return result;
	}

	// 返回任意结点为终点的所有路径
	public List<List<Integer>> pathSumNode(TreeNode node, int sum) {
		List<List<Integer>> result = new LinkedList<>();
		if (node == null) return result;
		List<List<Integer>> left_result = pathSumNode(node.left, sum - node.val);
		List<List<Integer>> right_result = pathSumNode(node.right, sum - node.val);
		for (List<Integer> elem : left_result) {
			elem.add(0, node.val);
			result.add(elem);
		}
		for (List<Integer> elem : right_result) {
			elem.add(0, node.val);
			result.add(elem);
		}
		if (node.val == sum) {
			List<Integer> cur_result = new LinkedList<>();
			cur_result.add(node.val);
			result.add(cur_result);
		}
		return result;
	}

	public final static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(10);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(6);
		root.right.right.right = new TreeNode(1);
		PathSumII path_sum = new PathSumII();
		System.out.println(path_sum.pathSum(root, 22));
		System.out.println(path_sum.pathSumNode(root, 18));
	}
}
