public class boardPaths {
	public static int countBoardPaths(int n) {
		//We have a dice of 6 Sides,So an Array of Size 6 is required to slide
		//Lets take an example of n=10
		//Array 0 will have a value of 1
		//Array 1,2,3,4,5 will be looking to 11,12,13,14,15
		
		//No of slides= No itself
		
		int slider[]=new int[6];
		slider[0]=1;
		for(int i=1;i<=n;i++) {
			int newValue=slider[0]+slider[1]+slider[2]+slider[3]+slider[4]+slider[5];
			slider[5]=slider[4];
			slider[4]=slider[3];
			slider[3]=slider[2];
			slider[2]=slider[1];
			slider[1]=slider[0];
			slider[0]=newValue;
		}
		return slider[0];
	}
	public static void main(String[] args) {
		//With the space complexity of just O(n)
		//Slider Method is even more better
		//We are looking for all the ways from 0 to N
		System.out.println(countBoardPaths(10));
	}

}
