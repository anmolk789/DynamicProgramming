
public class longestIncSubsequence {
	// 2 Functions
	public static void longestIncreasingSubsequenceMemoizedENTRYPOINT(int arr[]) {
		int overmax=0;
		
		int dp[]=new int[arr.length];
		for(int i=1;i<arr.length;i++) {
			int values=longestIncreasingSubsequencesMemoizedAtPoint(arr,i, dp);
			if(values>overmax) {
				overmax=values;
			}
		}
		
		System.out.println(overmax);
		
		
	}

	public static int longestIncreasingSubsequencesMemoizedAtPoint(int arr[],int point,int dp[]) {
		//Base Case
		if(point==0) {
			return 1;
		}
		
		//LookUp
		if(dp[point]!=0) {
			return dp[point];
		}
		
		int counter=0;
		//Recursion
		for(int i=0;i<point;i++) {
			if(arr[i]<arr[point]) {
			int longestSSAtPointati=longestIncreasingSubsequencesMemoizedAtPoint(arr,i,dp);
			if(longestSSAtPointati>counter) {
				counter=longestSSAtPointati;
				}
			}
		}
		
		counter += 1; //Because We have Found the values less than any value and adding 1 to it
		dp[point]=counter;
		return counter;
	}

	public static void main(String[] args) {
		// An Array with random numbers return the longest increasing subsequence(return
		// a number)

		int arr[] = { 10, 22, 9, 33, 21,50, 41,60, 80, 1 };

		// Function Call
		longestIncreasingSubsequenceMemoizedENTRYPOINT(arr);
	}

}
