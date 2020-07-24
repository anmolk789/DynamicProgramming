import java.util.*;
public class CoinChangePerm {
	public static ArrayList<String> coinChangePermutationsMem(int denoms[],int amt,ArrayList[] dp){
		//Base Case
		//1st Case when Amount is Zero
		
		if(amt==0) {
			ArrayList<String> baseResult=new ArrayList<>();
			baseResult.add("");
			return baseResult;
		}
		
		//2nd Base when Amount goes below less than 0
		
		if(amt<0) {
			ArrayList<String> baseResult=new ArrayList<>();
			return baseResult;
			}
		
		
		//LookUp
		if(dp[amt]!= null) {
			return dp[amt];
		}
		
		//Intialization of Main AraryList which we will return
		ArrayList<String> mainResult=new ArrayList<>();
		
		for(int i=0;i<denoms.length;i++) {
			ArrayList<String> resultFromRecursion=coinChangePermutationsMem(denoms, amt-denoms[i],dp);
			
			for(String rstr:resultFromRecursion) {
				String addResult=rstr+denoms[i];
				mainResult.add(addResult);
			}
		}
		
		dp[amt]=mainResult;
		return mainResult;
	}

	public static void main(String[] args) {
		//Printing all the Permutations of the coins by which we can make a required amount
						// Using Memoization
		int arr[]= {2,3,5,6};
		
		//Function Call
		System.out.println(coinChangePermutationsMem(arr, 10, new ArrayList[11]));
	}

}
