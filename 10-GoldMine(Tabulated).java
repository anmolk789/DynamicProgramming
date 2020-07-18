
public class GoldMin1 {
	
	public static void goldMine(int goldmine[][]) {
		int storageMine[][]=new int [goldmine.length][goldmine[0].length];
		
		//Overall Max
		int overmax=0;
		int overrow=-1;
		int overcol=-1;
		String path="";
		
		//Starting from last column and first row of the last column
		for(int col=goldmine[0].length-1;col>=0;col--) {
			for(int row=0;row<goldmine.length;row++) {
				int nextrowAbove=row-1;
				int nextcol=col+1;
				int nextrowBelow=row+1;
				//Last Column
				 if(col==goldmine[0].length-1) {
					 storageMine[row][col]=goldmine[row][col];
				 }
				 //First Row
				 else if(row==0){
					 if(storageMine[row][nextcol]>storageMine[nextrowBelow][nextcol]){
						 storageMine[row][col]=storageMine[row][nextcol]+goldmine[row][col];
					 }else {
						 storageMine[row][col]=storageMine[nextrowBelow][nextcol]+goldmine[row][col];
						 
					 }
				}
				//Last Row
				 else if(row==goldmine[0].length-1){
					 if(storageMine[row][nextcol]>storageMine[nextrowAbove][nextcol]) {
						 storageMine[row][col]=storageMine[row][nextcol]+storageMine[row][col];
					 }else {
						 storageMine[row][col]=storageMine[nextrowAbove][nextcol]+goldmine[row][col];
					 }
						 
				//Middle Row 
				 }
				 else {
					 //3 Options and Maximum of 3
					 int a=storageMine[row][nextcol];
					 int b=storageMine[nextrowAbove][nextcol];
					 int c=storageMine[nextrowBelow][nextcol];
					 
					 storageMine[row][col]=goldmine[row][col] + Math.max(a, Math.max(b, c))  ;
				}
			if(storageMine[row][col]>overmax) {
				overmax=storageMine[row][col];
				overrow=row;
				overcol=col;
			}
			}
		}
		for(int i=0;i<storageMine.length;i++) {
			for(int j=0;j<storageMine[0].length;j++) {
				System.out.print(storageMine[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println(overmax+" @ [ "+overrow+","+overcol+" ]");
	}

	public static void main(String[] args) {
		//A 2-D Array having Gold.A Miner wants to start from first column to last column.
		//Find out the Maximum Gold he can mine.
		//Rule1-Only 1 Cell from a Column which we can choose
		//Rule2-One Row Above,One Row Below and Same Row (in the next column)
		int goldmine[][]= {
				{2,0,8,4},
				{5,6,7,8},
				{1,2,3,4},
				{0,1,0,1}
		};
		goldMine(goldmine);
	}

}
