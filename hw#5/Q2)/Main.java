/**
 * Main Class
 * @author mustafa
 *
 */
public class Main {

	public static void main(String args[]) {
		String input1="+ + 10 * 5 15 20";
		System.out.println("Expression is : "+ input1);
		ExpressionTree obj1=new ExpressionTree(input1);
		System.out.println("prefix version = ");
		System.out.println(obj1.toString());
		System.out.println("postfix version = ");
		System.out.println(obj1.toString2());
		System.out.println("Evaluation is : "+ obj1.eval());
		System.out.println();
		String input="10 5 15 * + 20 +";
		System.out.println("Expression is : "+ input);
		ExpressionTree obj2=new ExpressionTree(input);
		System.out.println("prefix version = ");
		System.out.println(obj2.toString());
		System.out.println("postfix version = ");
		System.out.println(obj2.toString2());
		System.out.println("Evaluation is : "+obj2.eval());
	}
	
}
