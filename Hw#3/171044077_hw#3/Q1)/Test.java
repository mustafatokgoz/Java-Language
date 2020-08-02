

public class Test {

	public static void main(String[] args) {
		LinkedArrayList<String> list = new LinkedArrayList<String>();
		list.addLast("10");
		list.addFirst("9");
		try {
		list.add(3,"11");
		}
		catch(Exception e) {
			System.out.println("Index is out of bounds");
		}
		list.printForward();
		System.out.println("\n \"10\" element index number in the list is "+list.indexOf("10"));
		
		list.set(1, "11");
		System.out.println();
		list.addLast("50");
	       list.addLast("300");
	       list.addLast("51");
	       list.addLast("3");
	       list.addLast("45");
	       list.addLast("64");
	       list.addLast("6");
	       list.addLast("34");
	       list.addLast("562");
	       list.addLast("4");
		list.printForward();
		list.remove(2);
		list.printForward();
		list.remove("9");
		list.printForward();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("get method with index 3 returns "+list.get(3));
		System.out.println("get first returns "+list.getFirst()+" get last returns "+list.getLast());
		
		System.out.println("\n\nBelow size,ListIterator is used.");
		 LinkedArrayList<String>.ListIterator ll = list.ListIterator();
		 ll.add("151");
		 list.printForward();
		 ll.next();
		 ll.remove();
		 list.printForward();
		 ll.set("333");
		 System.out.println("\nnext index number is "+ll.nextIndex());
		  while(ll.hasNext())
	    	   System.out.print(ll.next()+" ");
		  
		 list.printForward();
		 System.out.println();
		  try {
			  while(ll.hasPrevious())
		    	   System.out.print(ll.previous()+" ");
		  }
		  catch(Exception e){}
		  System.out.println();
		  System.out.println("Previous index is "+ ll.previousIndex());
		   list.addFirst("12");
	       list.addFirst("13");
	       list.printForward();
	       System.out.println();

	}

}
