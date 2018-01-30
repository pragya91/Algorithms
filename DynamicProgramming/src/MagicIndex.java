/* 
 * AmagicindexinanarrayA[0...n-1]isdefinedtobeanindexsuchthat A[i] = i. Given a sorted array of distinct integers, 
 * write a method to find a magic index, if one exists, in arrayA.
 * FOLLOW UP
 * What if the values are not distinct? */


class MagicIndex{
	
	int findMagicIndex(int[] input, int beg, int end) {
		
		if(beg == end ) {
			return input[end] == end ? end : -1;
		}
		int cur = (end-beg /2) + beg;
		if(input[cur] > cur) {
			return findMagicIndex(input,  beg, cur-1);
		}else if(input[cur] == cur) {
			return cur;
		}else if(input[cur] < cur) {
			return findMagicIndex(input,  cur+1, end);
		}
		return -1;
	}
	
	
	
	public static void main(String args[]){
		int input[] = {-1,3,3,3,3,7};
		
		MagicIndex mi = new MagicIndex();
		int index = mi.findMagicIndex(input, 0, input.length-1);
		System.out.println("index: " + index);
		
	}
}


