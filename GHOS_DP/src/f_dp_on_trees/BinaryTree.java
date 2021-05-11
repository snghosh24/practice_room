package f_dp_on_trees;

public class BinaryTree {

	private TreeNode root;

	public static class TreeNode {

		TreeNode left;
		TreeNode right;
		int data;

		public TreeNode(int data) {
			this.data = data;
		}
	}

	public TreeNode createBinaryTree() {

		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		
		root.right.left.left = new TreeNode(-20);
		root.right.right.right = new TreeNode(-20);
		
		root.right.left.left.right = new TreeNode(9);
		root.right.right.right.right = new TreeNode(10);
		
		root.right.left.left.right.right = new TreeNode(11);
		root.right.right.right.right.left = new TreeNode(12);
		
		return root;
	}

}
/*
Binary Tree:
 
       1
      / \
     2   3
    / \
   4   5
   \
    6
    
    
*/
