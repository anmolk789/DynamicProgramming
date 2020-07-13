
public class fibSlider {
	public static int fibSlide(int n) {
		int slider[]=new int[2];
		
		slider[0]=0;
		slider[1]=1;
		for(int slide=1;slide<=n;slide++) {
			int ans=slider[0]+slider[1];
			slider[0]=slider[1];
			slider[1]=ans;
		}
		return slider[0];
	}

	public static void main(String[] args) {
		//Calculating fibonacci through Sliding Method.
		//Constantly Changing the Values as we calculate the value of each fibonacci
		//No of Slides=No
		//Printing Slider[0] 
		
		int n=43;
		System.out.println(fibSlide(n));
	}

}
