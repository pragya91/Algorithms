/* *Given an array arr[], find the maximum j – i such that arr[j] > arr[i]
 * Examples:
Input: {34, 8, 10, 3, 2, 80, 30, 33, 1} Output:6 (j=7,i=1)
Input: {9, 2, 3, 4, 5, 6, 7, 8, 18, 0} Output: 8 ( j = 8, i = 0)
Input: {1, 2, 3, 4, 5, 6} Output:5 (j=5,i=0)
Input: {6, 5, 4, 3, 2, 1}
Output: ­1
*/

class FindJMinusI{
	
	void findMaxDist(int [] arr) {
		
		int len = arr.length;
		int mins[] = new int[len];
		int maxs[] = new int[len];
		
		mins[0] = arr[0];
		for(int i=1;i<arr.length;i++) {
			mins[i] = Math.min(arr[i], mins[i-1]);
		}
		
		maxs[len-1] = arr[len-1];
		for(int j=len-2;j>=0;j--) {
			maxs[j] = Math.max(arr[j], maxs[j+1]);
		}
		
		int i=0,j=0;
		int maxDist = -1;
		
		while(i<len && j<len) {
			if(mins[i] < maxs[j]) {
				maxDist = j-i > maxDist ? j-i : maxDist;
				j++;
			}else
				i++;
				
		}
		System.out.println(maxDist);
	}
	
	
	public static void main(String args[]) {
		int arr[] = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
		FindJMinusI f = new FindJMinusI();
		f.findMaxDist(arr);
	}
}