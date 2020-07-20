
public class GoldMine2 {
	static int overMax=0;
	public static int goldMineMemoized(int goldmine[][],int srcRow,int srcCol,int dp[][]) {
		
		//Base Case
		if(srcCol==goldmine[0].length-1) {
			return goldmine[srcRow][srcCol];
		}
		//LookUp
		if(dp[srcRow][srcCol]!=0) {
			return dp[srcRow][srcCol];
		}
		//Initialization of Values
		int maxValue=0;
		int firstRowValue=Integer.MIN_VALUE;
		int midRowValue=Integer.MIN_VALUE;
		int lastRowValue=Integer.MIN_VALUE;
		
		//Recursion
		//Case when row>0
		if(srcRow>0) {
			firstRowValue=goldMineMemoized(goldmine, srcRow-1, srcCol+1,dp);
		}
		
		//Case when row is in middle
		 midRowValue=goldMineMemoized(goldmine, srcRow, srcCol+1,dp);
		
		//Case when row< length-1
		if(srcRow<goldmine.length-1) {
			lastRowValue=goldMineMemoized(goldmine, srcRow+1, srcCol+1,dp);
		}
		
		//Finding the Maximum of these three
		maxValue=goldmine[srcRow][srcCol]+Math.max(firstRowValue, Math.max(midRowValue, lastRowValue));
		
		//Storing in the DPArray
		dp[srcRow][srcCol]=maxValue;
		
		return maxValue;
	}

	public static void main(String[] args) {
	//Memoizing the answers because there are overlapping sub-problems
		int goldmine[][]= {
				{2,0,8,4},
				{5,6,7,8},
				{1,2,3,4},
				{0,1,0,1}
		};
		int dp[][]=new int[goldmine.length][goldmine[0].length];
		//We need to run it for every row of the first column
		for(int r=0;r<goldmine.length;r++) {
			int rMax=goldMineMemoized(goldmine, r, 0,dp);
			if(rMax>overMax) {
				overMax=rMax;
			}
		}
		System.out.println(overMax);
		
		for(int i=0;i<goldmine.length;i++) {
			for(int j=0;j<goldmine[0].length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		
	
	}

}
