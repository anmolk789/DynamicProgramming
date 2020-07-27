
public class MinimumPalindromicCut {
	
	//We have 2 Variables to consider.SO Memoization will be 2-D Array
	
	public static int minimumPalindromeCutMemoized(String str,int StartIndex,int EndIndex,int dp[][]) {
		//Base Index
		if(isPalindrome(str,StartIndex,EndIndex)==true) {
			return 0;
		}
		
		//LookUp
		if(dp[StartIndex][EndIndex]!=0) {
			return dp[StartIndex][EndIndex];
		}
		
		int globalMax=Integer.MAX_VALUE;
		
		//Recursion Call
		//First Cut Will Be After The 0th Index and The Rest Will Be There 
		for(int cut=StartIndex;cut<EndIndex;cut++) {
			int minCutLeft=minimumPalindromeCutMemoized(str, StartIndex,cut,dp);
			int minCutRight=minimumPalindromeCutMemoized(str, cut+1, EndIndex,dp);
			
			int addPlus1= minCutLeft+minCutRight+1; //Adding 1 Because we have first cut done already
			
			//Finding the Minimum Out of this Recursion Call
			
			if(addPlus1<globalMax) {
				globalMax=addPlus1;
			}
		}
		//Storing
		dp[StartIndex][EndIndex]=globalMax;
		return globalMax;
	}

	private static boolean isPalindrome(String str, int startIndex, int endIndex) {
		int left=startIndex;
		int right=endIndex;
		while(left<right) {
			if(str.charAt(left)!=str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) {
		//Given a String Find Out The Minimum Number Of Cuts So That A Every Cut Gives A Palindrome
		//A Single Character is a Palindrome
		
		String str="abccbc";
		System.out.println(minimumPalindromeCutMemoized(str,0,str.length()-1,new int[str.length()][str.length()]));
	}

}
