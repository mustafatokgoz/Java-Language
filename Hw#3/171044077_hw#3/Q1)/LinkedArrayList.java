import java.util.AbstractList;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * LinkedArrayList Class that extends AbstractList and implements List
 * This class is linked list and also array list
 * Every Node has array that is sized 10
 * @author mustafa tokgöz 171044077
 *
 * @param <E>
 */

public class LinkedArrayList<E> extends AbstractList<E> implements List<E>{
	/**
	 * Head shows the head of the list
	 * Tail shows at the end of the list
	 * size shows how many list there are.
	 */
	private Node<E> head=null;
	private Node<E> tail=null;
	private int size;

	/**
	 *No parameter constructor
	 */
	LinkedArrayList(){
		size=0;
	}
	/**
	 * Private Node class to implement data with sized array
	 * Couse of being static is that there is no need for it to access the data fields of its parent class
	 * Node has next and prev to traverse in linkedarraylist 
	 * @author mustafa
	 *
	 * @param <E>
	 */
	private static class Node<E>{
		/**
		 * The data is generic type
		 * Every Node has next and previous and datasize.
		 * Datasize shows number of element in the data that is not null 
		 */
		 private E[] data;
		 private Node<E> next ;
		 private Node<E> prev ;
		 private int datasize=0;
		 
		 /**
		  * No parameter constructor
		  */
		 @SuppressWarnings("unchecked")
		private Node() {
			data = (E[]) new Object[10];
			next=null;
			prev=null;
			datasize=0;
		}
		 /**
		  * Constructor with E type  array
		  * @param dataItems
		  */
		@SuppressWarnings("unchecked")
		private Node(E dataItems[]) {
				data = (E[]) new Object[10];
				for(int i=0;i<10;i++)
					data[i]=dataItems[i];
				datasize=10;
				next=null;
				prev=null;
		}
		/**
		 * Constructor with next and previous node
		 * @param nodeRef
		 * @param nodeRefPrev
		 */
		@SuppressWarnings("unchecked")
		private Node( Node<E> nodeRef,Node<E> nodeRefPrev) {
			data = (E[]) new Object[10];
			prev = nodeRefPrev;
			next = nodeRef;
			
		}
		/**
		 * Constructor with data , next and previous
		 * Data is assigned to first array index in the node
		 * @param dataItem
		 * @param nodeRef
		 * @param nodeRefPrev
		 */
		@SuppressWarnings("unchecked")
		private Node(E dataItem, Node<E> nodeRef,Node<E> nodeRefPrev) {
			data = (E[]) new Object[10];
			data[0]=dataItem;
			datasize++;
			prev = nodeRefPrev;
			next = nodeRef;
			
		}
		
	}
	/**
	 * ListIterator Class that traverses the linked array list
	 * @author mustafa
	 *
	 */
	public  class ListIterator {
		/**
		 * Class has nextItem node and lastItemReturned node that is needed to traverse
		 */
		private Node<E> nextItem=null;
		private Node<E> lastItemReturned;
		private int index = 0;
		/**
		 * Constructor with i 
		 * i is index parameter that is started from there.
		 * @param i
		 */
		public ListIterator(int i) {
			int nodenumber=0;
			int datanumber=0;
			int arrayindex=0;
			Node<E> temp=head;
			//Founding node node of linked array list
			while(temp!=null) {
				nodenumber++;
				datanumber=temp.datasize+datanumber;
				temp=temp.next;

				
			}
			if(i<0 || i>=datanumber)
				throw new ArrayIndexOutOfBoundsException();
			lastItemReturned = null;
			if (i == datanumber) {
				index = datanumber-1;
				nextItem = null;
			}
			else { 
				temp=head;
				nodenumber=0;
				for(int j=0;j<nodenumber;j++) {
					if(datanumber>i) {
						 arrayindex=i;
						//int num=0;
						Node<E> temp2=temp;
						while(temp2!=null) {
							if(temp2.prev!=null) {
							arrayindex=arrayindex-temp2.prev.datasize;
							temp2=temp2.prev;
							}
							else {
								break;
							}
						}	
					}
					nodenumber++;
				}	
				nextItem=head;
				index=arrayindex;
				//next item is going until node number 
				for (index = 0; index < nodenumber; index++) {
				nextItem = nextItem.next;
				}
				index=i;
			}

		}
		/**
		 * returns true if It has next 
		 * returns false if it has not
		 * @return
		 */
		public boolean hasNext() {
			return  nextItem != null ;
		}
		/**
		 * returns array element that is next 
		 * @throws IndexOutOfBoundsException if It has not next
		 * @return
		 */
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			lastItemReturned = nextItem;
			int datanumber=0;
			Node<E> temp=head;
			//Founding node node of linked array list
			while(temp!=null) {
				datanumber=temp.datasize+datanumber;
				temp=temp.next;
			}
			
