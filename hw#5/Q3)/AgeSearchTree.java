/**
 * This is AgeSearchTree Class that extends BinarySearchTree<E> class
 * @author mustafa
 *
 * @param <E>
 */
@SuppressWarnings("serial")
public class AgeSearchTree<E  extends Comparable<E>> extends BinarySearchTree<E>{
	/**
	 * BinarySearchTree for AgeData
	 */
	private BinarySearchTree<AgeData> datas;//=new BinarySearchTree<AgeData>();
	/**
	 * This is for younger and olderthan methods
	 */
	private int result;
	/**
	 * adding element to binarySerachTree if item is AgeData
	 */
	public AgeSearchTree() {
		datas=new BinarySearchTree<AgeData>();
		result=0;
	}
	@Override
	public boolean add(E item) {
		if(item instanceof AgeData) {
			AgeData temp=(AgeData)item;
			if(datas.contains(temp)==true) {
				datas.find(temp).increaseNumOfPeople();
				return true;
			}
			else {
				datas.add(temp);
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	/**
	 * This methods finds AgeData object
	 */
	@Override
	public E find(E target) {
		if(target instanceof AgeData) {
			AgeData temp=(AgeData)target;
			E temp2=(E)datas.find(temp);
			return temp2;
		}
		return target;
	}
	/**
	 * This method removes object from datas that is BinarySearchTree
	 */
	@Override
	public boolean remove(E target) {
		if(target instanceof AgeData) {
			AgeData temp=(AgeData)target;
			if(datas.contains(temp)==true) {
				if(datas.find(temp).getNumOfpeople()>1) {
					datas.find(temp).decreaseNumOfPeople();
					return true;
				}
				else 
					return datas.remove((AgeData)target);
			}
			else {
				return false;
			}
		}
		return false;
	}
	/**
	 * This is getter for age
	 * @return
	 */
	public int getAgeData() {
		return datas.getData().getAge();
	}
	/**
	 * toSting method
	 */
	@Override
	public String toString() {
		return datas.toString();
	}
	/**
	 * This is for private recursive method 
	 * @param young is age that is asked for comparing
	 * @return how many younger there are
	 */
	public int youngerThan(int young) {
		int temp;
		youngerThan(young,datas.root);
		temp=result;
		result=0;
		return temp;
	}
	/**
	 * This is recursive youngerThan method and if age is bigger than age , It doesn't traverse that subtree
	 * @param younger is age that is asked for comparing
	 * @param temp
	 */
	private void youngerThan(int younger,Node<AgeData> temp) {
		if(temp == null)
		        return ;
		if(temp.data.compareTo(new AgeData(younger))<0 ) {
		    	result += temp.data.getNumOfpeople();
		    	youngerThan(younger,temp.left);
		    	youngerThan(younger,temp.right);
		}	
		else {
		        youngerThan(younger,temp.left);
		}   
	} 
	/**
	 * This is for recursive call
	 * @param older is age that is asked for comparing
	 * @return how many people that is old
	 */
	public int olderThan(int older) {
		int temp;
		olderThan(older,datas.root);
		temp=result;
		result=0;
		return temp;
	}
	/**
	 * This is recursive olderThan method and if age is smaller than age , It doesn't traverse that subtree
	 * @param older is age that is asked for comparing
	 * @param temp
	 */
	private void olderThan(int older,Node<AgeData> temp) {
		if(temp == null)
	        return ;
		if(temp.data.compareTo(new AgeData(older))>0 ) {
			result += temp.data.getNumOfpeople();
			olderThan(older,temp.left);
	        olderThan(older,temp.right);
	    
		}	
		else {
			olderThan(older,temp.right);
		}   
	}
	
	
		
}
