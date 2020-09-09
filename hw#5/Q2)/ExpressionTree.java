import java.util.Scanner;
/**
 * This is Expression Tree Class that extends BinaryTree<String>
 * @author mustafa
 *
 */
@SuppressWarnings("serial")
public class ExpressionTree extends BinaryTree<String>{
		/**
		 * This is expression binaryTree
		 */
		private  BinaryTree<String> expression;
		
		
		/**
		 * 1 parameter constructor
		 * @param exp is prefix or postfix
		 */
		ExpressionTree(String exp){
			expression = new BinaryTree<String>();
			if(isOperator(exp.charAt(0))) {//that means this is a prefix expression
				Scanner scan = new Scanner(exp);
				expression=readBinaryTree(scan);
			}
			else {
				StringBuilder sb=new StringBuilder();
				exp=reverse(exp,0,sb,0);
				Scanner scan = new Scanner(exp);
				expression=readBinaryTree(scan);
			}
		}
		/**
		 * This is for finding prefix of postfix expression
		 * Becouse reverse of postfix is also prefix
		 * @param sentence
		 * @param num
		 * @param sb
		 * @param index
		 * @return
		 */
		private String reverse(String sentence,int num,StringBuilder sb,int index) {
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
		/**
		 * toString method that calls preOrderTraverse
		 */
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			preOrderTraverse(expression.root, 1, sb);
			return sb.toString();
		}
		/**
		 * This shows expression tree in prefix version  recursively
		 * @param node
		 * @param depth
		 * @param sb
		 */
		private void preOrderTraverse(Node<String> node, int depth,StringBuilder sb) {
				if(node!=null){
						sb.append(" "+node.toString());
					preOrderTraverse(node.left, depth + 1, sb);
				
					preOrderTraverse(node.right, depth + 1, sb);
					
				}
		}
		
		/**
		 * This is toString2 method that calls postOrderTraverse
		 * @return
		 */
		public String toString2() {
			StringBuilder sb = new StringBuilder();
			postOrderTraverse(expression.root,sb);
			return sb.toString();
		}
		
		/**
		 * This shows expression tree in postfix version recursively
		 * @param node
		 * @param sb
		 */
		private void postOrderTraverse(Node<String> node,StringBuilder sb) {

				if (node != null) {	
					postOrderTraverse(node.left, sb);
					postOrderTraverse(node.right,sb);
					sb.append(node.toString());
					sb.append(" ");
					
					
				}
		}
		/**
		 * @param op
		 * @return if char is operator then it returns true else false
		 */
		private boolean isOperator(char op) {
			switch (op) {
				case '+' :
						return true;
				case '-' :
						return true;
				case '/' :
						return true;
				case '*' :
						return true;
				default :
						return false;
			}
		}

		/**
		 * This is constucting BinaryTree of expression
		 * @param scan
		 * @return
		 */
		public static BinaryTree<String> readBinaryTree(Scanner scan){
			if(scan.hasNext()) {		
				String data = scan.next();
						try {
							Integer.parseInt(data);
							return new BinaryTree<String>(data,null,null);
						}
						catch(Exception e){	
							BinaryTree<String> leftTree = readBinaryTree(scan);
							BinaryTree<String> rightTree = readBinaryTree(scan);
							return new BinaryTree<String>(data, leftTree,rightTree);
						
						}
			}
			else
				return null;

		}
		/**
		 * This is for calling recursive method
		 * @return
		 */
		public int eval() {
			return eval(expression.root);
		}
		/**
		 * This is calculating expression recursively by using binarytree
		 * @param temp
		 * @return
		 */
		private int eval(Node<String> temp) {
			if(temp==null)
				return 0;
			if(temp.left==null && temp.right==null)
				return Integer.parseInt(temp.data);
			
			int right=eval(temp.right);
			int left=eval(temp.left);
			if(isOperator(temp.data.charAt(0))) {
				if(temp.data.charAt(0)=='*') 
					return right * left;
				else if(temp.data.charAt(0)=='/') 
					return right / left;
				else if(temp.data.charAt(0)=='+') 
					return right + left;
				else 
					return right - left;
			}
			else {
				return Integer.parseInt(temp.data);
			}
		}
		

}
