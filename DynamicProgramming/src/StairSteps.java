/*A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time. Implement a method 
 * to count how many possible ways the child can run up the stairs.*/
 
class StairSteps{
	
	int[] table = new int[50]; //MAX 50 STAIRS
	
	StairSteps() {
		table[0]=0;
		table[1]=1;
		table[2]=2;
		table[3]=4;
	}
	int fibonacci3(int n) {
		if(n<=2) {
			return n;
		}
		else if(n==3) {
			return 4;
		}
		else {
			if(table[n]!=0) {
				return table[n];
			}else {
				return (fibonacci3(n-1) + fibonacci3(n-2) + fibonacci3(n-3));	
			}
			
 		}
	}
	
	
	int calculateWays(int n) {
		return fibonacci3(n);
	}
	
	public static void main(String args[]) {
		StairSteps s = new StairSteps();
		int ways = s.calculateWays(5);
		
		System.out.print("No. of ways: " + ways);
	}
}
 
 