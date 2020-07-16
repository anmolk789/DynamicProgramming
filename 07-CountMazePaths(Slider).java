
public class MazePathsSlider {
	
	//Given a 2D Array with DestRow and DestCol
	//Find No of Ways from [0,0] to [DestRow-1,DestCol-1]
	
	public static int countMazePathsSlider(int destRow,int destCol) {
		//Declaring a SliderArray of Size of Last Row
		
		int slider[]=new int[destRow];
		
		//slider[destRow-1] will always have 1
		
		slider[destRow-1]=1;
		
		//No. of times this slider array will work is Length of Column
		for(int noOfSLides=1;noOfSLides<=destCol;noOfSLides++) {
			//Sliding and Adding from ArrayLength-2
			for(int len=slider.length-2;len>=0;len--) {
				int newValue=slider[len]+slider[len+1];
				slider[len]=newValue;
			}
		}
		return slider[0];
	}

	public static void main(String[] args) {
		
		System.out.println(countMazePathsSlider(3,3));
	}

}
