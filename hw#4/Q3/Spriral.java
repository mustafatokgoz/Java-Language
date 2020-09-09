/**
 * Printing Spiral recursively with 2D array
 * @author mustafa
 *
 */
public class Spriral {
		/**
		 * To ready to recursive
		 * @param arr
		 */
		public static void printSpiral(int arr[][]) {
			print(arr,arr[0].length-1,0,0,arr.length-1,0);
			
		}
		/**
		 * This prints elements recursively
		 * @param arr
		 * @param start
		 * @param end
		 * @param direct is detecting row or column
		 * @param select is  to stop
		 */
		public static void printScreen(int[][] arr,int start,int end,int direct,int select) {
			if(select==1 || select==2) {
				if(start==end+1) {
					return;
				}
			}
			else{
				if(start+1==end) {
					return;
				}
			}
			
			if(select==1) {
				System.out.print(" "+arr[direct][start]);
				printScreen(arr,++start,end,direct,select);
			}
			else if(select==2) {
				System.out.print(" "+arr[start][direct]);
				printScreen(arr,++start,end,direct,select);
			}
			else if(select==3) {
				System.out.print(" "+arr[direct][start]);
				printScreen(arr,--start,end,direct,select);
			}
			else {
				System.out.print(" "+arr[start][direct]);
				printScreen(arr,--start,end,direct,select);
			}
		}
	
		/**
		 * Recursion for spiral print  
		 * @param arr
		 * @param right
		 * @param left
		 * @param top
		 * @param bottom
		 * @param direction
		 */
		public static void print(int arr[][],int right,int left,int top,int bottom,int direction) {
			if(top>bottom && left>right) {
				return ;
			}
			if(direction==0) {
				printScreen(arr,left,right,top,1);
				print(arr,right,left,++top,bottom,++direction);
			}
			else if(direction==1) {
				printScreen(arr,top,bottom,right,2);
				print(arr,--right,left,top,bottom,++direction);
			}
			else if(direction==2) {
				printScreen(arr,right,left,bottom,3);
				print(arr,right,left,top,--bottom,++direction);
			}
			else if(direction==3) {
				printScreen(arr,bottom,top,left,0);
				print(arr,right,++left,top,bottom,0);
			}
			
		}
		
}