			if(index>=nextItem.datasize-1) {
				Node<E> temp3=nextItem;
				nextItem = nextItem.next;
				index=0;
				return lastItemReturned.data[temp3.datasize-1];
				
			}
			// else index is increased and return the element that is next
				index++;
			return lastItemReturned.data[index-1];

		}
		/**
		 * returns true if It has previous 
		 * returns false if it has not
		 * @return
		 * @return
		 */
		public boolean hasPrevious() {
			return (nextItem == null && size != 0) || nextItem==head || nextItem.prev!= null  ;
		}
		/**
		 * returns array element that is previous 
		 * @throws IndexOutOfBoundsException if It has not previous
		 * @return
		 */
		public E previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			int datanumber=0;
			Node<E> temp=head;
			//Founding node node of linked array list
			while(temp!=null) {
				datanumber=temp.datasize+datanumber;
				temp=temp.next;
			}
			if (nextItem == null) { 
				nextItem=tail;
				index=nextItem.datasize;
			}
			else {
				//else check whether the element is 0 or not because if it zero then node is node previous  
					if(index==0) {
						index=nextItem.prev.datasize;
						nextItem = nextItem.prev;
					}
			}
			lastItemReturned = nextItem;
			// IF index is not zero then index is decreased
			if(index!=0)
					index--;
			return lastItemReturned.data[index];


		}
		/**
		 * This returns next index number if next index does not exist then returns size * 10 because of array 
		 * @return
		 */
		public int nextIndex() {
			Node<E> temp=nextItem;
			int indexnumber=0;
			int num=0;
			while(temp!=null) {
				num=temp.datasize+num;
				temp=temp.prev;
			}
			if(nextItem==null) {
				temp=head;
				while(temp!=null) {
					num=num+temp.datasize;
					temp=temp.next;
				}
				return num;
			
			}	
			if(nextItem.datasize!=0)
				indexnumber=num-(nextItem.datasize-1)+index;
			else
				indexnumber=num-index;
			if(indexnumber>num-1) {
				return num;
			}	
			return indexnumber;
			
		}
		/**
		 * This returns previous index number if previous index does not exist then returns -1  
		 * @return
		 */
		public int previousIndex() {
			Node<E> temp=nextItem;
			int indexnumber=0;
			int num=0;
			if(nextItem==null) {
				return -1;
			
			}	
			while(temp!=null) {
				num=temp.datasize+num;
				temp=temp.prev;
			}
			if(nextItem.datasize!=0)
				indexnumber=num-(nextItem.datasize-1)+index-1;
			else
				indexnumber=num-index-1;
			if(indexnumber<=0) {
				return -1;
			}	
			return indexnumber-1;
		}
		/**
		 * This method is adding object to index element
		 * @param obj
		 */
		void add(E obj) {
			//If nextItem is null then
			if(nextItem==null) {
				Node<E> newNode = new Node<E>(obj,null,tail);
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
				size++;
				index=0;
				return;
			}
			// if index is 10
			if(index==10) {
					if(nextItem.next!=null) {
						nextItem=nextItem.next;
						index=0;
					}	
					else {
						Node<E> newNode = new Node<E>(obj,null,tail);
						tail.next = newNode;
						newNode.prev = tail;
						tail = newNode;
						size++;	
						index=1;
						return;
					}	
			}
			// if it is null
			if(nextItem.data[index]==null) {
				nextItem.data[index]=obj;
				nextItem.datasize++;
				return;
			}
			// if it is full
			else if(nextItem.datasize==10) {
				Node<E> temp=nextItem;
				while(temp!=null) {
					if(temp.datasize>9) {
						if(temp.next!=null)
							temp=temp.next;
						else {
							Node<E> newNode = new Node<E>(temp.data[9],null,tail);
							tail.next = newNode;
							newNode.prev = tail;
							tail = newNode;
							size++;	
						}
					}
					else {
						while(temp!=nextItem) {
							for(int i=temp.datasize-1;i>=0;i--) {
								temp.data[i+1]=temp.data[i];
							}
							if(temp.datasize!=10)
								temp.datasize++;
							temp=temp.prev;
							temp.next.data[0]=temp.data[9];
							
						}
						for(int i=8;i>=index;i--) {
							nextItem.data[i+1]=nextItem.data[i];
						}
						nextItem.data[index]=obj;
						if(nextItem.datasize!=10)
							nextItem.datasize++;
						else
							nextItem.datasize=10;
						return;
					}
				}
				
			}
			//else
			else {
				for(int i=8;i>=index;i--) {
					nextItem.data[i+1]=nextItem.data[i];
				}
				nextItem.data[index]=obj;
				nextItem.datasize++;

			}
				
		}
		/**
		 * This is setting object to index element
		 * @param obj
		 * @throws If index is bigger size *10 and smaller 0
		 */
		void set(E obj) {
			if(nextItem==null || index>nextItem.datasize-1 || index<0 )
				throw new IllegalStateException();
			nextItem.data[index]=obj;
			
		}
		/**
		 * This method is removing index element
		 * @throws if index is smaller than 0 or index is bigger than size*10 or nextItem is zero
		 */
		void remove() {
			int check=0;
			if(nextItem==null || index>nextItem.datasize-1 || index<0 )
				throw new IllegalStateException();
			//this is shifting right to left
			for(int i=index;i<9;i++) {
				nextItem.data[i]=nextItem.data[i+1];
			}
			nextItem.datasize--;
			//this is checking node is fully empty or not
			for(int i=0;i<10;i++) {
				if(nextItem.data[i]==null) {
					check++;
				}
			}
			// if it fully empty then it changes nexts and previouses for removing that node
			if(check==10) {
				if(nextItem.prev!=null && nextItem.next!=null) {
					nextItem.prev.next=nextItem.next;
					nextItem.next.prev=nextItem.prev;
				}	
				else if(nextItem.prev!=null && nextItem.next==null){
					tail=nextItem.prev;
					tail.next=null;	
				}	
				else if(nextItem.prev==null && nextItem.next!=null){
					nextItem=nextItem.next;
					nextItem.prev=null;
					head=nextItem;
				}
				else {
					nextItem=null;
					head=null;
					tail=null;
				}
				size--;
			}
		}
		
	}
	/**
	 * @return true If empty or false if filled
	 */
	public boolean isEmpty() {
		return size==0;
	}
	/**
	 * This method is adding at the beginning of the node
	 * If It is full then it creates a new head node that has this obj at the beginning 
	 * @param obj
	 */
	public void addFirst(E obj) {
		//If head is null then it creates
		if(head==null) {
			Node<E> temp = new Node<E>(obj,head,null);
			head=temp;
			if(tail==null) {
				tail=temp;
			}
			size++;
		}
		//else
		else {
			//If head has empty space then it shift if first element is not null
			if(head.datasize<10 && head.datasize>0) {
				if(head.data[0]==null) {
					head.data[0]=obj;
				}
				else {
					for(int i=8;i>=0;i--) {
						head.data[i+1]=head.data[i];
					}
					head.data[0]=obj;
				}
				head.datasize++;
			}
			// else creates new node that is head
			else {
				Node<E> temp = new Node<E>(obj,head,null);
				if(head!=null) {
				head.prev=temp;
				}
				head=temp;
				if(tail==null) {
					tail=temp;
				}
				size++;
				
			}
		}
	}
	
	/**
	 * This method is adding element to the last
	 * @param obj
	 */
	public void addLast(E obj) {
		//If tail is null
		if(tail==null) {
			Node<E> temp = new Node<E>(obj,null,tail);
			tail=temp;
			if(head==null) {
				head=temp;
			}
			size++;
		}
		// else 
		else {
			if(tail.datasize<10 && tail.datasize>0) {
				tail.data[tail.datasize]=obj;
				tail.datasize++;
			}
			else {
				Node<E> temp = new Node<E>(obj,null,tail);
				if(tail!=null) {
					tail.next=temp;
				}
				tail=temp;
				if(head==null) {
					head=temp;
				}
				size++;	
			}
		}
	}
	/**
	 * @return if add is succeeded or not
	 * This method calling addLast method
	 */
	public boolean add(E obj) {
		this.addLast(obj);
		return true;
	}
	/**
	 * This method adding element at given index
	 * @throws if index is out of bounds
	 */
	public void add(int index,E obj) {
		int nodenumber=0;
		int datanumber=0;
		Node<E> temp=head;
		while(temp!=null) {
			nodenumber++;
			//finding total number element
			datanumber=temp.datasize+datanumber;
			temp=temp.next;

			
		}
		if(index<0 || index>=datanumber)
			throw new ArrayIndexOutOfBoundsException();
		if(head==null) {
			throw new ArrayIndexOutOfBoundsException();
		}
		else {
			temp=head;
			datanumber=0;
			//finding index and it shift array if it needs or create new node if needs
			for(int i=0;i<nodenumber;i++) {
				datanumber=temp.datasize+datanumber;
				if(datanumber>index) {
					int arrayindex=index;
					Node<E> temp2=temp;
					while(temp2!=null) {
						if(temp2.prev!=null) {
						arrayindex=arrayindex-temp2.prev.datasize;
						temp2=temp2.prev;
						}
						else {
							break;
						}
					}	
					if(temp.datasize!=10) {
						
						for(int k=8;k>=arrayindex;k--) {
							temp.data[k+1]=temp.data[k];
						}
						temp.data[arrayindex]=obj;
						temp.datasize++;
						return;
					}
					else {
						Node<E> temp3=temp;
						while(temp3.next!=null && temp3.next.datasize!=10) {
							temp3=temp3.next;
						}
						if(temp3.datasize!=10) {
							temp3.datasize++;
							while(temp3!=temp) {
								for(int k=8;k>=0;k--) {
									temp3.data[k+1]=temp3.data[k];
								}
								if(temp3.prev!=null)
									temp3.data[0]=temp3.prev.data[9];
								temp3=temp3.prev;
							}
							for(int k=8;k>=arrayindex;k--) {
								temp.data[k+1]=temp.data[k];
							}
							temp.data[arrayindex]=obj;
							return;
						}
						else {
							Node<E> tmp=new Node<E>(tail.prev.data[9],null,tail);
							if(tail!=null) {
								tail.next=tmp;
							}
							tail=tmp;
							if(head==null) {
								head=tmp;
							}
							size++;	
							while(temp3!=temp) {
								for(int k=8;k>=0;k--) {
									temp3.data[k+1]=temp3.data[k];
								}
								if(temp3.prev!=null)
									temp3.data[0]=temp3.prev.data[9];
								temp3=temp3.prev;
							}
							for(int k=8;k>=arrayindex;k--) {
								temp.data[k+1]=temp.data[k];
							}
							temp.data[arrayindex]=obj;
							return;
							
						}
						
					}
					
				}
				temp=temp.next;
			}
		}
	}

	 public void printForward(){
	         
	        System.out.println("\niterating forward");
	        Node<E> tmp = head;
	        while(tmp != null){
	        	for(int i=0;i<tmp.datasize;i++)
	        		if(tmp.data[i]!=null)
	        			System.out.print(tmp.data[i]+" ");
	            tmp = tmp.next;
	        }
	  }
	  public void printBackward(){
	         
	        System.out.println("iterating backword");
	        Node<E> tmp = tail;
	        while(tmp != null){
	        	for(int i=tmp.datasize-1;i>=0;i--)
	        		if(tmp.data[i]!=null)
	        			System.out.print(tmp.data[i]+" ");
	            tmp = tmp.prev;
	        }
	    }
	  /**
	   * This get method is getting element at the index
	   * @return element
	   */
	@Override
	public E get(int index) {
		int nodenumber=0;
		int datanumber=0;
		Node<E> temp=head;
		while(temp!=null) {
			nodenumber++;
			//founding total element number
			datanumber=temp.datasize+datanumber;
			temp=temp.next;
		}
		if(index<0 || index>=datanumber)
			throw new ArrayIndexOutOfBoundsException();
		temp=head;
		datanumber=0;
		//finging and getting element
		for(int i=0;i<nodenumber;i++) {
			datanumber=temp.datasize+datanumber;
			if(datanumber>index) {
				int arrayindex=index;
				Node<E> temp2=temp;
				while(temp2!=null) {
					if(temp2.prev!=null) {
					arrayindex=arrayindex-temp2.prev.datasize;
					temp2=temp2.prev;
					}
					else {
						break;
					}
				}
				return temp.data[arrayindex];
			}
			temp=temp.next;
		}	
		return null;		
	}
	/**
	 * This is getting first element of linked array list
	 * @return
	 */
	public E getFirst() {
		return head.data[0];
	}
	/**
	 * This is getting last element of linked array list
	 * @return
	 */
	public E getLast() {
		return tail.data[tail.datasize-1];
	}
	/**
	 * This returns total elemant size
	 * @return
	 */
	@Override
	public int size() {
		Node<E> temp=head;
		int arraysize=0;
		while(temp!=null) {
			arraysize=arraysize+temp.datasize;
			temp=temp.next;
		}
			
		return arraysize;
	}
	/**
	 * This method is removing object of the linked array list that is equal to parameter obj
	 * @return true if it success 
	 */
	@Override
	public boolean remove(Object obj) {
		Node<E>temp=head;
		//If head is null
		if(head==null)
			return false;
		//It shifts element 
		while(temp!=null) {
			for(int i=0;i<temp.datasize;i++) {
				if(temp.data[i]!=null && temp.data[i].equals(obj)) {
					for(int j=i;j<9;j++) {
						temp.data[j]=temp.data[j+1];
					}
					temp.datasize--;
					temp.data[9]=null;
					for(int k=0;k<10;k++) {
						if(temp.data[k]!=null)
							return true;
					}
					if(temp==head) {
						head=head.next;
						head.prev=null;
						size--;
						return true;
						
					}
					// If all element in node is null then it removed from linkedarraylist
					else {
						Node<E> temp2 =temp;
						temp=temp.prev;
						temp.next=temp2.next;
						size--;
						return true;
					}
				}		
			}
			temp=temp.next;
		} 
		
		return false;
	}
	
	/**
	 * This remove method removing element at the index
	 * @throws if index is out of bound
	 * @return element that is removed
	 */
	@Override
	public E remove(int index) {
		E returnnumber;
		int nodenumber=0;
		int datanumber=0;
		Node<E> temp=head;
		while(temp!=null) {
			nodenumber++;
			datanumber=temp.datasize+datanumber;
			temp=temp.next;
		}
		if(index<0 || index>=datanumber)
			throw new ArrayIndexOutOfBoundsException();
		temp=head;
		datanumber=0;
		//finding and removing element at index
		for(int i=0;i<nodenumber;i++) {
			datanumber=temp.datasize+datanumber;
			if(datanumber>index) {
				int arrayindex=index;
				Node<E> temp2=temp;
				while(temp2!=null) {
					if(temp2.prev!=null) {
					arrayindex=arrayindex-temp2.prev.datasize;
					temp2=temp2.prev;
					}
					else {
						break;
					}
				}
				returnnumber=temp.data[arrayindex];
				for(int j=arrayindex;j<9;j++) {
					temp.data[j]=temp.data[j+1];
				}
				temp.datasize--;

				temp.data[9]=null;
				for(int j=0;j<10;j++) {
					if(temp.data[j]!=null)
						return returnnumber;
				}
				if(temp==head) {
					head=head.next;
					head.prev=null;
					size--;
					return returnnumber;
					
				}
				else {
					Node<E> temp3 =temp;
					temp=temp.prev;
					temp.next=temp3.next;
					size--;
					return returnnumber;
				}
				
			}
			temp=temp.next;
			
		}
		return null;

	}
	/**
	 * This method  clears linkedarraylist
	 */
	@Override
	public void clear() {
		this.head=null;
		this.tail=null;
		size=0;
	}
	/**
	 * This method returns of index of object that send to method
	 */
	@Override
	public int indexOf(Object o) {
		Node<E>temp=head;
		int number=0;
		if(head==null)
			return -1;
		while(temp!=null) {
			for(int i=0;i<temp.datasize;i++) {
				if(temp.data[i]!=null && temp.data[i].equals(o)) {
					return number;
				}
				number++;
			}
			temp=temp.next;
		}
		return -1;
	}


	/**
	 * This method is ListIteretor that begins  0
	 * @return
	 */
	public  ListIterator ListIterator() {
		ListIterator temp= new ListIterator(0);
		return temp;
	}
	/**
	 * This method is ListIteretor that begins index 
	 * @param index
	 * @return
	 */
	public  ListIterator ListIterator(int index) {
		ListIterator temp= new ListIterator(index);
		return temp;
	}
	/**
	 * This method setting element at the given index
	 * @return previous element
	 * @param index and element
	 * @throws index out of bounds
	 */
	@Override
	public E set(int index, E element) {
		int nodenumber=0;
		int datanumber=0;
		Node<E> temp=head;
		while(temp!=null) {
			nodenumber++;
			datanumber=temp.datasize+datanumber;
			temp=temp.next;
		}
		if(index<0 || index>=datanumber)
			throw new ArrayIndexOutOfBoundsException();
		temp=head;
		datanumber=0;
		//finding index and setting element
			for(int i=0;i<nodenumber;i++) {
				datanumber=temp.datasize+datanumber;
				if(datanumber>index) {
					int arrayindex=index;
					Node<E> temp2=temp;
					while(temp2!=null) {
						if(temp2.prev!=null) {
						arrayindex=arrayindex-temp2.prev.datasize;
						temp2=temp2.prev;
						}
						else {
							break;
						}
					}
					E returnnumber=temp.data[arrayindex];
					temp.data[arrayindex]=element;
					return returnnumber;
					
				}
				temp=temp.next;
			}
				


			return null;
	}


	
		
}
