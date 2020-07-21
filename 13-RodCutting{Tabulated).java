
public class RodCuttingTab {
	
	public static void rodCuttingTabulated(int arr[]) {
		//Initializing a Storage Array which be storing the maximized value from the cuts
		 int storage[]=new int[arr.length];
		 
		 //For the Printing of the Path
		 String path[]=new String[arr.length];
		 
		 //Storing 0 and 1 value( as Initial Cuts so these are the maximum)
		 storage[0]=arr[0];
		 storage[1]=arr[1];
		 path[0]="";
		 path[1]="1";
		 
		 //Starting from index 2 to end
		 for(int index=2;index<arr.length;index++) {
			 //Storing the value in Storage Array and we'll change according to the Maximized Price
			 storage[index]=arr[index];
			 path[index]=index+" ";
			 
			 int left=1; //Starting
			 int right=index-1; //End -1
			 
			 while(left<=right) {
				 //The Starting and End Values are greater than the current then change
				 if(storage[left]+storage[right]>storage[index]) {
					 storage[index]=storage[left]+storage[right];
					 path[index]=path[left]+" "+path[right];
				 }
				 //Increment Counter 
				 left++;
				 right--;
			 }
		 }
		//Storage[arr.length-1] is containing the Maximum Price With Cut Given
		System.out.println(storage[arr.length-1]);
		System.out.println(path[arr.length-1]);
	}

	public static void main(String[] args) {
		// An Array denoting the price of the cut to the index of the array
		//That Means Array[0] will store zero cut price and so on
		
		//Intialization Of Array
		int arr[]= {0,3,5,6,15,10,25,12,24};
		
		//Function Call
		rodCuttingTabulated(arr);
		
		
	}

}
