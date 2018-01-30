class ListNode<T>{
	T value;
	ListNode<T> next;
	
	ListNode(T val){
		value = val;
	}
}

public class TwoHugeNumber{
	
	ListNode<Integer> reverse(ListNode<Integer> node){
	    ListNode<Integer> prev = null;
	    ListNode<Integer> current = node;
	    ListNode<Integer> next = null;
	    while (current != null) {
	        next = current.next;
	        current.next = prev;
	        prev = current;
	        current = next;
	    }
	    node = prev;
	    return node;
	}
	
	ListNode<Integer> copyRestOfTheList(ListNode<Integer> dest, ListNode<Integer> src, int carry){
		
		while(src!=null) {
			int newVal = src.value + carry;
    			String str = String.valueOf(newVal);
    			if(str.length() > 4) {
    				newVal = newVal%10000;
    				carry=1;
    			}else {
    				carry=0;
    			}
    			dest.next = new ListNode<Integer>(newVal);
			src = src.next;
			dest = dest.next;
		}
		System.out.println();
		return dest;
	}
	
	ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
	    a = reverse(a);
	    b = reverse(b);
	    printLinkedList(a);
	    printLinkedList(b);
	   
	    int carry=0;
	    ListNode<Integer> c=null,cHead=null;
	    
	    while(a != null && b != null) {
	    		int newVal = a.value + b.value + carry;
	    		String str = String.valueOf(newVal);
	    		if(str.length() > 4) {
		    		newVal = newVal%10000;
		    		carry = 1;
		    }else {
		    		carry=0;
		    }
	    		if(c==null) {
	    			c = new ListNode<Integer>(newVal);
	    			cHead = c;
	    		}
	    		else {
	    			c.next = new ListNode<Integer>(newVal);
	    			c=c.next;
	    		}
	    		a=a.next;
	    		b=b.next;
	    }
	    if(a==null && b!=null) {
	    		c = copyRestOfTheList(c,b,carry);
	    }else if(b==null && a!=null) {
	    		c = copyRestOfTheList(c,a,carry);
	    }else {
	    		if(carry!=0) {
	    			c.next = new ListNode<Integer>(carry);
	    		}
	    }
	    cHead = reverse(cHead);
	    return cHead;
	}
	
	void printLinkedList(ListNode<Integer> node) {
		if(node==null) {
			return;
		}
		while(node!=null) {
			System.out.print(node.value + "\t");
			node = node.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ListNode<Integer> n1 = new ListNode<Integer>(1);
		/*n1.next = new ListNode<Integer>(8);
		n1.next.next = new ListNode<Integer>(7);
		n1.next.next.next = new ListNode<Integer>(6);*/
		
		ListNode<Integer> n2 = new ListNode<Integer>(9998);
		n2.next = new ListNode<Integer>(9999);
		n2.next.next = new ListNode<Integer>(9999);
		n2.next.next.next = new ListNode<Integer>(9999);
		
		TwoHugeNumber thn = new TwoHugeNumber();
		thn.printLinkedList(thn.addTwoHugeNumbers(n1, n2));
		
	}
}