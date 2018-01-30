import java.util.Arrays;

//reverse a string without affecting the special characters

public class ReverseSpecial{
	
    void reverseSpl(String str) {
		if(str == null) {
		 System.out.print("Empty");
		 return;
		}
		if(str.length() < 2) {
			System.out.print(str);
			return;
		}
		char[] strChars = str.toCharArray(); 
		System.out.println("Original: " + (Arrays.toString(strChars)));
		int left = 0, right = str.length()-1;
		
		while(left < right) {
			
			if(!isAlphabet(strChars[left])) {
				left++;
			}
			else if(!isAlphabet(strChars[right])){
				right--;
			}else {
				char temp = strChars[left];
				strChars[left] = strChars[right];
				strChars[right] = temp;
				left++;right--;
			}
			
		}
		System.out.println("Reversed : " + (Arrays.toString(strChars)));
	}
	
	private boolean isAlphabet(char charAt) {
		if((charAt >= 'A' && charAt <= 'Z' ) || (charAt >= 'a' && charAt <= 'z' )) {
			return true;
		}
		return false;
	}

	public static void main(String args[]) {
		ReverseSpecial sr = new ReverseSpecial();
		sr.reverseSpl("hakuna,ma:ta'ta");
		
		sr.reverseSpl("!@#$%^&");
	}
	
}