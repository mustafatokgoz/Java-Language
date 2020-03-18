/**
 * This class adding and removing cargos and customers
 * @author Mustafa Tokgöz 171044077
 *
 */
public class BranchEmployees{

	/**
	 * This method adding Customer to Branch Employee
	 * @param newcustomer
	 */
	public void addCustomer(Branch thatbranch,Customer newcustomer) {
		thatbranch.addCustomer(newcustomer);

	}
	/**
	 * This method is removing customer from that index employee
	 * @param index
	 */
	public void removeCustomer(Branch thatbranch,int index) {
			thatbranch.removeCustomer(index);
	 }
	
	
	/**
	 * This is adding new cargo to that branch employee
	 * @param newcargo
	 */
	public void addCargo(Branch thatbranch,Cargo newcargo) {
				thatbranch.addCargo(newcargo);
	}
	/**
	 * This is removing cargo from that index employee
	 * @param index
	 */
	 public void removeCargo(Branch thatbranch,int index) {
	   thatbranch.removeCargo(index);
	 }
	
	
	
}
