package f_dp_on_trees;

import f_dp_on_trees.BinaryTree.TreeNode;

public class B_MaximumPathSum_AnyToAny {

	private static class Result {

		static int val;

		Result(int val) {
			this.val = val;
		}
	}

	public static int maxSumPathOfBinaryTree(TreeNode root, Result res) {

		if (root == null) {
			return 0;
		}

		int l = maxSumPathOfBinaryTree(root.left, res);
		int r = maxSumPathOfBinaryTree(root.right, res);

		int temp = Math.max(Math.max(l, r) + root.data, root.data);
		int ans = Math.max(temp, l + r + root.data);
		res = new Result(Math.max(Result.val, ans));

		return temp;

	}

	public static int maxSumPath(TreeNode root) {

		Result res = new Result(Integer.MIN_VALUE);
		maxSumPathOfBinaryTree(root, res);

		return Result.val;

	}

	public static void main(String[] args) {


		BinaryTree bt = new BinaryTree();
		TreeNode root=bt.createBinaryTree();
		
		System.out.println("Max Sum Path="+maxSumPath(root));		

	}

}
