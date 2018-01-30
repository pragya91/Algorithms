import java.util.ArrayList;

//Write a method to compute all permutations of a string

class Permutations{
	
	ArrayList<String> calculatePermutations(String input) {
		ArrayList<String> perms= new ArrayList<String>();
		perms.add("");
		int len = input.length();
		for(int i=0;i<len;i++) {
			char curChar = input.charAt(i);
			int permCount = perms.size();
			for(int j=0;j<permCount;j++) {
				int permStrLen = perms.get(j).length();
				for(int k=0;k<=permStrLen;k++) {
					String s = insertCharAt(perms.get(j),curChar,k);
					perms.add(s);
				}
			}
		}
		return perms;
	}
	
	String insertCharAt(String str, char cur, int pos) {
		if(pos ==0) {
			return cur+str;
		}else if(pos < str.length()-1){
			String beg = str.substring(0,pos);
			String end = str.substring(pos+1,str.length());
			return (beg + cur + end);
			
		}else {
			return (str + cur);
		}
	}
	
	void printPermutations(ArrayList<String> list) {
		System.out.println("The permutations are: "+list.toString());
	}
	
	//--------------------SOLUTION FROM BOOK----------------------
	
	public static ArrayList<String> getPerms(String str) { 
		if (str==null){
			return null;
		}
		ArrayList<String> permutations = new ArrayList<String>(); 
		if (str.length() == 0) { // base case
			permutations.add("");
			return permutations;
		}
		
		char first = str.charAt(0); // get the first character
		String remainder = str.substring(1); // remove the 1st character 
		ArrayList<String> words = getPerms(remainder);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				String s = insertCharAt_2(word, first, j); 
				permutations.add(s);
			}
		}
		return permutations;
	}
	public static String insertCharAt_2(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i); 
		return start + c + end;
	}
	
		
	
	public static void main(String args[]) {
	 String input = "CUPGAME";
	 Permutations perm = new Permutations();
	  ArrayList<String> perms = perm.calculatePermutations(input);
	  perm.printPermutations(perms);
	  
	  
	  ArrayList<String> bookPerms = perm.getPerms(input);
	  perm.printPermutations(bookPerms);
	}
}