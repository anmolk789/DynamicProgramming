
public class MazePaths {
	public static int countMazePaths(int srcRow,int srcCol,int destRow,int destCol,int [][] dp) {
		//Base Case
		if(srcRow==destRow && srcCol==destCol) { //We are standing at the destination so 1 way.
			return 1;
		}
		
		if(srcRow>destRow || srcCol>destCol) { // We have moved outside the 2-D so 0 way.
			return 0;
		}
		
		//LookUp
		if(dp[srcRow][srcCol]!=0) {
			return dp[srcRow][srcCol];
		}
		
		//Recursion
		//Horizontal Call
		int countHorizontal=countMazePaths(srcRow, srcCol+1, destRow, destCol, dp);
		
		//Vertical Call
		int countVertical=countMazePaths(srcRow+1, srcCol, destRow, destCol, dp);
		
		//Total=H+V
		int total=countHorizontal+countVertical;
		
		dp[srcRow][srcCol]=total;
		return dp[srcRow][srcCol];
		
	}

	public static void main(String[] args) {
	//Given a source index and destination index in a 2-D Array
	//Find out all the paths from Source to Destination
		int n=15;
		long start=System.currentTimeMillis();
		System.out.println(countMazePaths(0, 0, n, n, new int[n+1][n+1]));
		long end=System.currentTimeMillis();
		System.out.println(end-start);
	}
	

}
