/* longest substring that can be replaced in the given string to make it stable.
 * Stable gene is a string which has length N and occurance of Characters G,C,A,T as N/4 each
 * GAAATAAA
 * Ans = 5
 */

import java.util.Arrays;
import java.util.HashMap;
class StableGene{
	
	char[] s = "GGAAGCCA".toCharArray();
	HashMap<Character,Integer> freq;
	int expected = s.length/4;
	
	StableGene(){
		freq = new HashMap<Character,Integer>();
		freq.put('G',0);
		freq.put('A',0);
		freq.put('C',0);
		freq.put('T',0);
	}
	
	boolean isBalanced() {
		if(freq.get('G') <= expected && freq.get('C') <= expected && freq.get('A') <= expected && freq.get('T') <= expected )
			return true;
		else
			return false;
	}
	
	void calculateReplacement() {
		
		for(int i=0;i<s.length;i++) {
			freq.put(s[i],freq.get(s[i])+1);
			
		}

		int start=0;
		int end=0; 
		int minLen=Integer.MAX_VALUE;int final_start=0,final_end=0;
		while(start<=end && end<s.length) {
			if(!isBalanced()) {
				freq.put(s[end],freq.get(s[end])-1);
				end++;
			}else {
				freq.put(s[start],freq.get(s[start])+1);
				start++;
				if(isBalanced()) {
					minLen = Math.min(minLen, end-start);
					final_start=start;
					final_end = end;
				}
			}
		}
		char[] substr = Arrays.copyOfRange(s, final_start, final_end);
		System.out.println("Length: " + minLen);
        System.out.println(substr);
		

	}
	
	public static void main(String argsp[]) {
		StableGene gene = new StableGene();
		gene.calculateReplacement();
	}
}