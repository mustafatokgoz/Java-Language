import java.util.AbstractCollection;
import java.lang.IllegalStateException;
import java.util.Deque;
import java.util.Iterator;


public class MyDeque<E> extends AbstractCollection<E> implements Deque<E>{
	private LinkedList<E> deq;
	private LinkedList<E> removed;
	
	MyDeque(){
		deq=new LinkedList<E>();
		removed=new LinkedList<E>();
	}
	
	/**
	 * MyIterator class implements Iterator class to iterate deque
	 * @author mustafa
	 *
	 */
	public class MyIterator implements Iterator<E>{
		/**
		 * Nodes shows next item and last item returened
		 */
        private LinkedList<E>.Node<E> nextItem;
        private LinkedList<E>.Node<E> lastItemReturned;
        private int index;
        /**
         * This is one parameter constructor
         * @param i
         */
		public MyIterator(int i) {
            // Validate i parameter.
            if (i < 0 || i > deq.size) {
                throw new IndexOutOfBoundsException("Invalid index " + i);
            }
            lastItemReturned = null; // No item returned yet.
            // Special case of last item.
            if (i == deq.size) {
                index = deq.size;
                nextItem = null;
            } else { // Start at the beginning
                nextItem =deq.head;
                for (index = 0; index < i; index++) {
                    nextItem = nextItem.next;
                }
            }
        }
		/**
		 * @return if it has next
		 */
		@Override
        public boolean hasNext() {
            return nextItem != null;
        }
        /**
         * @return next element
         */
		@Override
        public E next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException();
            }
            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            index++;
            return lastItemReturned.data;
        }
		/**
		 * This removed the element but also it add the removed element to removed LinkedList by changing node's next and prev
		 */
		@Override
		public void remove() {
			if(nextItem==null)
                throw new IllegalStateException();
            if(nextItem.prev!=null && nextItem.next!=null) {
            	LinkedList<E>.Node<E> temp=nextItem;
                nextItem.prev.next=nextItem.next;
                nextItem.next.prev=nextItem.prev;
                if(removed.tail!=null)
                	removed.tail.next=temp;
                nextItem.prev=removed.tail;
                removed.tail=temp;
                removed.tail.next=null;
                
            }
            else if(nextItem.prev!=null && nextItem.next==null){
                deq.tail=nextItem.prev;
                deq.tail.next=null;
                if(removed.tail!=null)
                	removed.tail.next=nextItem;
                nextItem.prev=removed.tail;
                removed.tail=nextItem;
                removed.tail.next=null;
                
            }
            else if(nextItem.prev==null && nextItem.next!=null){
            	LinkedList<E>.Node<E> temp=nextItem;
                nextItem=nextItem.next;
                nextItem.prev=null;
                deq.head=nextItem;
                if(removed.tail!=null)
                	removed.tail.next=temp;
                temp.prev=removed.tail;
                removed.tail=temp;
                removed.tail.next=null;
               
            }
            else {
            	if(removed.tail!=null)
            		removed.tail.next=nextItem;
                nextItem.prev=removed.tail;
                removed.tail=nextItem;
                removed.tail.next=null;
            	nextItem=null;
                deq.head=null;
                deq.tail=null;
                
            }
            deq.size--;
		}
        
        
	}
	/**
	 * MyIteratorForDecsending implement Iterator to itarete deque but the other side 
	 * @author mustafa
	 *
	 */
	public class MyIteratorForDescending implements Iterator<E>{
        private LinkedList<E>.Node<E> nextItem;
        private LinkedList<E>.Node<E> lastItemReturned;
        private int index;
        /**
         * One parameter Constructor for descending
         * @param i
         */
		public MyIteratorForDescending(int i) {
            // Validate i parameter.
            if (i < 0 || i > deq.size) {
                throw new IndexOutOfBoundsException("Invalid index " + i);
            }
            lastItemReturned = null; // No item returned yet.
            // Special case of last item.
            if (i == deq.size) {
                index = deq.size;
                nextItem = null;
            } else { // Start at the beginning
                nextItem =null;
                for (index = 0; index < i; index++) {
                    nextItem = nextItem.next;
                }
            }
        }
		/**
		 * @return true if it has previous actually becouse of decsending iterator
		 */
		@Override
        public boolean hasNext() {
        	 return (nextItem == null && deq.size != 0)
                     || nextItem.prev != null;
        }
		/**
		 * @return element of previous actually
		 */
        public E next() {
        	 if (!hasNext()) {
                 throw new IndexOutOfBoundsException();
             }
             if (nextItem == null) { 
                 nextItem = deq.tail;
             } else {
                 nextItem = nextItem.prev;
             }
             lastItemReturned = nextItem;
             index--;
             return lastItemReturned.data;
        }
        /**
         * removing element and adding removed linkedlist
         */
		@Override
		public void remove() {
			 if(nextItem==null)
                 throw new IllegalStateException();
             if(nextItem.prev!=null && nextItem.next!=null) {
                 nextItem.prev.next=nextItem.next;
                 nextItem.next.prev=nextItem.prev;
                 removed.tail.next=nextItem;
                 nextItem.prev=removed.tail;
                 removed.tail=nextItem;
                 removed.tail.next=null;
                 
             }
             else if(nextItem.prev!=null && nextItem.next==null){
                 deq.tail=nextItem.prev;
                 deq.tail.next=null;
                 removed.tail.next=nextItem;
                 nextItem.prev=removed.tail;
                 removed.tail=nextItem;
                 removed.tail.next=null;
             }
             else if(nextItem.prev==null && nextItem.next!=null){
            	  removed.tail.next=nextItem;
                  nextItem.prev=removed.tail;
                  removed.tail=nextItem;
                  removed.tail.next=null;
                 nextItem=nextItem.next;
                 nextItem.prev=null;
                 deq.head=nextItem;
                
             }
             else {
            	  removed.tail.next=nextItem;
                  nextItem.prev=removed.tail;
                  removed.tail=nextItem;
                  removed.tail.next=null;
                 nextItem=null;
                 deq.head=null;
                 deq.tail=null;
                 
             }
             deq.size--;
		}
        
        
	}
	
	public void print() {
		deq.printForward();
	}
	/**
	 * This is for removed linkedlist
	 */
	public void rprint() {
		removed.printForward();
	}

	/**
	 * Adding first side , If removed linked list has a node then it uses it 
	 */
	@Override
	public void addFirst(E obj) {
		if(removed.size==0) {
			deq.addFirst(obj);
		}
		else {
			if(deq.head==null) {
				LinkedList<E>.Node<E> temp=removed.tail;
				removed.tail=removed.tail.prev;
				deq.head=temp;
				if(deq.tail==null) {
					deq.tail=deq.head;
				}
				
			}
			else {
				LinkedList<E>.Node<E> temp=removed.tail;
				if(removed.tail!=removed.head) {	
					removed.tail=removed.tail.prev;
					removed.tail.next=null;
				}
				else {
					removed.tail=null;
					removed.head=null;
				}
				if(deq.head!=null) {
					deq.head.prev=temp;
					temp.next=deq.head;
				}
				
				deq.head=temp;
				if(deq.tail==null) {
					deq.tail=temp;
				}
				
			}
			deq.head.data=obj;
			deq.size++;
			removed.size--;
		}
		
		
	}

	
	@Override
	public boolean add(E e) {
		addLast(e);
		return true;
	}


	/**
	 * descenging Iterator method
	 * @return iterator
	 */
	@Override
	public Iterator<E> descendingIterator() {
		MyIteratorForDescending temp=new MyIteratorForDescending(0);
		return temp;
	}
	/**
	 * Iterator method
	 * @return iterator
	 */
	@Override
	public Iterator<E> iterator() {
		MyIterator temp=new MyIterator(0);
		return temp;
	}




	/**
	 * This is adding last ,If removed linkedlist has a node then it uses that node
	 */
	@Override
	public void addLast(E obj) {
		if(removed.size()==0) {
			deq.addLast(obj);
		}
		else {
			if(deq.tail==null) {
				LinkedList<E>.Node<E> temp=removed.tail;
				removed.tail=removed.tail.prev;
				deq.tail=temp;
				if(deq.head==null) {
					deq.head=deq.tail;
				}
				
			}
			else {
				LinkedList<E>.Node<E> temp=removed.tail;
				if(removed.tail!=removed.head) {
					removed.tail=removed.tail.prev;
					removed.tail.next=null;
				}
				
				else {
					removed.tail=null;
					removed.head=null;
				}
				if(deq.tail!=null) {
					deq.tail=temp.prev;
					if(deq.tail!=null)
						deq.tail.next=temp;
					
				}
				deq.tail=temp;
				if(deq.head==null) {
					deq.head=temp;
				}
				deq.tail.next=null;
				
			}
			deq.tail.data=obj;
			deq.size++;
			removed.size--;
			
			
		}
	}


	/**
	 * @return first element of deque
	 */
	@Override
	public E element() {
		return deq.getFirst();
	}



	/**
	 * @return first element of deque
	 */
	@Override
	public E getFirst() {
		return deq.getFirst();
	}



	/**
	 * @return last element of deque
	 */
	@Override
	public E getLast() {
		return deq.getLast();
	}



	/**
	 * adds last of deque
	 * @return true if it added
	 */
	@Override
	public boolean offer(E obj) {
		addLast(obj);
		return true ;
	}



	/**
	 * add first of the deque
	 * @return true if it added
	 */
	@Override
	public boolean offerFirst(E obj) {
			addFirst(obj);
			return true;
	}



	/**
	 * adds last of the deque
	 * @return true if added
	 */
	@Override
	public boolean offerLast(E obj) {
		addLast(obj);
		return true;
	}



	/**
	 * @return first element of deque
	 */
	@Override
	public E peek() {
		if(deq.head!=null) {
			return deq.getFirst();
		}
		return null;
	}



	/**
	 * @return first element of deque
	 */
	@Override
	public E peekFirst() {
		if(deq.head!=null) {
			return deq.getFirst();
		}
		return null;
	}



	/**
	 * @return last element of deque
	 */
	@Override
	public E peekLast() {
		if(deq.tail!=null) {
			return deq.getLast();
		}
		return null;
	}



	/**
	 * It removes first element from deque linkedlist then adds removed linkedlist
	 * @return removed element
	 */
	@Override
	public E poll() {
		if(deq.size!=0) {
				if(removed.tail==null) {
					removed.tail=deq.head;
					if(removed.head==null) {
						removed.head=removed.tail;
					}
					if(deq.tail!=deq.head)
						deq.head=deq.head.next;
					else
						deq.head=null;
					deq.size--;
					removed.tail.next=null;
					removed.size++;
				}
				else {
						removed.tail.next=deq.head;
						removed.tail=deq.head;
						if(removed.head==null) {
							removed.head=deq.head;
						}
						deq.head=deq.head.next;
						deq.size--;
						removed.tail.next=null;
						removed.size++;
				}
				
				
				return removed.getLast();

		}
		else
			return null;
	}



	/**
	 * It removes first element from deque linkedlist then adds removed linkedlist
	 * @return removed element
	 */
	@Override
	public E pollFirst() {
		return poll();
	}



	/**
	 * It removes last element from deque linkedlist then adds removed linkedlist
	 * @return removed element
	 */
	@Override
	public E pollLast() {
		if(deq.size!=0) {
			if(removed.tail==null) {
				removed.tail=deq.tail;
				if(removed.head==null) {
					removed.head=removed.tail;
				}
				if(deq.tail!=deq.head)
					deq.tail=deq.tail.prev;
				deq.tail.next=null;
				deq.size--;
				removed.tail.next=null;
				removed.size++;
			}
			else {
					removed.tail.next=deq.tail;
					removed.tail=deq.tail;
					if(removed.head==null) {
						removed.head=deq.tail;
					}
					deq.tail=deq.tail.prev;
					deq.tail.next=null;
					deq.size--;
					removed.tail.next=null;
					removed.size++;
			}
			return removed.getLast();

	}
	else
		return null;
	}



	/**
	 * It removes first element from deque linkedlist then adds removed linkedlist
	 * @return removed element
	 */
	@Override
	public E pop() {
		return poll();
	}



	/**
	 * Adding first side , If removed linked list has a node then it uses it 
	 */
	@Override
	public void push(E obj) {
		addFirst(obj);
		
	}



	/**
	 * It removes first element from deque linkedlist then adds removed linkedlist
	 * @return removed element
	 */
	@Override
	public E remove() {
		return poll();
	}



	/**
	 * It removes first element from deque linkedlist then adds removed linkedlist
	 * @return removed element
	 */
	@Override
	public E removeFirst() {
		return poll();
	}



	/**
	 * It removes first occurrence of deque linked list and adds to removed linked list 
	 * @return true it it removed
	 */
	@Override
	public boolean removeFirstOccurrence(Object obj) {
		LinkedList<E>.Node<E> temp=deq.head;
		while(temp!=null) {
			if(temp.data.equals(obj)) {
				if(temp==deq.head) {
					poll();
				}
				else if(temp==deq.tail) {
					pollLast();
				}
				else {
					temp.prev.next=temp.next;
					temp.next.prev=temp.prev;
					removed.tail.next=temp;
					temp.prev=removed.tail;
					temp.next=null;
					removed.tail=temp;
				}
				return true;
			}
			temp=temp.next;
		}
		return false;
	}



	/**
	 * It removes last element from deque linkedlist then adds removed linkedlist
	 * @return removed element
	 */
	@Override
	public E removeLast() {
		return pollLast();
	}



	/**
	 * @return true if it is full
	 */
	@Override
	public boolean isEmpty() {
		return deq.size==0;
	}

	/**
	 * It removes last occurrence of deque linked list and adds to removed linked list 
	 * @return true it it removed
	 */
	@Override
	public boolean removeLastOccurrence(Object obj) {
		LinkedList<E>.Node<E> temp=deq.head;
		int check=0;
		int checktwo=0;
		while(temp!=null) {
			if(temp.data.equals(obj)) {
				check++;
			}
			temp=temp.next;
		}
		temp=deq.head;
		while(temp!=null) {
			if(temp.data.equals(obj)) {
				checktwo++;
				if(checktwo==check) {
					if(temp==deq.head) {
						poll();
					}
					else if(temp==deq.tail) {
						pollLast();
					}
					else {
						temp.prev.next=temp.next;
						temp.next.prev=temp.prev;
						removed.tail.next=temp;
						temp.prev=removed.tail;
						temp.next=null;
						removed.tail=temp;
					}
					return true;
				}
			}
			temp=temp.next;
		}
		return false;
	}


	/**
	 * @return size of deque
	 */
	@Override
	public int size() {
		return deq.size();
	}



	/**
	 * This is Linked List Class
	 * @author mustafa
	 *
	 * @param <E>
	 */
	public class LinkedList<E>{
	    private Node<E> head=null;
	    private Node<E> tail=null;
	    private int size=0;
	    /**
	     * This is Node Class 
	     * @author mustafa
	     *
	     * @param <E>
	     */
	        public class Node<E>{
	            private E data;
	            private Node<E> next ;
	            private Node<E> prev ;

	            @SuppressWarnings("unchecked")
	                    Node() {
	                next=null;
	                prev=null;
	            }


	            @SuppressWarnings("unchecked")
	                    Node(E dataItem, Node<E> nodeRef,Node<E> nodeRefPrev) {
	                data=dataItem;
	                prev = nodeRefPrev;
	                next = nodeRef;
	            }

	        }
	        /**
	         * This is ListIterator
	         * @author mustafa
	         *
	         */
	        public class ListIterator{
	            private Node<E> nextItem;
	            private Node<E> lastItemReturned;
	            private int index;
	            public ListIterator(int i) {
	                // Validate i parameter.
	                if (i < 0 || i > size) {
	                    throw new IndexOutOfBoundsException("Invalid index " + i);
	                }
	                lastItemReturned = null; // No item returned yet.
	                // Special case of last item.
	                if (i == size) {
	                    index = size;
	                    nextItem = null;
	                } else { // Start at the beginning
	                    nextItem = head;
	                    for (index = 0; index < i; index++) {
	                        nextItem = nextItem.next;
	                    }
	                }
	            }
	            /**
	             * 
	             * @return true if it has next 	             
	             */
	            public boolean hasNext() {
	                return nextItem != null;
	            }
	            /**
	             * 
	             * @return next element
	             */
	            public E next() {
	                if (!hasNext()) {
	                    throw new IndexOutOfBoundsException();
	                }
	                lastItemReturned = nextItem;
	                nextItem = nextItem.next;
	                index++;
	                return lastItemReturned.data;
	            }
	            /**
	             * 
	             * @return true if it has previous
	             */
	            public boolean hasPrevious() {
	                return (nextItem == null && size != 0)
	                        || nextItem.prev != null;
	            }
	            /**
	             * 
	             * @return previous element 
	             * @throws if it has no element then throws index out of bound exception
	             */
	            public E previous() {
	                if (!hasPrevious()) {
	                    throw new IndexOutOfBoundsException();
	                }
	                if (nextItem == null) { // Iterator is past the last element
	                    nextItem = tail;
	                } else {
	                    nextItem = nextItem.prev;
	                }
	                lastItemReturned = nextItem;
	                index--;
	                return lastItemReturned.data;
	            }
	            /**
	             * 
	             * @return next Index if next is size then returns size
	             */
	            public int nextIndex(){
	                if(index+1==size)
	                    return size;
	                return index+1;
	            }
	            /**
	             * 
	             * @return previous index if previous is equal 0 then it returns -1
	             */
	            public int previousIndex(){
	                if(index==0)
	                    return -1;
	                return index-1;
	            }
	            /**
	             * adding linked list
	             * @param obj
	             */
	            public void add(E obj) {
	                if (head == null) { // Add to an empty list.
	                    Node<E> temp = new Node<E>(obj,head,null);
	                    head=temp;
	                    if(tail==null) {
	                        tail = temp;
	                    }
	                }
	                else if(nextItem==head){
	                    Node<E> newNode= new  Node<E>(obj,head,null);
	                    nextItem.prev = newNode;  // Step 2
	                    // The new node is now the head.
	                    head = newNode;
	                }
	                else if(nextItem == null){
	                    Node<E> newNode = new Node<E>(obj,null,tail);
	                    tail.next = newNode;
	                    newNode.prev = tail;
	                    tail = newNode;
	                }
	                else{
	                    Node<E> newNode = new Node<E>(obj,null,tail);
	                    newNode.prev = nextItem.prev; // Step 1
	                    nextItem.prev.next = newNode; // Step 2
	                    // Link it to the nextItem.
	                    newNode.next = nextItem; // Step 3
	                    nextItem.prev = newNode; // Step 4
	                }
	                size++;
	                index++;
	                lastItemReturned = null;
	            }
	            /**
	             * set current element
	             * @param obj
	             */
	            public void set(E obj){
	                if(nextItem==null)
	                    throw new IllegalStateException();
	                nextItem.data=obj;
	            }
	            /**
	             * remove element from linked list
	             */
	            public void remove(){
	                if(nextItem==null)
	                    throw new IllegalStateException();
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
	            /**
	             * @return current element
	             */
	            public E get(){
	                if(nextItem==null)
	                    throw new IllegalStateException();
	                return nextItem.data;
	            }
	        }
	        /**
	         * adding to last
	         * @param obj
	         */
	        public void add(E obj){
	            addLast(obj);
	        }
	        /**
	         * adding obj to index
	         * @param index
	         * @param obj
	         */
	        public void add(int index, E obj)
	        {
	            listIterator(index).add(obj);
	        }
	        /**
	         * getting element
	         * @param index
	         * @return element 
	         */
	        public E get(int index) {
	                return
	                        listIterator(index).next();
	        }
	        /**
	         * adds first 
	         * @param item
	         */
	        public void addFirst(E item) {
	            add(0, item);
	        }
	        /**
	         * add last
	         * @param item
	         */
	        public void addLast(E item) {
	            add(size, item);
	        }
	        /**
	         * get first
	         * @return
	         */
	        public E getFirst() {
	            return head.data;
	        }
	        /**
	         * get last
	         * @return
	         */
	        public E getLast() {
	            return tail.data;
	        }
	        /**
	         * 
	         * @return true if it is full
	         */
	        public boolean isEmpty() {
	            return size==0;
	        }
	        /**
	         * clears the list
	         */
	        public void clear() {
	            this.head=null;
	            this.tail=null;
	            size=0;
	        }
	        /**
	         * ListIterator
	         * @return
	         */
	        public  ListIterator listIterator() {
	            ListIterator temp= new ListIterator(0);
	            return temp;
	        }
	        /**
	         * This method is ListIteretor that begins index
	         * @param index
	         * @return
	         */
	        public  ListIterator listIterator(int index) {
	            ListIterator temp= new ListIterator(index);
	            return temp;
	        }
	        /**
	         * It removed element
	         * @param index
	         * @return removed element
	         */
	        public E remove(int index){
	            E temp = listIterator(index).get();
	            listIterator(index).remove();
	            return temp;
	        }
	        /**
	         * sets the element
	         * @param index
	         * @param obj
	         * @return setted element
	         */ 
	        public E set(int index,E obj){
	            E temp = listIterator(index).get();
	            listIterator(index).set(obj);
	            return temp;
	        }
	        /**
	         * returns index of obj
	         * @param obj
	         * @return index
	         */
	        public int indexOf(E obj){
	            Node<E> temp=head;
	            int i=0;
	            while(temp!=null){
	                if(temp.data==obj){
	                    return i;
	                }
	                i++;
	                temp=temp.next;
	            }
	            return -1;

	        }
	        /**
	         * returns size
	         * @return
	         */
	        public int size(){
	            return size;
	        }
	        /**
	         * removes given obj
	         * @param obj
	         * @return removed element
	         */
	        public boolean remove(Object obj){
	            Node<E> temp=head;
	            int i=0;
	            while(temp!=null){
	                if(temp.data==obj){
	                    listIterator(i).remove();
	                    return true;
	                }
	                i++;
	                temp=temp.next;
	            }
	            return false;
	        }
	        /**
	         * printing forward
	         */
	    public void printForward(){

	        System.out.println("iterating forward..");
	        Node<E> tmp = head;
	        while(tmp != null){
	                System.out.println(tmp.data);
	            tmp = tmp.next;
	        }
	    }

	}
		
}
