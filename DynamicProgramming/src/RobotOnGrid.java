/*Imagine a robot sitting on the upper left corner of an X by Y grid. The robot can only move in two directions: right and down. How many possible paths are there 
 * for the robot to go from (0,0) to (X,Y)?
FOLLOW UP
Imagine certain spots are "off limits," such that the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to the bottom right.*/


class RobotOnGrid{
	
	static final int X = 20;
	static final int Y = 20;
	
	int grid [][] = new int[X][Y];
	int obstructionGrid [][] = new int[X][Y];
	
	RobotOnGrid() {
		obstructionGrid[1][1] = -1;
		obstructionGrid[0][1] = -1;
		obstructionGrid[2][2] = -1;
		obstructionGrid[4][4] = -1;
		obstructionGrid[3][3] = -1;
		obstructionGrid[3][0] = -1;
	}
	
	int freePathCount(int x, int y) {
		if(x>=1 && y >=1) {
			if(grid[x][y] != 0) {
				return grid[x][y];
			}else {
				grid[x][y] = freePathCount(x-1,y) + freePathCount(x,y-1);	
				return grid[x][y];
			}
		}else if((x==0 && y >= 0) || (x>=0 && y==0)) {
			grid[x][y] = 1;
			return grid[x][y];
		}else {
			return 0;
		}
	}
	
	int obstructionPathCount(int x, int y) {
		if(x<0 || y<0 || obstructionGrid[x][y] == -1) {
			return 0;
		}
		else {
			obstructionGrid[0][0] = obstructionGrid[0][0] == -1 ? -1 : 1;
			for(int i=1;i<Y;i++) {
				if(obstructionGrid[0][i] != -1) {	
					obstructionGrid[0][i] = obstructionGrid[0][i-1] == 1 ? 1 : 0;
				}
				
			}
			for(int i=1;i<X;i++) {
				if(obstructionGrid[i][0] != -1) {
					obstructionGrid[i][0] = obstructionGrid[i-1][0] == 1 ? 1 : 0;
				}
			}
			for(int i=1;i<X;i++) {
				for(int j=1;j<Y;j++) {
					if(obstructionGrid[i][j] != -1) {
						obstructionGrid[i][j] = (obstructionGrid[i][j-1] == -1 ? 0 : obstructionGrid[i][j-1]) + (obstructionGrid[i-1][j] == -1 ? 0 : obstructionGrid[i-1][j]) ;	
						System.out.println(i + ", " + j + " -->" + obstructionGrid[i][j] );
					}
					
				}
			}
		}
		
		
		return obstructionGrid[x][y];
	}
	
	void printGrid(int [][] printGrid, int x, int y) {
		System.out.println();
		for(int i=0;i<=x;i++) {
			for(int j=0;j<=y;j++) {
				System.out.print(printGrid[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String args[]) {
		int x = 2;
		int y = 2;
		RobotOnGrid rog = new RobotOnGrid();
		int paths = rog.freePathCount(x,y);
		
		System.out.print("Total no. of ways to movw from 00 to XY is: "+ paths);
		rog.printGrid(rog.grid,x,y);
		
		paths = rog.obstructionPathCount(1, 2);
		
		System.out.print("Total no. of ways with obstruction from 00 to XY is: "+ paths);
		rog.printGrid(rog.obstructionGrid, 6, 6);
		
	}
	
	
}