//reversing a string - recursion.

class Reverse{
	
	static void reverseRecusively(String str) {
		if(str== null) {
			return;
		}
		if(str.length()<2) {
			System.out.print(str);
			return;
		}
		System.out.print(str.charAt(str.length()-1));
		reverseRecusively(str.substring(0, str.length()-1));
	}
	
	public static void main(String args[]) {
		Reverse.reverseRecusively("Swalalla");
	}
	
}