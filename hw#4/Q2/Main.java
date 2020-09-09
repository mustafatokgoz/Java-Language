import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		MyDeque<String> temp=new MyDeque<String>();
		
		
		temp.addFirst("10");
		System.out.println("Removing  elemetn that is "+temp.poll());
		temp.addLast("20");
		temp.print();
		System.out.print("removed list ");
		temp.rprint();
		temp.addLast("30");
		temp.print();
		System.out.println("Using peek last method "+temp.peekLast());
		System.out.println("removing first element  that is "+temp.pollFirst());
		temp.print();
		temp.addFirst("40");
		System.out.println("Using peek method  "+temp.peek());
		temp.print();
		System.out.print("removed list ");
		temp.rprint();
		
		temp.addLast("50");
		temp.addLast("60");
		temp.addLast("70");
		temp.addLast("80");
		temp.print();
		System.out.println("Iterator using ..");
		Iterator<String> it=temp.iterator();
		System.out.println("Removing first  2 element using iterator");
		it.remove();
		it.remove();
		while(it.hasNext()) {
			System.out.print(" "+it.next());
		}
		System.out.println("\nDescening iterator using");
		Iterator<String> itDescending=temp.descendingIterator();
		while(itDescending.hasNext()) {
			System.out.print(" "+itDescending.next());
		}

	}

}
