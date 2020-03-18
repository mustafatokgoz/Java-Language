import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This is BoardArray1D inherited class with AbstractBoard 
 * @author Mustafa Tokgöz
 *
 */
public class BoardArray1D extends AbstractBoard{
	private int puzzle[] = new int[9*9];
	private int goal_puzzle[] = new int[9*9];
	
	/**
	 * This is Constructer with no parameter
	 */
	public BoardArray1D() {
		setSize(3,3);
		last_move='S';
		numberofmove=0;	
		
	}
	/**
	 * This is Constructer with two parameter 
	 * @param one	-This is Column number
	 * @param second -This is Row number
	 */
	public BoardArray1D(int one,int second){
		setSize(one,second);
		last_move='S';
		numberofmove=0;
	}
	/**
	 * This is constructer with other object
	 * @param other
	 */
	
	public BoardArray1D(BoardArray1D other) {
		last_move=other.last_move;
		numberofmove=other.numberofmove;
		linenumber=other.linenumber;
		x=other.x;
		
		for(int i=0;i<linenumber*x;i++){
			puzzle[i]=other.puzzle[i];	
		}
		for(int i=0;i<linenumber*x;i++){
			goal_puzzle[i]=other.goal_puzzle[i];	
		}
		
	}
	/**
	 * This is helper function to copy one to another
	 * @param other -BoardArray2D object
	 */
	public void copy(BoardArray1D other) {
		this.last_move=other.last_move;
		this.numberofmove=other.numberofmove;
		this.linenumber=other.linenumber;
		this.x=other.x;
		
		for(int i=0;i<linenumber*x;i++){
			this.puzzle[i]=other.puzzle[i];	
		}
		for(int i=0;i<linenumber*x;i++){
				this.goal_puzzle[i]=other.goal_puzzle[i];	
		}
		
		
	}
	/**
	 * This is overriding toString method
	 *
	 */
	@Override
	public String toString() {
		 int i=0,j=0;
			System.out.println();
			for(j=0;j<linenumber;j++){						
				for(i=0;i<x;i++){
					if(puzzle[j*x+i]==-1){
						System.out.printf("%3s "," ");	
					}
					else{ 	
						if(puzzle[j*x+i]>=0 && puzzle[j*x+i]<=9){
							System.out.printf(" 0%d ",puzzle[j*x+i]);
						}
						else
							System.out.printf("%3d ",puzzle[j*x+i]);	
					}
				}		
				System.out.println();
				System.out.println();
			}
		return String.format("\n");
	}
	/**
	 * This is setSize method
	 * @param height 
	 * @param width
	 */
	public void setSize(int height,int width){
		linenumber=height;
		x=width;
		if(x<1 || linenumber<1 || x>9 || linenumber>9 ){
			x=3;
			linenumber=3;
		}
		reset();
	}
	/**
	 * This method is reseting the board
	 */
	public void reset() {
	 int i=0,j=0,k=0;
		for(j=0;j<linenumber;j++){				/*This is loop that fills*/
			for(i=0;i<x;i++){
								/*If in the file doesnt have the wall like 00 then it will fill*/
					puzzle[j*x+i]=k+1;
					goal_puzzle[j*x+i]=k+1;
					k++;
			}							/*-1 will be number to use blank that I chose*/
		}
		puzzle[linenumber*x-1]=-1;
		goal_puzzle[linenumber*x-1]=-1;		/*This is blank that will be move*/

		
	}
	/**
	 * This method is reading from file and filling arrays of boards
	 * @throws IOException
	 * @param file_name  
	 */
	public void readFromFile(String file_name) throws IOException{
		  File ffile=new File(file_name); 
	      String[] words=null;  
	      FileReader fileread = new FileReader(ffile);  	/*This is Filereader object*/
	      BufferedReader br = new BufferedReader(fileread); 
	      String s;     
	      String blank="bb";   
	      int i=0,j=0,index=0;  
	      while((s=br.readLine())!=null)   /*This is getting lines*/
	      {  
	    	  j=0;
	          words=s.split(" "); 
	          for (String word : words) 	/*This is taking words*/
	          {
	                 if (word.equals(blank))   
	                 {
	                	 puzzle[index]=-1;
	                	 j++;
	                	 index++;
	                 }
	                 else {
	                	 puzzle[index]=Integer.parseInt(word);
	                	 j++;
	                	 index++;
	                 }
	          }
	        
	          i++;
	      }
	      fileread.close();
	      linenumber=i;
	      x=j;
	      
	      int k=0;
	      for(j=0;j<linenumber;j++){				/*This is loop that fills*/				
				for(int m=0;m<x;m++){
					if( puzzle[j*x+m]!=0 ){				/*If in the file doesnt have the wall like 00 then it will fill*/
						goal_puzzle[j*x+m]=k+1;
						k++;		
					}
					else{
			 			goal_puzzle[j*x+m]=0;			/*Else there is 00  So goal puzzle is 0*/
					}
				}							/*-1 will be number to use blank that I chose*/
			}
			goal_puzzle[linenumber*x-1]=-1;		/*This is blank that will be move*/

	      
	}
	/**
	 * This method is finding the balnk position 
	 * @param position -with size 2 position[0] = column number position[1]=row number
	 */
	public void findTheBlankPosition(int position[]) {
		 int j=0,k=0;
		 int count=0;
				for(j=0;j<linenumber;j++){
					for(k=0;k<x;k++){
						if(puzzle[j*x+k]==-1){			/*I am making the loop stop when I find the blank position*/
							count=1;			/*If count is 1 then loop will be stop just below*/
							position[0]=j;
							position[1]=k;
								break;
						}
							
					}
					if(count==1)					/*Here is it*/
						break;		
				}
		
	}
	/**
	 * This is move method 
	 * 
	 * @return true -If move is successful else returns false
	 * @param letter -The movement letter (U=UP,D=DOWN,R=RIGHT,L=LEFT)
	 */
	public boolean move(char letter) {
		 int position[]=new int[2];
		 int y_cur=0,x_cur=0;
		 int temp;
			 findTheBlankPosition(position);
			 y_cur=position[0];
			 x_cur=position[1];
						if(letter=='R'){
							if(x_cur!=x-1){						/*This is for right move to move blank to right when you push the R*/
								if(puzzle[y_cur*x+x_cur]!=0 && puzzle[y_cur*x+x_cur+1]!=0){
									temp=puzzle[y_cur*x+x_cur];
									puzzle[y_cur*x+x_cur]=puzzle[y_cur*x+x_cur+1];
									puzzle[y_cur*x+x_cur+1]=temp;	/*This is swapping  values*/    
									last_move=letter;   
									numberofmove++;         
								}
								else
									return false;				
							}
							else
								return false;
									
						}
						else if(letter=='L'){ 
							   if(x_cur!=0){
								if(puzzle[y_cur*x+x_cur]!=0 && puzzle[y_cur*x+x_cur-1]!=0){	/*This is for left move to move blank to left when you push the L*/
									temp=puzzle[y_cur*x+x_cur];
									puzzle[y_cur*x+x_cur]=puzzle[y_cur*x+x_cur-1];
									puzzle[y_cur*x+x_cur-1]=temp;
									last_move=letter;
									numberofmove++;
								}
								else
									return false;	
							   }
							   else
								return false;
						}	
						else if(letter=='U'){ 
							   if(y_cur!=0){							/*This is for up move to move blank to up when you push the U*/
								if(puzzle[y_cur*x+x_cur]!=0 && puzzle[(y_cur-1)*x+x_cur]!=0){
									temp=puzzle[y_cur*x+x_cur];
									puzzle[y_cur*x+x_cur]=puzzle[(y_cur-1)*x+x_cur];
									puzzle[(y_cur-1)*x+x_cur]=temp;
									last_move=letter;
									numberofmove++;						
								}
								else
									return false;
							   }
							   else
								return false;
						}
						else if(letter=='D'){
							 if(y_cur!=linenumber-1){						/*This is for down move to move blank to down when you push the D*/
								 if(puzzle[y_cur*x+x_cur]!=0 && puzzle[(y_cur+1)*x+x_cur]!=0){
									 	temp=puzzle[y_cur*x+x_cur];
									 	puzzle[y_cur*x+x_cur]=puzzle[(y_cur+1)*x+x_cur];
									 	puzzle[(y_cur+1)*x+x_cur]=temp;
										last_move=letter;
										numberofmove++;	
								  }
								 else
									return false;
								}
								else
									return false;
						}
							  
						
		 return true;
		
		
	}
	/**
	 * This method is checking if the puzzle solve or not
	 */
	public boolean isSolved() {
		 int i=0,j=0;	
			for(i=0;i<linenumber;i++){						/*This loop is checking if puzzle is correct or not*/
				for(j=0;j<x;j++){
					if(puzzle[i*x+j]!=goal_puzzle[i*x+j]){		/*If there is any mismatch,then it returns 0,So puzzle is not over*/
						return false;		
					}
				}
			}
			
		 return true;
	}
	/**
	 * This method  returns cell content 
	 * @param index1 -The column number
	 * @param index2 -The row number
	 */
	public int cell(int index1,int index2) {
		if(index1>=linenumber || index1<0 || index2>=x || index2<0)	/*This terminates the game if indexes are not true*/
			 System.exit(0);
		return puzzle[index1*x+index2];					/*else returning*/
		
	}
	/**
	 * This method is controlling boards are equal or not
	 * @param board2 -This is AbstractBoard parameter
	 */
	public boolean Equals(AbstractBoard board2) {
		 int i=0,j=0;	
			for(i=0;i<linenumber;i++){						
				for(j=0;j<x;j++){
					if(puzzle[i*x+j]!=board2.cell(i,j)){		
						return false;		
					}
				}
			}
		 return true;
		
	}
	/**
	 * This method is writing board to file
	 * @param file_name -The name of file 
	 * @throws IOException
	 */
	public void writeToFile(String file_name) throws IOException {
		String blank="bb";
		int i=0,j=0;

		
		FileWriter writer = new FileWriter(file_name);
		
		for(j=0;j<linenumber;j++){						/*This is loop that writes to the file*/
			for(i=0;i<x;i++){
				if(puzzle[j*x+i]==-1){
					writer.write(blank);				/*This is writing to file bb instead of -1*/
						if(i!=x-1)			/*if this is not end of the line becouse end of the line doesnt have a space*/
							writer.write(" ");			
				}
				else{ 	
					if(puzzle[j*x+i]>=0 && puzzle[j*x+i]<=9){		
						writer.write("0");
						writer.write(String.valueOf(puzzle[j*x+i]));	/*If there is one digit then it adds a 0 to beginning of the number*/
							if(i!=x-1)
								writer.write(" ");
					}
					else{
						writer.write(String.valueOf(puzzle[j*x+i]));		/*This writesthe number*/
							if(i!=x-1)
								writer.write(" ");	
					}
				}
			}
			if(j!=linenumber-1){				/*Becouse the last line doesnt have a \n */
				writer.write("\n");
			}
		}
		writer.close();
	}
}
