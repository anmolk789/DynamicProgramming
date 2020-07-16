
public class squareMatrix {
	// The Row and Column of the Last Row and Column will be the same value
	public static void printSquareMatrix(int matrix[][]) {
		//Define a matrix with the same dimensions as the input matrix
		int storage[][]=new int[matrix.length][matrix[0].length];
		
		//Every element in storage will denote max size square can be formed with it.
		
		int overMax=0;
		int maxRow=-1;
		int maxCol=-1;
		for(int row=matrix.length-1;row>=0;row--) {
			for(int col=matrix[0].length-1;col>=0;col--) {
				//Creating variables to check for next Row and Column
				int rowCheck=row+1;
				int  colCheck=col+1;
				//Storing the value of matrix in the storage 
				
				//Last Row and Last Col Max Square will be the element present in it
				if(row==matrix.length-1 && col==matrix[0].length-1) {
					storage[row][col]=matrix[row][col];
				}
				else if(row== matrix.length-1 || col== matrix[0].length-1) {
					storage[row][col]=matrix[row][col];
				}
				
				else {
					if(matrix[row][col]==0) {
						storage[row][col]=matrix[row][col];
						
					}
					else
					{storage[row][col]=1+Math.min(storage[rowCheck][col],
										Math.min(storage[row][colCheck],
												 storage[rowCheck][colCheck]));
					
				}}
			if(storage[row][col]>overMax) {
				overMax=storage[row][col];
				maxRow=row;
				maxCol=col;
			}
		}
	}
	System.out.println(overMax+" @ ["+maxRow+","+maxCol+"]");	
}

	public static void main(String[] args) {
		// Given A 2-D Array with 1's and 0's
		// Find the biggest square matrix(consisting of 1)+row+column
		
		int matrix[][]= {
				{1,0,1,0,0,1},
				{1,0,1,1,1,1},
				{1,1,1,1,1,1},
				{1,1,1,1,0,0},
				{1,1,1,1,1,1},
				{0,0,0,0,1,0}
		};
		
		printSquareMatrix(matrix);

	}

}
