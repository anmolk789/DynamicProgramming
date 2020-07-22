
public class RodCuttingMemo {
	public static int rodCutting(int arr[],int rodLength,int dp[]) {
		//Base Case
		if(rodLength==0) {
			return 0;
		}
		
		//LookUp
		if(dp[rodLength]!=0) {
			  return dp[rodLength];
		}
		//Recursive Approach
		int maximumPrice=arr[rodLength];
		int left=1;
		int right=rodLength-1;
		while(left<=right) {
			int maximumPriceLeft = rodCutting(arr, left,dp);
			int maximumPriceRight = rodCutting(arr, right,dp);
			if (maximumPriceLeft + maximumPriceRight > maximumPrice) {
				maximumPrice = maximumPriceLeft + maximumPriceRight;
			}
			left++;
			right--;
		}
		dp[rodLength]=maximumPrice;
		return maximumPrice;
	}

	public static void main(String[] args) {
		// A Rod of Length 8 has to be maximized in terms of Cuts of Price
		int arr[] = { 0, 3, 5, 6, 15, 10, 25, 12, 24 };

		// Function Call
		System.out.println(rodCutting(arr, 8,new int[arr.length]));
	}

}
