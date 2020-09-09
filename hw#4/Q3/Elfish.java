/**
 * This class finds elfish words recursively
 * @author mustafa
 *
 */
public class Elfish {
	/**
	 * This is to ready to recursive	
	 * @param word
	 * @return
	 */
	public static boolean elfish(String word) {
		return elfish2(word,0,0,0,0);
	}
	
	/**
	 * revursive elfish method
	 * @param word
	 * @param check1 checking e
	 * @param check2 checking l
	 * @param check3 checking f
	 * @param num to stop
	 * @return
	 */
	public static boolean elfish2(String word,int check1,int check2,int check3,int num) {
		if(check1==1 && check2==1 && check3==1) {
			return true;
		}
		if(word.length()==num) {
			return false;
		}
		if(word.charAt(num)=='e' || word.charAt(num)=='E')
				check1=1;
		else if(word.charAt(num)=='l' || word.charAt(num)=='L')
				check2=1;
		else if(word.charAt(num)=='f' || word.charAt(num)=='F')
				check3=1;
		return elfish2(word,check1,check2,check3,num+1);
	}
	
}
