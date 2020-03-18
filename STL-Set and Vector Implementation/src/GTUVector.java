import java.lang.IllegalArgumentException;
/**
 * 
 * @author Mustafa Tokgöz
 *
 * @param <T>
 */
@SuppressWarnings({"unchecked"})
public class GTUVector<T> extends GTUContainer<T> {
		private int max=5000;
		/**
		 * This is GTUVector contructor with no parameter
		 */
		public GTUVector(){
			capacity=10;
			used=0;
			data =(T[]) new Object[capacity];
		}
		/**
		 * This is GTUVector constructer with int n parameter
		 * @param n
		 */
		public GTUVector(int n){
			if(n>0) {
				capacity=n;
				used=0;
				data =(T[]) new Object[capacity];
			}
			else {
				capacity=10;
				used=0;
				data =(T[]) new Object[capacity];
			}
		}
		/**
		 * This method is checking the GTUVector is empty or not
		 *  @return -If GTUVector is empty then returns true else returns false
		 */
	    public boolean empty(){
	        if(used==0) {
	        	return true;
	        }
	        else
	        	return false;
	    }
	    /**
	     * This method returning maximum size that is determined by me
	     */
		public int max_size() {
			return max;
		}
		/**
		 * This method is returning GTUVector's size
		 */
		public int size() {
			return used;
		}	
		/**
		 * This method clearing all inside of vector
		 */
		public void clear() {
			capacity=10;
			used=0;
			data=(T[])new Object[capacity];
		}
		/**
		 * This method returning a new GTUIterator with beginning of object
		 */
		public GTUIterator iterator() {
			GTUIterator temp= new GTUIterator(data);
			return temp;
		}
		/**
		 * This method erasing the values if there is a value like parameter
		 * @param value
		 */
		public void erase(T value) {
			for(int i=0;i<used;i++){
				if(data[i]==value){
					for(int j=i;j<used-1;j++){
						data[j]=data[j+1];
					}
					used--;
					i--;
				}
			}
		}
		/**
		 * This method inserting the value but if there in not enough space then it throws illegalargumantexeption
		 * @param value
		 */
		public void insert(T value) {	
			if(used==capacity) {	/*If used is equal capacity then it is increasing own capacity */
				capacity=capacity*2;
				T[] temp =(T[]) new Object[used];
				for(int i=0;i<used;i++) {
					temp[i]=data[i];
				}
				data=(T[])new Object[capacity];
				for(int i=0;i<used;i++) {
					data[i]=temp[i];
				}	
			}
			if(used<=max_size()){
				data[used]=value;
				used++;
			}
			else 
				throw new IllegalArgumentException(String.format("There is not enough space\n"));
			
			
		}
		/**
		 * This method is checking the object is there or not
		 * @param o
		 */
		public boolean contains(Object o) {
				for(int i=0;i<used;i++){		
					if(data[i]==o){
						return true;
					}
				}
			return false;
		}
		

}

