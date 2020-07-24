import java.util.*;
public class CoiChangePerm {
	public static void coinChangePermutationsTab(int denoms[],int amt) {
		//Base Case
		
		int dp[]=new int[amt+1];
		ArrayList<String> path[]=new ArrayList[amt+1];
		
		for(int i=0;i<path.length;i++) {
			path[i]=new ArrayList<>();
		}
		
		dp[0]=1; //One Way of Making Zero-Dont Give!!!
		path[0].add("");
		
		//Looping from 1 to Amount as the 0th Index Has Been Done
		for(int i=1;i<=amt;i++) {
			 //Checking with all the coin at the same index
			for(int j=0;j<denoms.length;j++) {
				if(i>=denoms[j]) {
					dp[i]=dp[i]+dp[i-denoms[j]];
					
					for(String rstr:path[i-denoms[j]]) {
						String addStr=rstr+denoms[j];
						path[i].add(addStr);
					}
				}
			}
		}
		System.out.println(dp[dp.length-1]);
		System.out.println(path[path.length-1]);
		
		
	}

	public static void main(String[] args) {
		//Print all the permutations from a coins array to make an amount,
		int arr[]= {2,3,5,6}; // CoinArray
		
		//Function Call
		coinChangePermutationsTab(arr, 10);
	}

}
