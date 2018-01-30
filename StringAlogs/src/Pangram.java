import java.util.Arrays;

//Pangram = sentence or a phrase that contains all the alphabets.

class Pangram{
	
	static void isPangram(String str) {
		boolean[] alphabets = new boolean[26];
		Arrays.fill(alphabets, Boolean.FALSE);
		
		char[] strChars = str.toLowerCase().toCharArray();
		for(char c: strChars){
			alphabets[c%26] = true;
		}
		for(boolean b : alphabets) {
			if(b==false) {
				System.out.println("Not a pangram");
				return;
			}
		}
		System.out.println("Is a pangram");
			
	}
	
	public static void main(String args[]) {
		Pangram.isPangram("a  Quick broWn fox JumPs over the laZy Dog");
		Pangram.isPangram("a  quick dog");
	}
	
}