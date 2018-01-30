/*
 * SHINCHAN
 * NOHARAA
 * gives ---NHA
 * */

class LongestCommonSubsequence{
	
	char[] s1= ("qawsed").toCharArray();
	char[] s2=("zaqxswcde").toCharArray();
	
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
					matrix[i+1][j+1]= Math.max(matrix[i][j+1], matrix[i+1][j]);
				}
			}
		}
		System.out.println("Size: "+max);
		String str = "";
		while(max!=0) {
			if(matrix[pos_i+1][pos_j+1] == matrix[pos_i][pos_j+1]) {
				pos_i--;
			}else if(matrix[pos_i+1][pos_j+1] == matrix[pos_i+1][pos_j]) {
				pos_j--;
			}else {
				str=s2[pos_j]+str;
				pos_j--;
				pos_i--;
				max--;
			}
			
		}
		
		System.out.println("String: "+str);
	}
	
	public static void main(String args[]) {
	
		LongestCommonSubsequence l = new LongestCommonSubsequence();
		l.findLCS();
	}
}