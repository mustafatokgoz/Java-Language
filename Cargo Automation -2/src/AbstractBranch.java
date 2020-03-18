/**
 * This Abstract Class for Branch Class 
 * @author Mustafa Tokgöz 171044077
 *
 */
public abstract class AbstractBranch extends EnteringSystem{
	public abstract int getEmployeesize();
	public abstract BranchEmployees getEmployees(int index);
	public abstract TransportationPersonel getPersonel(int index);
	public abstract int getPersonelsize();
	public abstract void addEmployee(BranchEmployees anemployee);
	public abstract void removeEmployee(int index);
	public abstract void addPersonel(TransportationPersonel apersonel);
	public abstract void removePersonel(int index);
	public abstract Cargo getCargo(int index);
	public abstract Customer getCustomer(int index);
	public abstract int getCargosize();
	public abstract int getCustomersize();
	public abstract void addCustomer(Customer newcustomer);
	public abstract void removeCustomer(int index);
	public abstract void addCargo(Cargo newcargo);
	public abstract void removeCargo(int index);
}
