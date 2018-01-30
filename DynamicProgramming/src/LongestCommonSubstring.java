/*
 * SHINCHAN
 * NOHARA
 * gives --- HA
 * */

class LongestCommonSubstring{
	
	char[] s1= ("shinchan").toCharArray();
	char[] s2=("nohara").toCharArray();
	
	int matrix[][] = new int[s1.length+1][s2.length+1];
	
	void findLCS() {
		matrix[0][0]=0;
		int max=0;
		int pos_i=-1,pos_j=-1;
		for(int i=0;i<s1.length;i++) {
			for(int j=0;j<s2.length;j++) {
				if(s1[i]==s2[j]) {
					matrix[i+1][j+1]=matrix[i][j]+1;
					if(matrix[i+1][j+1] > max) {
						max=matrix[i+1][j+1];
						pos_i=i;
						pos_j=j;
					}
				}else {
					matrix[i+1][j+1]=0;
				}
			}
		}
		System.out.println("Size: "+max);
		
		String str = "";
		while(max!=0) {
			str=s2[pos_j]+str;
			pos_j--;
			max--;
		}
		
		System.out.println("String: "+str);
	}
	
	public static void main(String args[]) {
	
		LongestCommonSubstring l = new LongestCommonSubstring();
		l.findLCS();
	}
}