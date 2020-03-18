/**
 * 
 * @author Mustafa Tokgöz
 *
 */

public class Main {
	/**
	 * This is main function that I control all boards.
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractBoard boards[] = new AbstractBoard[4]; 
		BoardArray2D one = new BoardArray2D(3,3);		
		BoardArray2D two = new BoardArray2D(3,3);	/*These are boardarray2d objects*/
		BoardArray2D three = new BoardArray2D(4,4);	
		BoardArray2D four = new BoardArray2D(5,5);
		
		BoardArray1D onedone = new BoardArray1D(3,3);		
		BoardArray1D onedtwo = new BoardArray1D(3,3);	/*These are boardarray2d objects*/
		BoardArray1D onedthree = new BoardArray1D(4,4);	
		BoardArray1D onedfour = new BoardArray1D(5,5);
		try {
			System.out.println("This is BoardArray2D sequence");
			one.readFromFile("trial");
			boards[0]=one;
			boards[0].move('D');
			System.out.println(boards[0]);
			two.copy(one);
			two.move('R');
			boards[1]=two;
			System.out.println(boards[1]);
			three.copy(two);
			three.move('R');
			boards[2]=three;
			System.out.println(boards[2]);
			four.copy(three);
			boards[3]=four;
			boards[3].move('D');
			System.out.println(boards[3]);
			System.out.println("This sequences' last move is "+boards[3].LastMove());
			System.out.println("This sequences' number of move is "+boards[3].NumberOfMoves());
			
			if(BoardValidity(boards,4)==true){	/*4 is array of board pointer size*/
				System.out.print("This sequance is valid .\n");
				if(boards[3].isSolved()==true) {
					
					System.out.println("This puzzle was Solved");
				}
				else {
					System.out.println("This puzzle was NOT solved");
				}
			}	
			else {
				System.out.print("This sequence is NOT valid. \n");
			}
			System.out.println("\nI write the first board to trial2.txt and I read from it for Board1DArray\n");
			boards[0].writeToFile("trial2.txt");
			
			System.out.println("This is BoardArray1D sequence");
			onedone.readFromFile("trial2.txt");
			System.out.println(boards[0]);
			boards[0]=onedone;
			boards[0].move('R');
			System.out.println(boards[0]);
			onedtwo.copy(onedone);
			onedtwo.move('R');
			boards[1]=onedtwo;
			System.out.println(boards[1]);
			onedthree.copy(onedtwo);
			onedthree.move('D');
			boards[2]=onedthree;
			System.out.println(boards[2]);
			onedfour.copy(onedthree);
			boards[3]=onedfour;
			boards[3].move('R');
			System.out.println(boards[3]);
			System.out.println("This sequences' last move is "+boards[3].LastMove());
			System.out.println("This sequences' number of move is "+boards[3].NumberOfMoves());
			if(BoardValidity(boards,4)==true){	/*4 is array of board pointer size*/
				System.out.print("This sequance is valid .\n");
				if(boards[3].isSolved()==true) {
					
					System.out.println("This puzzle was Solved");
				}
				else {
					System.out.println("This puzzle was NOT solved");
				}
			}	
			else {
				System.out.print("This sequence is NOT valid. \n");
			}
			System.out.printf("\nThere are  %d many board.",AbstractBoard.numofboard);
			

			
		}
		catch(Exception e) {
			System.out.print(e);
		}
		
		

	}
	/**
	 * It controls the array if the number is there or not.
	 * This is helper funtion for BoardValidity
	 * @param array 
	 * @param value -This is the value that You search
	 * @param size -This is array size
	 * @return
	 */
	public static boolean isThere(int array[],int value,int size) {			/*This is helper funtion for BoardValidity*/
			for(int j=0;j<size;j++){
				if(array[j]==value){			/*This is finding number and i change the number with zero becouse I check If The number is exactly one or not*/
					array[j]=0;
					return true;	
				}
			}
			return false;
	}
	/**
	 * This function is checking the board is valid or not.
	 * @param boards 
	 * @param size
	 * @return
	 */

	public static boolean BoardValidity(AbstractBoard boards[],int size){ 		/*The size is array of board pointer size*/
	int count=0,control=0,counter=0;
	int position[] = new int[2];
		for(int i=0;i<size;i++){
			int arr[] = new int[boards[i].getColumn()*boards[i].getRow()];
				for(int j=0;j<boards[i].getColumn();j++){
					for(int k=0;k<boards[i].getRow();k++){
						if(boards[i].cell(j,k)!=0){	/*This is counting how many number are there if it is not zero*/
							count++;
						}					
					}
				}	
				for(int j=0;j<count;j++){
					arr[j]=j+1;			/*I fill the numbers becouse of checking below*/
				}	
				arr[count-1]=-1;
				
				for(int j=0;j<boards[i].getColumn();j++){
					for(int k=0;k<boards[i].getRow();k++){
							if(boards[i].cell(j,k)!=0){
								if(isThere(arr,boards[i].cell(j,k),count)==true){	/*This is checking whether the number is there one ore more*/
									counter++;			/*If number is there 2 times and retruns false and counter doesnt increase*/
								}
							}
					}
				}
				if(counter!=count)	{	/*Then I check number of number is equal counter or not */
					return false;	
				}		/*Then I return  false*/
			if(i!=size-1){
				if(boards[i].Equals(boards[i+1])==true){
					return false;			/*This is checking boards are equal or not*/
				}
				if(boards[i].getColumn()!=boards[i+1].getColumn() || boards[i].getRow()!=boards[i+1].getRow()){
					return false;		/*This is checking column number and row numbers are same or not*/
				}
				boards[i].findTheBlankPosition(position);	//position[0] is linenumber(coloumn), position[1]=x(row)
				/*This is checking next move is valid or not so I check space (-1) so that Whether it moves right left down or right or not*/			

				if(position[0]!=0){
					if(boards[i+1].cell(position[0]-1,position[1])==-1){
						control++;						
					}
				}
				if(position[0]!=boards[i].getColumn()-1){
					if(boards[i+1].cell(position[0]+1,position[1])==-1){
						control++;						
					}
				}
				if(position[1]!=0){
					if(boards[i+1].cell(position[0],position[1]-1)==-1){
						
						control++;						
					}
				}
				if(position[1]!=boards[i].getRow()-1) {
					if(boards[i+1].cell(position[0],position[1]+1)==-1){
						
						control++;						
					}
				}
				if(control!=1){	/*If There are valid space move (control= 1) then it is true but if isnt then retruns false*/
					
					return false;
				}

			}
			
			count=0;control=0;counter=0;
		}
	return true;	/*If everthing is fine then returns true*/
	
	}
	

}
