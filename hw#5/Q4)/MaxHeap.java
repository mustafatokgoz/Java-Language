import java.util.ArrayList;
import java.util.Comparator;

/**
 * MaxHeap Class implemets Comparator<AgeData>
 * @author mustafa
 *
 * @param <E>
 */
public class MaxHeap<E> implements Comparator<AgeData>{
		/**
		 * This is data arraylist
		 */
		private ArrayList<AgeData> max_heap=new ArrayList<AgeData>();
		/**
		 * contains method that check obj is in arraylist or not
		 * @param obj
		 * @return -1 if it does not contain or return index of object
		 */
		private int contains(AgeData obj) {
			for(int i=0;i<max_heap.size();i++) {
				if(max_heap.get(i).getAge()==obj.getAge())
					return i;
			}
			return -1;
		}
		/**
		 * Comparator method that compares objects 
		 */
		public static Comparator<AgeData> comparator = new Comparator<AgeData>() {
			@Override
	        public int compare(AgeData obj1, AgeData obj2) {
	            return obj1.compareTo(obj2);
	        }
		};
		/**
		 * Adding AgeData to arraylist in maximum heap version
		 * @param item
		 * @return
		 */
		public boolean add(AgeData item) {
			if(contains(item)!=-1) {
				int index=contains(item);
				
				max_heap.get(index).increaseNumOfPeople();
				int child = index;
				int parent = (child-1)/2; // Find child's parent.
				while(parent>=0 && compare(max_heap.get(parent),max_heap.get(child))<0) {
					swap(parent, child);
					child = parent;
					parent = (child-1)/2;
				}
				return true;
			}
			// Add the item to the heap.
			max_heap.add(item);
			return true;
		}
		/**
		 * swapping elments age and number of people
		 * @param parent
		 * @param child
		 */
		public void swap(int parent,int child) {
			int temp1=max_heap.get(parent).getAge();
			int temp2=max_heap.get(parent).getNumOfpeople();
			max_heap.get(parent).setAge(max_heap.get(child).getAge());
			max_heap.get(parent).setNumOfpeople(max_heap.get(child).getNumOfpeople());
			max_heap.get(child).setAge(temp1);
			max_heap.get(child).setNumOfpeople(temp2);
			
		}
		/**
		 * removes item in the arraylist in heap version
		 * @param item
		 */
		public void remove(AgeData item) {
			if (max_heap.isEmpty()) {
				return;
			}
				/* Remove the last item from the ArrayList and place it into
				the first position. */
			int index=contains(item);
			if(index!=-1) {
				if(max_heap.get(index).getNumOfpeople()>1)
					max_heap.get(index).decreaseNumOfPeople();
				else
					max_heap.remove(index);
					// The parent starts at the top.
					int parent = index;
					while (true) {
							int leftChild = 2 * parent + 1;
							if (leftChild >= max_heap.size()) {
								break; // Out of heap.
							}
							int rightChild = leftChild + 1;
							int minChild = leftChild; // Assume leftChild is smaller.
							// See whether rightChild is smaller.
							if (rightChild < max_heap.size() && compare(max_heap.get(leftChild),max_heap.get(rightChild)) < 0) {
								minChild = rightChild;
							}
							// assert: minChild is the index of the smaller child.
							// Move smaller child up heap if necessary.
							if (compare(max_heap.get(parent),max_heap.get(minChild)) < 0) {
								swap(parent, minChild);
								parent = minChild;
							} 
							else { // Heap property is restored.
								break;
							}
					}
			}
		}
		/**
		 * finds target if it does not contain then return target
		 * @param target
		 * @return
		 */
		public AgeData find(AgeData target) {
			if(contains(target)!=-1) {
				return max_heap.get(contains(target));
			}
			else
				return target;
		}
		/**
		 * Compare method that calls comparator
		 */
		public int compare(AgeData left, AgeData right) {
			 // A Comparator is defined.
				return comparator.compare(left, right);
		}
		/**
		 * toString method that calls private toSting method
		 */
		@Override
		public String toString() {
			StringBuilder sb=new StringBuilder();
			return toString(sb);
		}
		/**
		 * appends max_heap elements to sb 
		 * @param sb
		 * @return sb.toString() 
		 */
		private String toString(StringBuilder sb) {
			for(int i=0;i<max_heap.size();i++) {
				sb.append(max_heap.get(i).getAge()+" - "+max_heap.get(i).getNumOfpeople());
				sb.append("\n");
			}
			return sb.toString();
		}
		/**
		 * @param age
		 * @return number of people that is younger that age parameter
		 */
		public int youngerThan(int age) {
			int result=0;
			for(int i=0;i<max_heap.size();i++) {
				if(max_heap.get(i).getAge()<age) {
					result=result+max_heap.get(i).getNumOfpeople();
				}
			}
			return result;
		}
		/**
		 * @param age
		 * @return number of people that is older than age parameter
		 */
		public int olderThan(int age) {
			int result=0;
			for(int i=0;i<max_heap.size();i++) {
				if(max_heap.get(i).getAge()>age) {
					result=result+max_heap.get(i).getNumOfpeople();
				}
			}
			return result;
		}
		

		
}
