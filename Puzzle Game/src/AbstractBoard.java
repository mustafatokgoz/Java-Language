import java.io.IOException;
/**
 * This is abstract class for BoardArrays Classes
 * @author Mustafa Tokgöz
 *
 */
public abstract class AbstractBoard {
	protected static int numofboard=0;
	protected int linenumber=0,x=0;		
	protected char last_move='S'; 
	protected int numberofmove=0;
	
	/**
	 * This is Contructer with no parameter
	 */
	public AbstractBoard() {
		linenumber=0;
		x=0;
		last_move='S';
		numberofmove=0;
		numofboard++;
	}
	/**
	 * This is abstract setSize method
	 * @param height
	 * @param width
	 */
	public abstract void setSize(int height,int width);
	/**
	 * This is abstract reset method
	 */
	public abstract void reset();
	/**
	 * This is Overridden toString method
	 */
	@Override
	public abstract String toString();
	/**
	 * This is abstract readFromFile method
	 * @param file_name
	 * @throws IOException
	 */
	public abstract void readFromFile(String file_name) throws IOException;
	/**
	 * This is abstract move method
	 * @param letter
	 * @return
	 */
	public abstract boolean move(char letter);
	/**
	 * This is abstract isSolved method
	 * @return
	 */
	public abstract boolean isSolved();
	/**
	 * This is abstract writeToFile method
	 * @param file_name
	 * @throws IOException
	 */
	public abstract void writeToFile(String file_name) throws IOException;
	/**
	 * This is abstract cell method
	 * @param index1
	 * @param index2
	 * @return
	 */
	public abstract int cell(int index1,int index2);
	/**
	 * This is abstract Equals method
	 * @param board2
	 * @return
	 */
	public abstract boolean Equals(AbstractBoard board2);
	
	/**
	 * This is abtract findTheBlankPosition method
	 * @param position
	 */
	public abstract void findTheBlankPosition(int position[]);
	
	/**
	 * This is getter for column
	 * @return
	 */
	public int getColumn() {
		return linenumber;
	}
	/**
	 * This is getter for row 
	 * @return
	 */
	public int getRow() {
		return x;
	}
	/**
	 * This is getter for numbofboard 
	 * @return
	 */
	public static int Numberofboard() {
		return numofboard;
	}
	/**
	 * This method is getter for Last Move
	 * @return
	 */
	public char LastMove() {
		return last_move;
	}
	/**
	 * This is getter for number of moves
	 * @return
	 */
	public int NumberOfMoves() {
		return numberofmove;
	}

	
	
	
	
}
