class LevelOrderTraversal{
	Node root;
	
	LevelOrderTraversal(){
		root = null;
	}
	
	int height(Node root) {
		if(root == null) {
			return 0;
		}
		
		int lHeight = height(root.left);
		int rHeight = height(root.right);
		
		return lHeight > rHeight ? lHeight+1 : rHeight+1;
	}
	
	void printLevelOrder(Node root) {
		int height = height(root);
		for(int i=0;i<=height;i++) {
			printLevel(root, i);
		}
	}
	
	void printLevel(Node root, int level) {
		if(root == null) {
			return;
		}
		if(level==1) {
			System.out.print(root.data + "  ");
		}else if(level>1){
			printLevel(root.left, level-1);
			printLevel(root.right, level-1);
		}
	}
	
	public static void main(String args[]) {
		LevelOrderTraversal tree = new LevelOrderTraversal();
		tree.root = new Node(5);
		tree.root.left = new Node(10);
		tree.root.right = new Node(15);
		tree.root.left.left = new Node(11);
		tree.root.left.right = new Node(16);
		tree.root.right.left = new Node(17);
		tree.root.right.right = new Node(18);
		tree.root.left.left.left = new Node(13);
		
		tree.printLevelOrder(tree.root);
		
	}
	
}