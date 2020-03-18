/**
 * This class adding and removing cargos and customers
 * @author Mustafa Tokgöz 171044077
 *
 */
public class BranchEmployees {
	Cargo[] cargos;
	Customer[] customers;
	private int cargosize;
	private int cargocapacity;
	private int customersize;
	private int customercapacity;
	/**
	 * This is getter for cargo size
	 * @return
	 */
	public int getCargosize() {
		return cargosize;
	}
	/**
	 * This is setter for cargo size
	 * @param cargosize
	 */
	public void setCargosize(int cargosize) {
		this.cargosize = cargosize;
	}
	/**
	 * This is getter for cargocapacity
	 * @return
	 */
	public int getCargocapacity() {
		return cargocapacity;
	}
	/**
	 * This is setter for cargocapacity
	 * @param cargocapacity
	 */
	public void setCargocapacity(int cargocapacity) {
		this.cargocapacity = cargocapacity;
	}
	/**
	 * This is getter for customer size
	 * @return
	 */
	public int getCustomersize() {
		return customersize;
	}
	/**
	 * This is setter for customer size
	 * @param customersize
	 */
	public void setCustomersize(int customersize) {
		this.customersize = customersize;
	}
	/**
	 * This is getter for customer capacity
	 * @return
	 */
	public int getCustomercapacity() {
		return customercapacity;
	}
	/**
	 * This is setter for customer capacity
	 * @param customercapacity
	 */
	public void setCustomercapacity(int customercapacity) {
		this.customercapacity = customercapacity;
	}
	/**
	 * This is no parameter constructer that initilize the data fields
	 */
	public BranchEmployees() {
		cargos = new Cargo[10];
		cargocapacity=10;
		cargosize=0;
		
		customers = new Customer[10];
		customercapacity=10;
		customersize=0;
		
	}
	/**
	 * This method adding Customer to Branch Employee
	 * @param newcustomer
	 */
	public void addCustomer(Customer newcustomer) {
		if(customersize==customercapacity) {
			Customer[] temp = new Customer[customercapacity*2];
			for(int i=0;i<customercapacity;i++) {
				temp[i]=customers[i];
			}
			customers = temp;
			customercapacity = customercapacity*2;
		}
		
		customers[customersize]=newcustomer;
		customersize++;
	}
	/**
	 * This method is removing customer from that index employee
	 * @param index
	 */
	public void removeCustomer(int index) {
	        for (int j = index;j<customersize-1;j++) {
	            customers[j] = customers[j + 1];
	        }
	        customersize--;
	 }
	
	
	/**
	 * This is adding new cargo to that branch employee
	 * @param newcargo
	 */
	public void addCargo(Cargo newcargo) {
		if(cargosize==cargocapacity) {
			Cargo[] temp= new Cargo[cargocapacity*2];
			for(int i=0;i<cargocapacity;i++) {
				temp[i]=cargos[i];
			}
			cargos=temp;
			cargocapacity = cargocapacity*2;
		}
		cargos[cargosize]=newcargo;
		cargosize++;
	}
	/**
	 * This is removing cargo from that index employee
	 * @param index
	 */
	 public void removeCargo(int index) {
	        for (int j = index;j<cargosize-1;j++) {
	            cargos[j] = cargos[j + 1];
	        }
	        cargosize--;
	 }
	
	
	
}
