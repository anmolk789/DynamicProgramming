
public class countPaths {
	//Lets Code This
	public static int countPathsTabulated(int src,int dest,int dp[]) {
		dp[dest]=1;
		//Loop
		for(int inter=dest-1;inter>=src;inter--) {
			for(int dice=1;dice<=6;dice++) {
				if(inter+dice<=dest) {
					dp[inter] +=dp[inter+dice];
				}
		}
	}
		return dp[src];
	}

	public static void main(String[] args) {
		//Given a source and destination and a dice we need to print no of combinations leading upto that destination.
		//A Dice has 6 numbers,so a loop will run 6 times.
		//Eg.-For Reaching 10 to 10 we have one option as 11,12,13,14,15 are all invalid(we need to find for 0 to 10)
		//For 9 to 10 we also have one way.
		//For 8 to 10 we have 2 way as 8-9-10 and 8-10.( Sum of 9 and 10)
		
		
		System.out.println(countPathsTabulated(1, 10, new int[10+1]));
	}

}
