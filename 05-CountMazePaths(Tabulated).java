
public class MazePath1 {
	public static int countMazePathsTabulated(int srcRow,int srcCol,int destRow,int destCol) {
		int dp[][]=new int[destRow+1][destCol+1];
		for(int i=0;i<=destCol;i++) {
			dp[0][i]=1;
		}
		for(int j=0;j<=destRow;j++) {
			dp[j][0]=1;
		}
		for(int i=1;i<=destCol;i++) {
			for(int j=1;j<=destRow;j++) {
				dp[i][j]=dp[i-1][j]+dp[i][j-1];
			}
		}
		
		return dp[destRow][destCol];
		
	}

	public static void main(String[] args) {
		//Tabulated Form of Maze Paths
		//Addition of Board Paths of i-1 and j-1 path
		System.out.println(countMazePathsTabulated(0, 0, 3, 3));
	}

}
