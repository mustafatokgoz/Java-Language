/**
 * Class makes sentence to a reverse string
 * @author mustafa
 *
 */
public class Reverse {
	/**
	 * This method is to ready for recursion method	
	 * @param sentence
	 * @return
	 */
	public static String rev(String sentence) {
		StringBuilder sb=new StringBuilder();
		return reverse(sentence,0,sb,0);
	}
	/**
	 * method makes sentence to a reverse sentence string
	 * @param sentence
	 * @param num to stop
	 * @param sb  to make sentence
	 * @param index  to know index of char
	 * @return reverse sentence
	 */ 
	public static String reverse(String sentence,int num,StringBuilder sb,int index) {
		if(num==sentence.length()) {
			return sb.toString();
		}
		if(sentence.charAt(num)==' ') {
			sb.insert(0,' ');
			return reverse(sentence,num+1,sb,0);
		}
		sb.insert(index, sentence.charAt(num));
		return reverse(sentence,num+1,sb,++index);
		
	}
	
	
}
