/*Implement a function to check if a binary tree is balanced. For the purposes of this question, 
 * a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never 
 * differ by more than one.
 */

class CheckBalancing {
	
	public boolean isBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}
		
		int lh, rh;
		
		lh = height(root.left);
		rh = height(root.right);
		
		if(Math.abs(lh - rh) < 2 && isBalanced(root.left) && isBalanced(root.right)) {
			return true;
		}
		return false;
	}
	
	int height(TreeNode node) {
		if(node == null) {
			return 0;
		}else {
			return 1 + Math.max(height(node.left), height(node.right));
		}
	}
	
	public static void main(String args[]) {
		BinaryTree bt = new BinaryTree(7);
		
		bt.root.left = new TreeNode(8);
		bt.root.right = new TreeNode(9);
		
		bt.root.left.left = new TreeNode(10);
		bt.root.left.right = new TreeNode(11);
		
		bt.root.left.right.left = new TreeNode(12);
		bt.root.left.right.right = new TreeNode(13);
		
		CheckBalancing cb = new CheckBalancing();
		
		
		System.out.print("is Balanced : " + cb.isBalanced(bt.root));
	}
}