import java.util.LinkedList;
import java.util.ListIterator;

/*Given a directed graph, design an algorithm to find out whether there is a route between two nodes. */

/*class GraphNode{
	int data;
}
*/
class Graph{
	LinkedList<Integer> graph [];
	
	Graph(int nodeCount){
		graph = new LinkedList[nodeCount];
		for(int i=0;i<nodeCount;i++) {
			graph[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int source , int dest) {
		graph[source].add(dest);
	}
	
	boolean isPath( int a, int b) {
		LinkedList<Integer> path = new LinkedList<Integer>(this.graph[a]);
		while(!path.isEmpty()) {
			Integer node = (Integer) path.getFirst();
			System.out.println("Cur: "+node);
			if(node == b) {
				return true;
			}else {
				for (int i = 0; i < graph[node].size(); i++) {
					Integer new_node = (Integer)graph[node].get(i);
					if(new_node != a) {
						path.addLast(new_node);	
					}
				}
				path.removeFirst();
			}
			printList(path);
			System.out.println();
		}
		return false;
	}
	
	void printList(LinkedList lol) {
		ListIterator<Integer> list = lol.listIterator();
		while (list.hasNext()) {
			System.out.println(list.next());
		}
	}
	
	public static void main(String args[]) {
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(0, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 0);
		boolean isPath = graph.isPath( 3,2);
		System.out.print("Is there a path : "+isPath);
		
	}
}

