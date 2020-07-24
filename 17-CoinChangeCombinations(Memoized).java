import java.util.*;
public class coinChange {
	
	public static ArrayList<String> coinChangeCombinationsMemoized(int denoms[],int amt,ArrayList[][] dp,int lastPayment){
		// 2 Base Cases
		if(amt==0) {
			ArrayList<String> baseList=new ArrayList<>();
			baseList.add("");
			return baseList;
		}
		
		if(amt<0) {
			ArrayList<String> baseList=new ArrayList<>();
			//Dont Add Just Return
			return baseList;
		}
		
		//LookUp
		if(dp[amt][lastPayment]!=null) {
			return dp[amt][lastPayment];
		}
		
		ArrayList<String> mainResult=new ArrayList<>();
		
		for(int i=lastPayment;i<denoms.length;i++) {
			ArrayList<String> listFromRecursion=coinChangeCombinationsMemoized(denoms, amt-denoms[i],dp,i);

			for(String rstr:listFromRecursion) {
				String addToList=rstr+denoms[i]; //Add Then Denominations
				mainResult.add(addToList);
			}
		}
		dp[amt][lastPayment]=mainResult;
		return mainResult;
	}

	public static void main(String[] args) {
		//Print All The Combinations Through Which We Can Produce An Required Amount
		
		int coins[]= {2,3,5,6};
		
		//Function Call
		System.out.println(coinChangeCombinationsMemoized(coins, 20, new ArrayList[21][coins.length],0).size());
		System.out.println(coinChangeCombinationsMemoized(coins, 20, new ArrayList[21][coins.length],0));

	}

}
