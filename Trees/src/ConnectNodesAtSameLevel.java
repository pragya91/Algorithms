import java.util.LinkedList;
import java.util.Queue;

class CNode{
	int data;
	CNode left;
	CNode right;
	CNode nextRight;
	
	CNode(int val){
		data = val;
		left = null;
		right = null;
		nextRight = null;
		
	}
}

class ConnectNodesAtSameLevel{
	CNode root;
	
	ConnectNodesAtSameLevel(){
		root = null;
	}
	
	int height(CNode root) {
		if(root == null)
			return 0;
		int lHeight = height(root.left);
		int rHeight = height(root.right);
		
		return lHeight > rHeight ? lHeight+1 : rHeight+1;
	}
	
	void connectNodes(CNode root) {
		Queue<CNode> nodes = new LinkedList<CNode>();
		nodes.add(root);
		nodes.add(null);
		while(!nodes.isEmpty()) {
			CNode n = nodes.peek();
			nodes.remove();
			
			if(n!=null) {
				n.right = nodes.peek();
				
				if(n.left!=null)
					nodes.add(n.left);
				if(n.right!=null)
					nodes.add(n.right);
			}else if(!nodes.isEmpty()) {
				nodes.add(null);
			}
			
		}
	}
	
	
	public static void main(String args[]) {
		ConnectNodesAtSameLevel tree = new ConnectNodesAtSameLevel();
		tree.root = new CNode(5);
		tree.root.left = new CNode(10);
		tree.root.right = new CNode(15);
		tree.root.left.left = new CNode(11);
		tree.root.left.right = new CNode(16);
		tree.root.right.left = new CNode(17);
		tree.root.right.right = new CNode(18);
		tree.root.left.left.left = new CNode(13);
		
		tree.connectNodes(tree.root);
		
		System.out.println(tree.root.left.left.right);
		
	}
}