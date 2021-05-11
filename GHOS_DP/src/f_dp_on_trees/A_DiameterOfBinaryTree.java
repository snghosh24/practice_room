package f_dp_on_trees;

import f_dp_on_trees.BinaryTree.TreeNode;

public class A_DiameterOfBinaryTree {
	
	private static class Result{
		
		static int val;
		Result(int val){
			this.val=val;
		}
	}
	
	public static int diameterOfBinaryTree(TreeNode root, Result res) {
		
		if(root==null) {
			return 0;
		}
		
		int l=diameterOfBinaryTree(root.left, res);
		int r=diameterOfBinaryTree(root.right, res);
		
		int temp=Math.max(l, r)+1;
		int ans=Math.max(temp, l+r+1);
		res=new Result(Math.max(Result.val, ans));
		
		return temp;
		
	}
	
	public static int diameter(TreeNode root) {
		
		Result res=new Result(Integer.MIN_VALUE);
		diameterOfBinaryTree(root, res);
		
		return Result.val;
		
	}

	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		TreeNode root=bt.createBinaryTree();
		
		System.out.println("Diameter="+diameter(root));		
		

	}

}
