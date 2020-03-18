import java.util.ArrayList;
/**
 * This is Branch class that add and remove branch employees , transportation personel , cargos and customers 
 * @author Mustafa Tokgöz 171044077
 *
 */
public class Branch extends AbstractBranch{

	/**
	 * This is branch employee arraylist
	 * @param employees
	 */
	 private ArrayList<BranchEmployees> employees=new ArrayList<BranchEmployees>();

	/**
	 * This is transportation personel arraylist
	 * @param personel
	 */
	private ArrayList<TransportationPersonel> personel=new ArrayList<TransportationPersonel>();
	/**
	 * This is cargos arraylist to keep cargos
	 */
	private ArrayList<Cargo> cargos=new ArrayList<Cargo>();
	/**
	 * This is customers arraylist to keep customers
	 */
	private ArrayList<Customer> customers= new ArrayList<Customer>();
	
	/**
	 * This is getter for employee size
	 * @return
	 */
	@Override
	public int getEmployeesize() {
		return employees.size();
	}
	/**
	 * This is getEmployees method to get employees' i'th index
	 * @param index
	 * @return  BranchEmployees like employees[index];
	 */
	@Override
	public BranchEmployees getEmployees(int index) {
		if(index<0 || index>employees.size()-1) {
			 throw new ArrayIndexOutOfBoundsException();
		}
		return employees.get(index);
	}
	/**
	 * This is getPersonelmethod to get personel's i'th index
	 * @param index
	 * @return TransporatitonPersonel like parsonel[i];
	 */
	@Override
	public TransportationPersonel getPersonel(int index) {
		if(index<0 || index>personel.size()-1) {
			 throw new ArrayIndexOutOfBoundsException();
		}
		return personel.get(index);
	}

	/**
	 * This is getter for personel size
	 * @return
	 */
	@Override
	public int getPersonelsize() {
		return personel.size();
	}


	/**
	 * This method adding employee to branch
	 */
	@Override
	public void addEmployee(BranchEmployees anemployee) {
		employees.add(anemployee);
	}
	/** 
	 * This method is removing employee from branch
	 * @param index
	 */
	@Override
	public void removeEmployee(int index) {
		if(index<0 || index>employees.size()-1) {
			 throw new ArrayIndexOutOfBoundsException();
		}
		employees.remove(index);
	}
	/**
	 * This method is adding personel to branch 
	 */
	@Override
	public void addPersonel(TransportationPersonel apersonel) {
		personel.add(apersonel);
	}
	/**
	 * This is removing personel from branch
	 * @param index
	 */
	@Override
	public void removePersonel(int index) {
		if(index<0 || index>personel.size()-1) {
			 throw new ArrayIndexOutOfBoundsException();
		}
		personel.remove(index);
	}
	
	/**
	 * This is getting cargo with index int index
	 * @param index
	 * @return Cargo like cargos[index]
	 */
	@Override
	public Cargo getCargo(int index) {
		if(index<0 || index>cargos.size()-1) {
			 throw new ArrayIndexOutOfBoundsException();
		}
		return cargos.get(index);
		
	}
	/**
	 * This is getting customer with index index
	 * @param index
	 * @return Customer like custmers[index]
	 */
	@Override
	public Customer getCustomer(int index) {
		if(index<0 || index>customers.size()-1) {
			 throw new ArrayIndexOutOfBoundsException();
		}
		return customers.get(index);
	}


	/**
	 * This is getter for cargo size
	 * @return
	 */
	@Override
	public int getCargosize() {
		return cargos.size();
	}


	/**
	 * This is getter for customer size
	 * @return
	 */
	@Override
	public int getCustomersize() {
		return customers.size();
	}
	/**
	 * This is addşng customer to customers arraylist
	 * @param newcustomer
	 */
	@Override
	public void addCustomer(Customer newcustomer) {
		customers.add(newcustomer);
	}
	/**
	 * This is removing customer from customers
	 * @param index
	 */
	@Override
	public void removeCustomer(int index) {
		if(index<0 || index>customers.size()-1) {
			 throw new ArrayIndexOutOfBoundsException();
		}
		customers.remove(index);
	}
	/**
	 * This is adding cargo to cargos
	 * @param newcargo
	 */
	@Override
	public void addCargo(Cargo newcargo) {
		cargos.add(newcargo);
	}
	/**
	 * This is removing cargo from cargos
	 * @param index
	 */
	@Override
	public void removeCargo(int index) {
		if(index<0 || index>cargos.size()-1) {
			 throw new ArrayIndexOutOfBoundsException();
		}
		cargos.remove(index);
	}
	/**
	 * This is method to login the system for branch 
	 * @param pw
	 * @return true if branch employee or transportation personel enter the correct password else false
	 */
	@Override
	public boolean login(String pw) {
		if(getPassword().equals(pw)) {
			return true;
		}
		return false;
	}
	
}
