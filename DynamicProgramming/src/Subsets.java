//Write a method to return all subsets of aset.

import java.util.ArrayList;
import java.util.Iterator;

class Subsets{
	
	ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
	
	void calculateAllSubsets(int input[]) {
		subsets.add(new ArrayList<>()); // empty subset
		int loopSize = 1;
		for(int i=0;i<input.length;i++) {
			int j = 0;
			while(j<loopSize) {
				ArrayList<Integer> curList = new ArrayList<Integer>();
				curList.addAll((ArrayList)subsets.get(j));
				curList.add(input[i]);
				subsets.add(curList);
				j++;
			}
			loopSize = subsets.size();
		}
	}
	
	void printSubsets() {
		Iterator iter = subsets.iterator();
		while(iter.hasNext()) {
			ArrayList<Integer> curList = (ArrayList<Integer>)iter.next();
			System.out.println(curList.toString());
		}
	}
	
	public static void main(String args[]) {
		int input[] = {1,2,3};
		Subsets sub = new Subsets();
		sub.calculateAllSubsets(input);
		sub.printSubsets();
	}
}