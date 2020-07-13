
public class Fibonacci {
	//Lets Do This!!!
	public static int fibonacci(int n,int dp[]) {
		//Base Case for Fibonacci
		if(n==0 || n==1) {
			return n;
		}
		
		//LookUp
		if(dp[n]!=0) {
			return dp[n];
		}
		
		//Recursion
		int ans=fibonacci(n-1, dp)+fibonacci(n-2, dp);
		dp[n]=ans;
		return dp[n];
	}

	public static void main(String[] args) {
		
		//To return a fibonnaci term of lets say 10 it takes 2^10 operations i.e 1024 which makes the time complexity huge.
		 
		//To reduce this we need to memoize the answer and store the answer in an array.(Overlapping Subproblems)
		
		int n=40;
		long start=System.currentTimeMillis();
		System.out.println(fibonacci(n, new int[n+1]));
		long end=System.currentTimeMillis();
		System.out.println(end-start);
	}

}
