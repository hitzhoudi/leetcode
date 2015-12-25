package leetcode;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}

public class PathSum {
	public boolean hasPathSum(TreeNode node, int sum) {
		if (node == null) return false;
		if (node.left == null && node.right == null)
			return node.val == sum;
		return hasPathSum(node.left, sum - node.val) || hasPathSum(node.right, sum - node.val);
	}

	public final static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		PathSum path_sum = new PathSum();
		System.out.println(path_sum.hasPathSum(root, 22));
	}
}
