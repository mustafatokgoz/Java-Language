import java.util.Stack;
/**
 * This class evaluating Postfix method
 * @author mustafa
 *
 */
public class Postfix {
		/**
		 * Checking parameter is operator or not
		 * @param a
		 * @return
		 */
		public static boolean is_operator(char a) {
			if(a=='+' || a=='-' || a=='*' || a=='/')
					return true;
			return false;
		}
		/**
		 * This is previous of recursion to ready 
		 * @param s
		 * @return
		 */
		public static double eval(String s) {
			Stack<Double> stack=new Stack<>();
			StringBuilder sb=new StringBuilder();
			return evaluation(s,sb,0,stack);
		}
		/**
		 * This is evaluation recursive method
		 * @param s first string
		 * @param sb to make word
		 * @param num to stop
		 * @param stack to push and pull
		 * @return
		 */
		public static double evaluation(String s,StringBuilder sb,int num,Stack<Double> stack) {
			if(num==s.length())
				return stack.pop();
			if(is_operator(s.charAt(num))) {
				double temp1 = stack.pop();
				double temp2 = stack.pop();
				if(s.charAt(num)=='+')
					stack.push(temp1+temp2);
				if(s.charAt(num)=='-')
					stack.push(temp1-temp2);
				if(s.charAt(num)=='*')
					stack.push(temp1*temp2);
				if(s.charAt(num)=='/')
					stack.push(temp1/temp2);
			}
			else if(s.charAt(num)==' '){
				if(sb.length()!=0)
					stack.push(Double.parseDouble(sb.toString()));
				sb.setLength(0);
				
			}
			else {
				sb.append(s.charAt(num));
			}
			return evaluation(s,sb,num+1,stack);
		}

}
