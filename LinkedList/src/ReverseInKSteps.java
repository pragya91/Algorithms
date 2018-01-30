class ReverseInKSteps{
	
	void printLinkedList(ListNode<Integer> node) {
		if(node==null) 
			return;
		while(node!=null) {
			System.out.print(node.value + "\t");
			node = node.next;
		}
		System.out.println();
	}
	
	void reverseNodesInKGroups(ListNode<Integer> node, int k) {
		//------------_TODO-----------
	}
	
	
	public static void main(String[] args) {
		ListNode<Integer> n1 = new ListNode<Integer>(1);
		n1.next = new ListNode<Integer>(2);
		n1.next.next = new ListNode<Integer>(3);
		n1.next.next.next = new ListNode<Integer>(4);
		n1.next.next.next.next = new ListNode<Integer>(5);
		n1.next.next.next.next.next = new ListNode<Integer>(6);
		n1.next.next.next.next.next.next = new ListNode<Integer>(7);
		n1.next.next.next.next.next.next.next = new ListNode<Integer>(8);
		
		ReverseInKSteps rk = new ReverseInKSteps();
		rk.reverseNodesInKGroups(n1,3);
	}
}