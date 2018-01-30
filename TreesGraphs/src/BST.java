import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/*Given a sorted (increasingorder) array with unique integer elements, write an algorithm to createa binary search tree with minimal height.*/


class BST{
	TreeNode root = null;
	int inputArr[];
	void createMinHeightBST() {
		root = buildTree(  0 , inputArr.length -1);
		CreateDepthList(this);
		System.out.println("Is it BST? "+ isBST(this.root));
		
		//successorNode(root.left.right); //Find successor node
		
		/* 
		//Find common parent
		TreeNode n1,n2;
		n1 = root.left.left;
		n2 = root.left.right;
		TreeNode cp = commonParent(this.root, n1, n2);
		System.out.println("\nCommon parent of "+n1.data + " and "+ n2.data + " is: "+ cp.data);
		*/
	}
	
	TreeNode buildTree(int beg, int end) {
		if(beg == end) {
			//System.out.print("\nbeg = end " + beg);
			System.out.print("\nroot"+beg );
			return new TreeNode(inputArr[beg]);
		}
		
		int rootIndex = (end-beg)/2 + beg;
		TreeNode newRoot = new TreeNode(inputArr[rootIndex]);
		System.out.print("\nroot"+rootIndex );
		newRoot.left = rootIndex-1 < beg ? null : buildTree( beg , rootIndex - 1 );
		newRoot.right = rootIndex+1 > end ? null: buildTree(rootIndex + 1 , end );
		
		return newRoot;
	}
	
	
	/*Given a binary tree, design an algorithm which creates a linked list of all the nodes 
	 * at each depth (e.g., if you have a tree with depth D,you'll have D linked lists).*/

	void CreateDepthList(BST tree) {
		if(tree.root == null) {
			System.out.print("Tree is empty");
			return;
		}
		System.out.println();
		
		LinkedList<TreeNode>[] lists = new LinkedList[100];
		lists[0] = new LinkedList<TreeNode>();
		lists[0].addLast(tree.root);
		int last = 0;
		
		while(lists[last].size() > 0) {
			lists[last+1] = new LinkedList<TreeNode>();
			for(int i=0;i<lists[last].size();i++) {
				TreeNode cur = lists[last].get(i);
				
				if(cur.left!=null) {
					lists[last+1].addLast(cur.left);
				}
				if(cur.right!=null) {
					lists[last+1].addLast(cur.right);
				}
			}
			last+=1;
		}
		for(int i =0;i<lists.length && lists[i].size()>0;i++) {
			ListIterator<TreeNode> iter = lists[i].listIterator();
			while (iter.hasNext()) {
				System.out.print(iter.next().data + "  ");
			}
			System.out.println();
		}
	}
	
	/*Implement a function to check if a binary tree is a binary search tree.*/
	boolean isBST(TreeNode root) {
		if(root == null) {
			return true;
		}
		if((root.left==null || root.left.data < root.data) && (root.right== null || root.right.data > root.data)) {
			return (isBST(root.left) && isBST(root.right));
		}
		return false;
	}
	
	/*Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. 
	 * Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
	 */
	 
	TreeNode commonParent(TreeNode root, TreeNode n1, TreeNode n2) {
		if(root == null) {
			return null;
		}
		if(root == n1 || root == n2) {
			return root;
		}
		TreeNode find_left = commonParent(root.left,n1,n2);
		TreeNode find_right = commonParent(root.right,n1,n2);
		
		if(find_left != null && find_right != null) {
			return root;
		}
		
		return find_left == null? find_right: find_left;
		
	}

	/*Write an algorithm to find the'next'node (i.e., in-order successor) of a given node 
	 * in a binary search tree. You may assume that each node has a link to its parent.*/
	void successorNode(TreeNode node) {
		if(node == null) {
			return;
		}else {
			if(node.right!=null) {
				TreeNode next = node.right;
				while(next.left!=null) {
					next = next.left;
				}	
				System.out.print("successor of node "+node.data+"is: "+next.data);
			}else {
				//Traverse up till we find an ancestor which is next
			}
			
		}
	}
	
	
	ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> uniquePath = new ArrayList<Integer>();
	
	/* Algorithm to print all the paths possible from root to leaf in a binary tree*/
	void allPaths(TreeNode root) {
		if(root == null) {
			return;
		}
		uniquePath.add(root.data);
		if(root.left == null && root.right == null) {
			paths.add((ArrayList<Integer>)uniquePath.clone());
			
		}
		if(root.left != null) {
			allPaths(root.left);
		}
		if(root.right != null) {
			allPaths(root.right);
		}
		uniquePath.remove(uniquePath.size()-1);
	}
	
	void printPaths() {
		System.out.println("\nAll paths in the given tree: ");
		for(int i = 0;i<paths.size();i++) {
			ArrayList arr = paths.get(i);
			for(int j=0;j<arr.size();j++) {
				System.out.print(arr.get(j) + ", ");
			}
			System.out.println();
		}
	}
	
	/*Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum. -- no negatives*/
	boolean findPaths(TreeNode root, int sum, int runningSum) {
		if(root == null) {
			return false;
		}
		
		int currentSum = runningSum + root.data;
		
		uniquePath.add(root.data);
		
		//leaf node condition
		if(root.left == null && root.right == null ) {
			if(currentSum == sum) {
				paths.add((ArrayList<Integer>)uniquePath.clone());
				
			}else {
				uniquePath.remove(uniquePath.size()-1);
				return false;
			}
		}
		
		
		boolean isLeft = findPaths(root.left, sum, currentSum);
		boolean isRight = findPaths(root.right, sum, currentSum);
		
		if((!isRight && !isLeft) || (!isRight && root.left == null) || (!isLeft &&  root.right == null)) {
			uniquePath.remove(uniquePath.size()-1);
			return false;
		}
		return true;
	}
	
	
	public static void main(String args[]) {
		BST tree = new BST();
		//tree.inputArr =  new int[]{0,1,2,3,4,5,6,7,8,9,10,11}; // bst with increasing order array
		//tree.inputArr =  new int[]{1,1,1,1,1,2}; // multiple same sum path from root to leaf
		tree.inputArr =  new int[]{-5,-5,-5,-5,-5,-1};
		//tree.inputArr =  new int[]{1000,1,2,3,4,5,6,7,8,9,10,10}; check of is it BST false condition;
		tree.createMinHeightBST(  );
		
		//tree.allPaths(tree.root);
		//tree.printPaths();
		
		//tree.findPaths(tree.root, 3, 0);
		//tree.printPaths();
		
		tree.findPaths(tree.root, -15, 0);
		tree.printPaths();
	}
	
	
	
	
	
}