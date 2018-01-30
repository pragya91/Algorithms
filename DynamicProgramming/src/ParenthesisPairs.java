import java.util.ArrayList;

class ParanthesisPairs{
	String pair = "()";
	String left = "(";
	String right = ")";
	
	ArrayList<String> findValidCombinations(int count){
		if(count == 0) {
			return null;
		}
		ArrayList<String> validCombis = new ArrayList<String>();
		if(count == 1) {
			validCombis.add("()");
			return validCombis;
		}else {
			ArrayList<String> prevCcombis = findValidCombinations(count-1);
			for(String combination : prevCcombis) {
				String s = "(" + combination + ")";
				validCombis.add(s);
				
				
				for(int i=0;i<combination.length();i++) {
					//String s = insertAPair();
				}
				
			}
		}
		return validCombis;
		
	}
	
	public static void main(String args[]) {
		ParanthesisPairs p = new ParanthesisPairs();
	}
	
	
}