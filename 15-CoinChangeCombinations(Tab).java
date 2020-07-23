import java.util.*;
public class CoinChangeTab {
	public static void coinChangeCombinationsTabulated(int denoms[],int amt) {
		int dp[]=new int [amt+1];
		
		ArrayList<String> path[]=new ArrayList[amt+1];
		
		for(int i=0;i<path.length;i++) {
			path[i]=new ArrayList<>();
		}
		//For 0 there is one way -Dont Give It.
		dp[0]=1;
		path[0].add("");
		
		//Traversing through the every element of the denoms array
		for (int i = 0; i < denoms.length; i++) {
			for (int j = denoms[i]; j <= amt; j++) { // If 2 Start from to Amount 
				dp[j] = dp[j] + dp[j - denoms[i]];
				
				for (String rstr : path[j - denoms[i]]) {
					String addStr = rstr + denoms[i];
					path[j].add(addStr);
				}
			}
		}
		System.out.println(dp[dp.length-1]);
		System.out.println(path[path.length-1]);
	}

	public static void main(String[] args) {
		//An Array of Denominations and Amount is Given
		//Print No of Combinations We Can Make Through That Denominations Array 
		
		int arr[]= {2,3,5,6};
		coinChangeCombinationsTabulated(arr, 10);

	}

}
