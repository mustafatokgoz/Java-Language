/**
 * Administartor Class
 * @author mustafa
 *
 */
public class Administrator{
	private SearchTree<Software> softwares;
	/**
	 * No parameter constructor
	 * It creates binarysearchtree but it can be changes any class that extends searchtree class
	 */
	Administrator(){
		softwares= new BinarySearchTree<Software>();
	}
	/**
	 * add method
	 * @param item
	 * @return
	 */
	public boolean add(Software item) {
		return softwares.add(item);
	}
	/**
	 * contains method
	 * @param target
	 * @return
	 */
	public boolean contains(Software target) {
		return softwares.contains(target);
	}
	/**
	 * find method
	 * @param target
	 * @return
	 */
	public Software find(Software target) {
		return softwares.find(target);
	}
	/**
	 * delete method
	 * @param target
	 * @return
	 */
	public Software delete(Software target) {
		return softwares.delete(target);
	}
	/**
	 * remove method
	 */
	public boolean remove(Software target) {
		return softwares.remove(target);
	}
	/**
	 * It increases quantity of given name software
	 * @param name
	 * @return
	 */
	public boolean increaseQuantity(String name) {
		Software temp= softwares.find(new Software(name,0,0));
		if(temp!=null) {
			Software temp2=new Software(temp.getName(),temp.getQuantity()+1,temp.getPrice());
			softwares.remove(temp);
			softwares.add(temp2);
			return true;
		}
		return false;
	}
	/**
	 * It decreases quantity of given name software to update
	 * @param name
	 * @return
	 */
	public boolean decreaseQuantity(String name) {
		Software temp= softwares.find(new Software(name,0,0));
		if(temp!=null) {
			if(temp.getQuantity()>1) {
				Software temp2=new Software(temp.getName(),temp.getQuantity()-1,temp.getPrice());
				softwares.remove(temp);
				softwares.add(temp2);
			}
			else {
				softwares.remove(temp);
			}
			return true;
		}
		return false;
	}
	/**
	 * Setting price of software 
	 * @param name
	 * @param price
	 */
	public void setPriceofSoftware(String name,double price) {
		Software temp= softwares.find(new Software(name,0,0));
		if(temp!=null) {
			Software temp2=new Software(temp.getName(),temp.getQuantity(),price);
			softwares.remove(temp);
			softwares.add(temp2);
		}
	}
	/**
	 * Setting name of the software 
	 * @param oldName
	 * @param newName
	 */
	public void setNameofSoftware(String oldName, String newName) {
		Software temp= softwares.find(new Software(oldName,0,0));
		if(temp!=null) {
			Software temp2=new Software(newName,temp.getQuantity(),temp.getPrice());
			softwares.remove(temp);
			softwares.add(temp2);
		}
	}
	/**
	 * Showing softwares
	 */
	public void showSoftwares() {
		System.out.println(softwares.toString());
	}
	/**
	 * Shows specific software
	 * @param Name
	 */
	public void showSoftware(String Name) {
		Software temp= softwares.find(new Software(Name,0,0));
		if(temp!=null)
			System.out.println(temp.toString());
	}
}
