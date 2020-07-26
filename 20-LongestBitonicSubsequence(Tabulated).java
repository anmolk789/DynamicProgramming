public class longestBitonicSS {
	
	public static void longestBitonicSubsequenceTab(int arr[]) {
		
		//Increasing Part
		
		int dp1[]=new int[arr.length];
		String printLInc[]=new String[arr.length];
		
		dp1[0]=1;
		printLInc[0]=arr[0]+"";
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<=i-1;j++) {
				if(arr[j]<arr[i]) {
					if(dp1[j]>dp1[i]) {
						dp1[i]=dp1[j];
						printLInc[i]=printLInc[j];
					}
				}
			}
			dp1[i] +=1;
			printLInc[i]=printLInc[i]+" "+arr[i];
		}
		
		//Decreasing Part
		
		int dp2[]=new int[arr.length];
		String printLDec[]=new String[arr.length];
		
		dp2[arr.length-1]=1;
		printLDec[arr.length-1]=arr[arr.length-1]+"";
		for(int i=arr.length-2;i>=0;i--) {
			for(int j=arr.length-1;j>=i+1;j--) {
				if(arr[j]<arr[i]) {
					if(dp2[j]>dp2[i]) {
						dp2[i]=dp2[j];
						printLDec[i]=printLDec[j];
					}
				}
			}
			dp2[i] +=1;
			printLDec[i]=arr[i]+" "+printLDec[i];
		}
		
		int omax=0; //The Value Without Removing the Redundancy
		int remRedun=0;
		String opath="";
		for(int i=0;i<arr.length;i++) {
			if(dp1[i]+dp2[i]> omax) {
				omax=dp1[i]+dp2[i];
				remRedun=dp1[i]+dp2[i]-1;
				opath=printLInc[i]+" "+printLDec[i];
			}
		}
		System.out.println(omax);
		System.out.println(remRedun);
		System.out.println(opath);
	}
	public static void main(String[] args) {
		//A Bitonic SS will be which has increasing and then decreasing type
		
		int arr[] = { 10, 22, 9, 33, 21,50, 41,60, 80, 1 };
		
		//Function Call
		longestBitonicSubsequenceTab(arr);
	}

}
