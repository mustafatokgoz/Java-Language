import java.io.Serializable;
import java.util.Scanner;

/**
 * This is BinaryTree class that is implemented in Class Book
 * @author mustafa
 *
 * @param <E>
 */
@SuppressWarnings("serial")
public class BinaryTree<E> implements Serializable {
		
		protected static class Node<E> implements Serializable {
				protected E data;
				protected Node<E> left;
				protected Node<E> right;
				
				public Node(E data) {
					this.data = data;
					left = null;
					right = null;
				}
				
				public String toString() {
					return data.toString();
				}
		}
		
		protected Node<E> root;
		
		public BinaryTree() {
			root = null;
		}
		
		protected BinaryTree(Node<E> root) {
			this.root = root;
		}
		
		public BinaryTree(E data, BinaryTree<E> leftTree,
				BinaryTree<E> rightTree) {
				root = new Node<E>(data);
				if (leftTree != null) {
					root.left = leftTree.root;
				}
				else {
					root.left = null;
				}
				if (rightTree != null) {
					root.right = rightTree.root;
				} 
				else {
					root.right = null;
				}
		}
		public BinaryTree<E> getLeftSubtree() {
			if (root != null && root.left != null) {
				return new BinaryTree<E>(root.left);
			}
			else {
				return null;
			}
		}
		public BinaryTree<E> getRightSubtree() {
			if (root != null && root.right != null) {
				return new BinaryTree<E>(root.right);
			}
			else {
				return null;
			}
		}
		public boolean isLeaf() {
			return (root.left == null && root.right == null);
		}
		public E getData() {
			return root.data;
		}
		public String toString() {
			StringBuilder sb = new StringBuilder();
			preOrderTraverse(root,sb);
			return sb.toString();
		}
		private void preOrderTraverse(Node<E> node,StringBuilder sb) {
			if(node!=null) {
					preOrderTraverse(node.left,sb);
					sb.append(node.toString());
					sb.append("\n");
					
					preOrderTraverse(node.right,sb);
					
				
			}		
		}
		public static BinaryTree<String> readBinaryTree(Scanner scan) {
			String data = scan.next();
			if (data.equals("null")) {
				return null;
			} 
			else {
				BinaryTree<String> leftTree = readBinaryTree(scan);
				BinaryTree<String> rightTree = readBinaryTree(scan);
				return new BinaryTree<String>(data, leftTree,rightTree);
			}
		}
}
