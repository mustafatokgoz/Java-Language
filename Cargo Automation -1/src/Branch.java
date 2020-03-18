/**
 * This is Branch class that add and remove branch employees and transportation personels
 * @author Mustafa Tokgöz 171044077
 *
 */
public class Branch {

	/**
	 * This is branch employee array
	 * @param employees
	 */
	 BranchEmployees employees[];
	 /**
	  * These are data fields for employee array
	  * @param employeesize and employeecapacity
	  */
	 private int employeesize;
	private int employeecapacity;
	
	/**
	 * This is transportation personel array
	 * @param personel
	 */
	TransportationPersonel personel[];
	/**
	 * These are data fields for personel array
	 * @param personelsize and personelcapacity
	 */
	private int personelsize;
	private int personelcapacity;
	/**
	 * This is no parameter constructer that inititalize the fields
	 */
	Branch(){

		
		employeesize=0;
		employeecapacity=10;
		employees = new BranchEmployees[10];
		
		personelsize=0;
		personelcapacity=10;
		personel = new TransportationPersonel[10];
	}
	/**
	 * This is getter for employee size
	 * @return
	 */
	public int getEmployeesize() {
		return employeesize;
	}
	/**
	 * This is setter for employeesize
	 * @param employeesize
	 */
	public void setEmployeesize(int employeesize) {
		this.employeesize = employeesize;
	}
	/**
	 * This is getter for employeecapacity
	 * @return
	 */
	public int getEmployeecapacity() {
		return employeecapacity;
	}
	/**
	 * This is setter for employee capacity
	 * @param employeecapacity
	 */
	public void setEmployeecapacity(int employeecapacity) {
		this.employeecapacity = employeecapacity;
	}
	/**
	 * This is getter for personel size
	 * @return
	 */
	public int getPersonelsize() {
		return personelsize;
	}
	/**
	 * This is setter for personel size
	 * @param personelsize
	 */
	public void setPersonelsize(int personelsize) {
		this.personelsize = personelsize;
	}
	/**
	 * This is getter for personel capacity
	 * @return
	 */
	public int getPersonelcapacity() {
		return personelcapacity;
	}
	/**
	 * This is setter for personel capacity
	 * @param personelcapacity
	 */
	public void setPersonelcapacity(int personelcapacity) {
		this.personelcapacity = personelcapacity;
	}
	/**
	 * This method adding employee to branch
	 */
	public void addEmployee(BranchEmployees anemployee) {
		if(employeesize==employeecapacity) {
			BranchEmployees[] temp = new BranchEmployees[employeecapacity*2];
			for(int i=0;i<employeecapacity;i++) {
				temp[i]=employees[i];
			}
			employees=temp;
			employeecapacity =employeecapacity*2;
		}
		employees[employeesize]=anemployee;
		employeesize++;
	}
	/** 
	 * This method is removing employee from branch
	 * @param index
	 */
	public void removeEmployee(int index) {
		for(int j=index;j<employeesize-1;j++) {
			employees[j]=employees[j+1];
		}
		employeesize--;
	}
	/**
	 * This method is adding personel to branch 
	 */
	public void addPersonel(TransportationPersonel apersonel) {
		if(personelsize==personelcapacity) {
			TransportationPersonel[] temp = new TransportationPersonel[personelcapacity*2];
			for(int i=0;i<personelsize;i++) {
				temp[i]=personel[i];
			}
			personel=temp;
			personelcapacity=personelcapacity*2;
		}
		personel[personelsize]=apersonel;
		personelsize++;
	}
	/**
	 * This is removing personel from branch
	 * @param index
	 */
	
	public void removePersonel(int index) {
		for(int j=index;j<personelsize-1;j++) {
			personel[j]=personel[j+1];
		}
		personelsize--;
	}
}
