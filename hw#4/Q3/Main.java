
public class Main {
		public static void main(String[] args) {
			
			System.out.println("Testing waffle word is elfish or not , If it is then prints true else false");
			System.out.println(Elfish.elfish("waffle"));
			
			System.out.println("This is postfix evaluation of  2 30 4 * + 5 +  is "+Postfix.eval("2 30 4 * + 5 +"));
			
			System.out.println("\nThis is prefix evaluation of + + 2 / 4 4 5 is "+Prefix.eval("+ + 2 / 4 4 5"));
			
			System.out.println("testing sentense : This is a sample sentence to test recursive function");
			System.out.println("output : "+Reverse.rev("This is a sample sentence to test recursive function"));
			
			int[] arr= {3,1,2,8,5,4,100,3,5,49,5,6,15,87,150,21,63,4,5,69};
			System.out.println("Before the sorting ..");
			for(int i=0;i<arr.length;i++) {
				System.out.print(" "+arr[i]);
			}
			Sorting.sort(arr,0);
			System.out.println("\nAfter the sorting ..");
			for(int i=0;i<arr.length;i++) {
				System.out.print(" "+arr[i]);
			}
			
			
			System.out.println("\nTesting Spriral Printing ..");
			System.out.println("Before Spriral Printing ..");
			int arr2[][]=new int[5][4];
			for(int i=0;i<arr2.length;i++) {
				for(int j=0;j<arr2[i].length;j++) {
					arr2[i][j]=i*arr2[i].length+j+1;
					System.out.print(" "+arr2[i][j]);
				}
			}
			System.out.println("\nUsing Spiral print method ..");
			Spriral.printSpiral(arr2);
			
		}
}
