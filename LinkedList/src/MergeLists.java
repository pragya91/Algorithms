class MergeLists{
	ListNode<Integer> mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2) {
		if(l1==null) return l2;
	    if(l2==null) return l1;
	    if(l1.value<l2.value) {
	        l1.next = mergeTwoLists(l1.next,l2);
	        return l1;
	    }
	    else {
	        l2.next = mergeTwoLists(l1,l2.next);
	        return l2;
	    }
	}
	void printLinkedList(ListNode<Integer> node) {
		if(node==null) 
			return;
		while(node!=null) {
			System.out.print(node.value + "\t");
			node = node.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		ListNode<Integer> n1 = new ListNode<Integer>(1);
		n1.next = new ListNode<Integer>(2);
		n1.next.next = new ListNode<Integer>(3);
		n1.next.next.next = new ListNode<Integer>(4);
		
		ListNode<Integer> n2 = new ListNode<Integer>(0);
		n2.next = new ListNode<Integer>(0);
		n2.next.next = new ListNode<Integer>(0);
		n2.next.next.next = new ListNode<Integer>(2);
		
		MergeLists ml = new MergeLists();
		ml.printLinkedList(ml.mergeTwoLists(n1,n2));
	}
}