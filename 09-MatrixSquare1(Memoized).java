
public class squareMatrixOne {
	
	static int overmax=0;
	static int row=-1;
	static int col=-1;
	
	public static int maxSquareMatrixOneMemo(int matrix[][],int srcRow,int srcCol,int dp[][]) {
		//Declaring a matrix which will store the maximum size of square of 1
		//Base Case
		if(srcRow==matrix.length-1 || srcCol==matrix[0].length-1) {
			return matrix[srcRow][srcCol];
		}
		//Lookup
		if(dp[srcRow][srcCol]!=0) {
			return dp[srcRow][srcCol];
		}
		if(matrix[srcRow][srcCol]==0) {
			return 0;
		}
		//Recursion
		else {
		int hor=maxSquareMatrixOneMemo(matrix, srcRow, srcCol+1, dp);
		int ver=maxSquareMatrixOneMemo(matrix, srcRow+1, srcCol, dp);
		int diag=maxSquareMatrixOneMemo(matrix, srcRow+1, srcCol+1, dp);
				
		int max=1+Math.min(hor, Math.min(ver, diag));
		if(max>overmax) {
			overmax=max;
			row=srcRow;
			col=srcCol;
		}
		dp[srcRow][srcCol]=max;	
		//Return
		return max;
		}
	}

	public static void main(String[] args) {
		
		int matrix[][]= {
				{1,0,1,0,0,1},
				{1,0,1,1,1,1},
				{1,1,1,1,1,1},
				{1,1,1,1,0,0},
				{1,1,1,1,1,1},
				{0,0,0,0,1,0}
		};
		int value=maxSquareMatrixOneMemo(matrix, 0, 0, new int[matrix.length][matrix[0].length]);
		
		System.out.println(overmax+" @ ["+row+","+col+"]");
		
	}

}
