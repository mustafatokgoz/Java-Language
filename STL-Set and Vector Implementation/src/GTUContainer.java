/**
 * This abstract class for GTUSet and GTUVector
 * @author Mustafa Tokgöz
 *
 * @param <T>
 */
public abstract class GTUContainer<T>{
		protected T[] data;
		protected int used;
		protected int capacity;
		
		/**
		 * This GTUIterator Class to show Set's and Vector's inside
		 * @author mustafa
		 *
		 */
		@SuppressWarnings({"unchecked"})
		class GTUIterator{
			private int indexnumber;
			private T[] it;
				/**
				 * This is GTUIterator contractor with no parameter
				 */
				public GTUIterator(){
					indexnumber=0;
					it=(T[]) new Object[10];
				}
				/**
				 * This is GTUIterator constractor with E type parameter
				 * @param ptr
				 */
		        public GTUIterator (T[] ptr){
		            indexnumber = 0;
		            it=ptr;
		        }
		        /**
		         * This method is used Iterator has next or not
		         * @return
		         */
				public boolean hasNext() {
					if(indexnumber<used) {
						return true;
					}
					else
						return false;
				}
				/**
				 * This method returns the inside of iterator
				 * @return
				 */
				T next() {
					indexnumber++;
					return it[indexnumber-1];
				}

		}
		/**
		 * This empty method is abstract for Set and Vector
		 * @return
		 */
		public abstract boolean empty();
		/**
		 * This size method is abstract for Set and Vector
		 * @return
		 */
		public abstract int size();
		/**
		 * This max_size method is abstract for Set and Vector
		 * @return
		 */
		public abstract int max_size();
		/**
		 * This insert method is abstract for Set and Vector
		 * @param number
		 */
		public abstract void insert(T value);
		/**
		 * This erase method is abstract for Set and Vector
		 * @param number
		 */
		public abstract void erase(T value);
		/**
		 * This clear method is abstract for Set and Vector
		 * @return
		 */
		public abstract void clear();
		/**
		 * This iterator method is abstract for Set and Vector
		 * @return
		 */
		public abstract GTUIterator iterator();
		/**
		 * This contains method is abstract for Set and Vector
		 * @param o
		 * @return
		 */
		public abstract boolean contains(Object o);
}
