public class PalindromeSS {
	public static int countPalindromicSubStrings(String str) {
		//Initialize a 2-Boolean Array with length size
		boolean storage[][]=new boolean [str.length()][str.length()];
		
		//Counter Variable
		int counter=0;
		
		//Lets start with first diagonal which will be true as 00,11,22,33 will be donoting a single letter and is a palindrome
		for(int diag=0;diag<str.length();diag++) {
			int start=0;
			int end=start+diag;
			while(end<str.length()) {
				if(diag==0) {
					storage[start][end]=true;
				}
				else if(diag==1) {
					//Comparing first and second value
					if(str.charAt(start)==str.charAt(end)) {
						storage[start][end]=true;
					}
					
				}else {
					//Comparing first and second value and middle value through previous stored results
					if(str.charAt(start)==str.charAt(end) && storage[start+1][end-1]==true) {
						storage[start][end]=true;
					}
				}
				
			if(storage[start][end]==true) {
				counter++;
			}
				start++;
				end++;
			}
		}
		return counter;
	}

	public static void main(String[] args) {
		//Given a string find out all the substrings which are palindromic
		//A String Substrings are lengthOfString * (lengthOfString+1) /2
		//All single letters are Palidrome
		//One SS is Palindrome if the starting element and ending element is same.,also the the string
		//(contd.) with start+1 and end-1 should be a palindrome
		
		String tobePassed="abccbc";
		System.out.println(countPalindromicSubStrings(tobePassed));
	}

}
