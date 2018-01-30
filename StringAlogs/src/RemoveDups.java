import java.util.Arrays;
import java.util.LinkedHashSet;

//remove duplicates from a string .

class RemoveDups{
	
	//METHOD-1
	static void removeDuplicates(String str) {
		char []strChars = str.toCharArray();
		Arrays.sort(strChars);
		System.out.println("Sorted: " + Arrays.toString(strChars));
		
		int i=1, cur=1;
		
		while(i < strChars.length) {
			if(strChars[i] != strChars[i-1]) {
				strChars[cur] = strChars[i];
				cur++;
			}
			i++;
		}
		str = new String(strChars);
		System.out.println("Unique characters : "+ str.substring(0,cur));
	}
	
	//Method 2
	static void removeDuplicates2(String str) {
		char []strChars = str.toCharArray();
		int i=0;
		LinkedHashSet<Character> lhs = new LinkedHashSet<Character>();
		
		while(i < strChars.length) {
			lhs.add(strChars[i]);
			i++;
		}
		
		System.out.println("Unique characters : "+ lhs);
	}
	
	public static void main(String args[]) {
		RemoveDups.removeDuplicates("Swalallaqwqw");
		RemoveDups.removeDuplicates2("Swalallaqwqw");
	}
	
}